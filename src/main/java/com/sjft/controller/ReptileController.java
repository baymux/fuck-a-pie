package com.sjft.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.date.DateUtil;
import com.sjft.common.ResponseResult;
import com.sjft.entity.*;
import com.sjft.forest.AmapClient;
import com.sjft.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mr.Baiyy
 * @version 1.0
 * @ClassName ReptileController
 * @Description 爬取所有数据
 * @date 2022/1/19 15:34
 **/
@RestController
@RequestMapping("/reptile")
public class ReptileController {

    private final ChartsService chartsService;
    private final ChartsPictureService chartsPictureService;
    private final ChartInfoService chartInfoService;
    private final AreaCodeService areaCodeService;
    private final AreaJsonService areaJsonService;


    private final AmapClient amapClient;

    public ReptileController(ChartsService chartsService, ChartsPictureService chartsPictureService, ChartInfoService chartInfoService, AreaCodeService areaCodeService, AreaJsonService areaJsonService, AmapClient amapClient) {
        this.chartsService = chartsService;
        this.chartsPictureService = chartsPictureService;
        this.chartInfoService = chartInfoService;
        this.areaCodeService = areaCodeService;
        this.areaJsonService = areaJsonService;
        this.amapClient = amapClient;
    }

    @GetMapping("/charts")
    public ResponseResult charts() {
        Thread t = new Thread(() -> {
            try {
                for (int i = 617; i < 660; i++) {
                    Map<String, Object> charts = amapClient.getCharts(i, (ex, request, response) -> {
                        int status = response.getStatusCode(); // 获取请求响应状态码
                        System.err.println(request + "====>" + status);
                    });
                    Map data = (Map) charts.get("data");
                    List<Map<String, Object>> chartsEntityList = (List<Map<String, Object>>) data.get("charts");
                    List<ChartsEntity> collect = chartsEntityList.stream().map(item -> {
                        CopyOptions copyOptions = new CopyOptions();
                        copyOptions.ignoreCase();
                        ChartsEntity chartsEntity = BeanUtil.mapToBean(item, ChartsEntity.class, true, copyOptions);
                        return chartsEntity;
                    }).collect(Collectors.toList());
                    chartsService.saveBatch(collect);
                    Thread.sleep(5000);
                    collect.forEach(item -> {
                        ChartsPictureEntity chartsPicture = new ChartsPictureEntity();
                        String cid = item.getCid();
                        String thumbnailUrl = item.getThumbnailUrl();


                        File file = amapClient.getChartsPicture("D:\\sjft\\fake-a-pie", null, thumbnailUrl, (ex, request, response) -> {
                            int status = response.getStatusCode(); // 获取请求响应状态码
                            System.err.println(request + "====>" + status);
                        });
                        if (file != null) {
                            byte[] b = new byte[0];
                            try {
                                b = Files.readAllBytes(Paths.get(file.getPath()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            String s = Base64.getEncoder().encodeToString(b);
                            chartsPicture.setCid(cid);
                            chartsPicture.setPicture(s);

                            chartsPicture.setPicturePath(file.getName());
                            chartsPicture.setCreateTime(DateUtil.date());
                            chartsPictureService.save(chartsPicture);
                        }


                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        // 代码，入库
                        Map<String, Object> chartsCode = amapClient.getChartsCode(cid, (ex, request, response) -> {
                            int status = response.getStatusCode(); // 获取请求响应状态码
                            System.err.println(request + "====>" + status);
                        });
                        if (chartsCode != null) {
                            Map<String, Object> codeMap = (Map<String, Object>) chartsCode.get("data");
                            CopyOptions copyOptions = new CopyOptions();
                            copyOptions.ignoreCase();
                            ChartInfoEntity chartInfoEntity = BeanUtil.mapToBean(codeMap, ChartInfoEntity.class, true, copyOptions);
                            chartInfoService.save(chartInfoEntity);
                        }


                    });
                    Thread.sleep(1000 * 10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();


        return ResponseResult.success();
    }


    @GetMapping("/chartsPicture")
    public ResponseResult chartsPicture() {
        Thread t = new Thread(() -> {
            List<String> errorList = new ArrayList<>();
            List<String> result = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/aa.txt")),
                        "UTF-8"));
                String lineTxt = null;
                //数据以逗号分隔
                while ((lineTxt = br.readLine()) != null) {
                    result.add(lineTxt.replace("\t", ""));
                }
                br.close();
            } catch (Exception e) {
                System.err.println("read errors :" + e);
            }


            result.forEach(item -> {
                if (item.contains("/asset/get/s")) {
                    amapClient.getChartsFile("D:\\sjft\\asset\\get\\s", null, item, (ex, request, response) -> {
                        int status = response.getStatusCode(); // 获取请求响应状态码
                        System.err.println(request + "====>" + status);
                        errorList.add(item);
                    });
                }
            });


            System.out.println(errorList);
        });

        t.start();

        return ResponseResult.success();
    }


    /**
     * 获取经纬度信息
     *
     * @param
     * @return com.sjft.common.ResponseResult
     * @author Mr.Baiyy
     * @date 2022/1/26 15:09
     */
    @GetMapping("/areaCode")
    public ResponseResult areaCode() {
        Thread t = new Thread(() -> {
            List<AreaCodeEntity> areaCode = amapClient.getAreaCode();
            areaCodeService.saveBatch(areaCode);
        });

        t.start();

        return ResponseResult.success();
    }


    @GetMapping("/areaJson")
    public ResponseResult areaJson() {
        Thread t = new Thread(() -> {
            // 获取下载文件名
            List<AreaCodeEntity> areaCode1 = areaCodeService.getList(null, null);
            areaCode1.forEach(areaCodeEntity -> {
                saveArea(areaCodeEntity);
            });

            /*List<AreaCodeEntity> areaCode2 = areaCodeService.getList(null, "province");
            areaCode2.forEach(areaCodeEntity -> {
                saveArea(areaCodeEntity);
            });

            List<AreaCodeEntity> areaCode3 = areaCodeService.getList(null, "city");
            areaCode3.forEach(areaCodeEntity -> {
                saveArea(areaCodeEntity);
            });

            List<AreaCodeEntity> areaCode4 = areaCodeService.getList(null, "district");
            areaCode4.forEach(areaCodeEntity -> {
                saveArea(areaCodeEntity);
            });*/
        });

        t.start();

        return ResponseResult.success();
    }

    private void saveArea(AreaCodeEntity areaCodeEntity) {

        AreaJsonEntity areaJson = new AreaJsonEntity();
        String jsonPath = areaCodeEntity.getAdcode().toString();
        if (areaCodeEntity.getLevel().equals("district")) {
            jsonPath = jsonPath + ".json";
        } else {
            jsonPath = jsonPath + ".json";
        }

        String json = amapClient.getAreaJson(jsonPath, (ex, request, response) -> {
            int status = response.getStatusCode(); // 获取请求响应状态码
            System.err.println(request + "====>" + status);
        });
        areaJson.setAreaJson(json);
        areaJson.setAreaCode(areaCodeEntity.getAdcode().toString());
        areaJson.setName(areaCodeEntity.getName());
        areaJson.setParent(areaCodeEntity.getParent() == null ? null : areaCodeEntity.getParent().toString());
        areaJsonService.save(areaJson);

    }

}

package com.sjft.forest;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;
import com.dtflys.forest.callback.OnError;
import com.dtflys.forest.extensions.DownloadFile;
import com.dtflys.forest.http.ForestResponse;
import com.sjft.entity.AreaCodeEntity;
import com.sjft.entity.AreaJsonEntity;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AmapClient
 * @Description TODO
 * @Author baymux
 * @Date 2021/5/21 23:10
 * @Vsrsion 1.0
 **/
public interface AmapClient {

    /**
     * 获取chars
     *
     * @param pageNumber
     * @return java.lang.String
     * @author Mr.Baiyy
     * @date 2022/1/19 15:44
     */
    @Get("https://www.makeapie.com/chart/list?sortBy=rank&pageSize=32&pageNumber=${0}&author=all")
    Map<String, Object> getCharts(int pageNumber, OnError onError);


    @Get("http://api.ppchart.com/chart/api/chart-list?current=${0}&type=${1}")
    Map<String, Object> getCharts(int pageNumber, int type,OnError onError);


    /**
     * 获取图片
     *
     * @param ChartsPictureURL
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author Mr.Baiyy
     * @date 2022/1/20 9:35
     */
    @Get("${ChartsPictureURL}")
    @DownloadFile(dir = "${0}", filename = "${1}")
    File getChartsPicture(String dir, String filename, @Var("ChartsPictureURL") String ChartsPictureURL, OnError onError);


    /**
     * 获取代码
     *
     * @param cid
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author Mr.Baiyy
     * @date 2022/1/20 10:00
     */
    @Get("https://www.makeapie.com/chart/get/${0}")
    Map<String, Object> getChartsCode(String cid, OnError onError);


    @Get("https://gallerybox.makeapie.com${2}")
    @DownloadFile(dir = "${0}", filename = "${1}")
    File getChartsFile(String dir, String filename, String ChartsPictureURL, OnError onError);


    /**
     * 获取内部图片
     *
     * @return java.io.File
     * @author Mr.Baiyy
     * @date 2022/1/26 15:12
     */
    @Get("https://geo.datav.aliyun.com/areas_v3/bound/all.json")
    List<AreaCodeEntity> getAreaCode();


    /**
     * 获取json
     *
     * @param
     * @return com.sjft.entity.AreaJsonEntity
     * @author Mr.Baiyy
     * @date 2022/2/7 16:09
     */
    @Get("https://geo.datav.aliyun.com/areas_v3/bound/${0}")
    String getAreaJson(String jsonFile, OnError onError);


}

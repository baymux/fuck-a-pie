package com.sjft.controller;

import com.sjft.common.ResponseResult;
import com.sjft.service.ChartsService;
import com.sjft.utils.page.TableDataInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Baiyy
 * @version 1.0
 * @ClassName ChartsController
 * @Description charts列表
 * @date 2022/3/4 14:51
 **/
@RestController
@RequestMapping("/charts")
public class ChartsController {


    private final ChartsService chartsService;

    public ChartsController(ChartsService chartsService) {
        this.chartsService = chartsService;
    }


    /**
     * 列表
     *
     * @param params
     * @return org.springframework.http.ResponseEntity
     * @author Mr.Baiyy
     * @date 2022/3/4 14:55
     */
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody(required = false) Map<String, Object> params) {
        TableDataInfo.startPage();
        List<Map<String, Object>> charts = chartsService.getList(params);
        return TableDataInfo.getDataTable(charts);
    }


    /**
     * 获取图表详情
     *
     * @param params
     * @return com.sjft.utils.page.TableDataInfo
     * @author Mr.Baiyy
     * @date 2022/3/4 16:44
     */
    @PostMapping("/info")
    public ResponseResult info(@RequestBody(required = false) Map<String, Object> params) {
        List<Map<String, Object>> charts = chartsService.getList(params);
        return ResponseResult.success(charts);
    }

}

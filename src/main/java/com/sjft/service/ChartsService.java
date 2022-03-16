package com.sjft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjft.entity.ChartsEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Baiyy
 * @email
 * @date 2022-01-19 15:31:51
 */
public interface ChartsService extends IService<ChartsEntity> {


    /**
     * 获取图biao列表
     *
     * @param params
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @author Mr.Baiyy
     * @date 2022/3/4 14:58
     */
    List<Map<String, Object>> getList(Map<String, Object> params);


    /**
     * 获取表标签
     * @param params
     * @return
     */
    List<Map<String, Object>> getTagsList(Map<String, Object> params);
}


package com.sjft.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjft.entity.ChartsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Baiyy
 * @email
 * @date 2022-01-19 15:31:51
 */
@Mapper
public interface ChartsDao extends BaseMapper<ChartsEntity> {


    /**
     * 查询图表列表
     *
     * @param params
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @author Mr.Baiyy
     * @date 2022/3/4 14:59
     */
    List<Map<String, Object>> selectList(Map<String, Object> params);
}

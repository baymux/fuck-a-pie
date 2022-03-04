package com.sjft.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjft.entity.AreaCodeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr.Baiyy
 * @email
 * @date 2022-01-26 15:03:59
 */
@Mapper
public interface AreaCodeDao extends BaseMapper<AreaCodeEntity> {


    /**
     * 查询areaList
     *
     * @param parent
     * @return java.util.List<com.sjft.entity.AreaCodeEntity>
     * @author Mr.Baiyy
     * @date 2022/2/7 16:17
     */
    List<AreaCodeEntity> selectAreaList(@Param("parent") String parent, @Param("level") String level);
}

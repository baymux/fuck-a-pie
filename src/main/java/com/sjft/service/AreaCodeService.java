package com.sjft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjft.entity.AreaCodeEntity;


import java.util.List;
import java.util.Map;

/**
 * @author Mr.Baiyy
 * @email
 * @date 2022-01-26 15:03:59
 */
public interface AreaCodeService extends IService<AreaCodeEntity> {


    /**
     * 查询区域名称
     *
     * @param parent
     * @return java.util.List<com.sjft.entity.AreaCodeEntity>
     * @author Mr.Baiyy
     * @date 2022/2/7 16:16
     */
    List<AreaCodeEntity> getList(String parent,String level);
}


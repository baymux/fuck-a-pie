package com.sjft.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjft.dao.AreaCodeDao;
import com.sjft.entity.AreaCodeEntity;
import com.sjft.service.AreaCodeService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("areaCodeService")
public class AreaCodeServiceImpl extends ServiceImpl<AreaCodeDao, AreaCodeEntity> implements AreaCodeService {


    @Override
    public List<AreaCodeEntity> getList(String parent,String level) {
        return this.baseMapper.selectAreaList(parent, level);
    }
}
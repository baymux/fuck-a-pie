package com.sjft.service.impl;

import com.sjft.dao.ChartsDao;
import com.sjft.entity.ChartsEntity;
import com.sjft.service.ChartsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("chartsService")
public class ChartsServiceImpl extends ServiceImpl<ChartsDao, ChartsEntity> implements ChartsService {


    @Override
    public List<Map<String, Object>> getList(Map<String, Object> params) {
        return this.baseMapper.selectList(params);
    }
}
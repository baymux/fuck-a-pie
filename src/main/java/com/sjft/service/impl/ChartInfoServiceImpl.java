package com.sjft.service.impl;

import com.sjft.dao.ChartInfoDao;
import com.sjft.entity.ChartInfoEntity;
import com.sjft.service.ChartInfoService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("chartInfoService")
public class ChartInfoServiceImpl extends ServiceImpl<ChartInfoDao, ChartInfoEntity> implements ChartInfoService {


}
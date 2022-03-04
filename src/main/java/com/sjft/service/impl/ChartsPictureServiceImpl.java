package com.sjft.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjft.dao.ChartsPictureDao;
import com.sjft.entity.ChartsPictureEntity;
import com.sjft.service.ChartsPictureService;
import org.springframework.stereotype.Service;


@Service("chartsPictureService")
public class ChartsPictureServiceImpl extends ServiceImpl<ChartsPictureDao, ChartsPictureEntity> implements ChartsPictureService {


}
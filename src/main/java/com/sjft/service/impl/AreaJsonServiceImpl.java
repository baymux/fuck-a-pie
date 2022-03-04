package com.sjft.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjft.dao.AreaJsonDao;
import com.sjft.entity.AreaJsonEntity;
import com.sjft.service.AreaJsonService;
import org.springframework.stereotype.Service;


@Service("areaJsonService")
public class AreaJsonServiceImpl extends ServiceImpl<AreaJsonDao, AreaJsonEntity> implements AreaJsonService {


}
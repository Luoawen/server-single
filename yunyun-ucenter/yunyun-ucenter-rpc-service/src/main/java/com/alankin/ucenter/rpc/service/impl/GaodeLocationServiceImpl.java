package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.GaodeLocationMapper;
import com.alankin.ucenter.dao.model.GaodeLocation;
import com.alankin.ucenter.dao.model.GaodeLocationExample;
import com.alankin.ucenter.rpc.api.GaodeLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* GaodeLocationService实现
* Created by alankin on 2019/2/22.
*/
@Service
@Transactional
@BaseService
public class GaodeLocationServiceImpl extends BaseServiceImpl<GaodeLocationMapper, GaodeLocation, GaodeLocationExample> implements GaodeLocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GaodeLocationServiceImpl.class);

    @Autowired
    GaodeLocationMapper gaodeLocationMapper;

}
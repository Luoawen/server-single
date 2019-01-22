package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.SysModuleMapper;
import com.alankin.ucenter.dao.model.SysModule;
import com.alankin.ucenter.dao.model.SysModuleExample;
import com.alankin.ucenter.rpc.api.SysModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* SysModuleService实现
* Created by alankin on 2019/1/1.
*/
@Service
@Transactional
@BaseService
public class SysModuleServiceImpl extends BaseServiceImpl<SysModuleMapper, SysModule, SysModuleExample> implements SysModuleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysModuleServiceImpl.class);

    @Autowired
    SysModuleMapper sysModuleMapper;

}
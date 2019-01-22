package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.SysSysMapper;
import com.alankin.ucenter.dao.model.SysSys;
import com.alankin.ucenter.dao.model.SysSysExample;
import com.alankin.ucenter.rpc.api.SysSysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* SysSysService实现
* Created by alankin on 2018/12/30.
*/
@Service
@Transactional
@BaseService
public class SysSysServiceImpl extends BaseServiceImpl<SysSysMapper, SysSys, SysSysExample> implements SysSysService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysSysServiceImpl.class);

    @Autowired
    SysSysMapper sysSysMapper;

}
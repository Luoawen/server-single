package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.SysButtonMapper;
import com.alankin.ucenter.dao.model.SysButton;
import com.alankin.ucenter.dao.model.SysButtonExample;
import com.alankin.ucenter.rpc.api.SysButtonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* SysButtonService实现
* Created by alankin on 2018/12/30.
*/
@Service
@Transactional
@BaseService
public class SysButtonServiceImpl extends BaseServiceImpl<SysButtonMapper, SysButton, SysButtonExample> implements SysButtonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysButtonServiceImpl.class);

    @Autowired
    SysButtonMapper sysButtonMapper;

}
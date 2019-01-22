package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.SysUserAuthMapper;
import com.alankin.ucenter.dao.model.SysUserAuth;
import com.alankin.ucenter.dao.model.SysUserAuthExample;
import com.alankin.ucenter.rpc.api.SysUserAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* SysUserAuthService实现
* Created by alankin on 2019/1/4.
*/
@Service
@Transactional
@BaseService
public class SysUserAuthServiceImpl extends BaseServiceImpl<SysUserAuthMapper, SysUserAuth, SysUserAuthExample> implements SysUserAuthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserAuthServiceImpl.class);

    @Autowired
    SysUserAuthMapper sysUserAuthMapper;

}
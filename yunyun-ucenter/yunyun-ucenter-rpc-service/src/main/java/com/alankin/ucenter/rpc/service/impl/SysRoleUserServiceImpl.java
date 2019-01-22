package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.SysRoleUserMapper;
import com.alankin.ucenter.dao.model.SysRoleUser;
import com.alankin.ucenter.dao.model.SysRoleUserExample;
import com.alankin.ucenter.rpc.api.SysRoleUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* SysRoleUserService实现
* Created by alankin on 2019/1/10.
*/
@Service
@Transactional
@BaseService
public class SysRoleUserServiceImpl extends BaseServiceImpl<SysRoleUserMapper, SysRoleUser, SysRoleUserExample> implements SysRoleUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleUserServiceImpl.class);

    @Autowired
    SysRoleUserMapper sysRoleUserMapper;

}
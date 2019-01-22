package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.SysRoleMapper;
import com.alankin.ucenter.dao.model.SysRole;
import com.alankin.ucenter.dao.model.SysRoleExample;
import com.alankin.ucenter.rpc.api.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* SysRoleService实现
* Created by alankin on 2019/1/2.
*/
@Service
@Transactional
@BaseService
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRole, SysRoleExample> implements SysRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    SysRoleMapper sysRoleMapper;

}
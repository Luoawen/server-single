package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.SysRoleButtonPermissionMapper;
import com.alankin.ucenter.dao.model.SysRoleButtonPermission;
import com.alankin.ucenter.dao.model.SysRoleButtonPermissionExample;
import com.alankin.ucenter.rpc.api.SysRoleButtonPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* SysRoleButtonPermissionService实现
* Created by alankin on 2018/12/30.
*/
@Service
@Transactional
@BaseService
public class SysRoleButtonPermissionServiceImpl extends BaseServiceImpl<SysRoleButtonPermissionMapper, SysRoleButtonPermission, SysRoleButtonPermissionExample> implements SysRoleButtonPermissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleButtonPermissionServiceImpl.class);

    @Autowired
    SysRoleButtonPermissionMapper sysRoleButtonPermissionMapper;

}
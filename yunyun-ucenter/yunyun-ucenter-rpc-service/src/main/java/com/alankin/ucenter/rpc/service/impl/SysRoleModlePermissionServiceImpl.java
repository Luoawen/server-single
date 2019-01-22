package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.SysRoleModlePermissionMapper;
import com.alankin.ucenter.dao.model.SysRoleModlePermission;
import com.alankin.ucenter.dao.model.SysRoleModlePermissionExample;
import com.alankin.ucenter.rpc.api.SysRoleModlePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* SysRoleModlePermissionService实现
* Created by alankin on 2019/1/1.
*/
@Service
@Transactional
@BaseService
public class SysRoleModlePermissionServiceImpl extends BaseServiceImpl<SysRoleModlePermissionMapper, SysRoleModlePermission, SysRoleModlePermissionExample> implements SysRoleModlePermissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleModlePermissionServiceImpl.class);

    @Autowired
    SysRoleModlePermissionMapper sysRoleModlePermissionMapper;

}
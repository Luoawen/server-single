package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.ApplySysUserMapper;
import com.alankin.ucenter.dao.model.ApplySysUser;
import com.alankin.ucenter.dao.model.ApplySysUserExample;
import com.alankin.ucenter.rpc.api.ApplySysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ApplySysUserService实现
* Created by alankin on 2019/1/6.
*/
@Service
@Transactional
@BaseService
public class ApplySysUserServiceImpl extends BaseServiceImpl<ApplySysUserMapper, ApplySysUser, ApplySysUserExample> implements ApplySysUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplySysUserServiceImpl.class);

    @Autowired
    ApplySysUserMapper applySysUserMapper;

}
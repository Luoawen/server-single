package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.UserOtherAuthMapper;
import com.alankin.ucenter.dao.model.UserOtherAuth;
import com.alankin.ucenter.dao.model.UserOtherAuthExample;
import com.alankin.ucenter.rpc.api.UserOtherAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserOtherAuthService实现
* Created by alankin on 2019/1/15.
*/
@Service
@Transactional
@BaseService
public class UserOtherAuthServiceImpl extends BaseServiceImpl<UserOtherAuthMapper, UserOtherAuth, UserOtherAuthExample> implements UserOtherAuthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserOtherAuthServiceImpl.class);

    @Autowired
    UserOtherAuthMapper userOtherAuthMapper;

}
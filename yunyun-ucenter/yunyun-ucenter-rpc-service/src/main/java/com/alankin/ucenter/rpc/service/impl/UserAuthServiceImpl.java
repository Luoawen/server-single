package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.UserAuthMapper;
import com.alankin.ucenter.dao.model.UserAuth;
import com.alankin.ucenter.dao.model.UserAuthExample;
import com.alankin.ucenter.rpc.api.UserAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserAuthService实现
* Created by alankin on 2019/1/4.
*/
@Service
@Transactional
@BaseService
public class UserAuthServiceImpl extends BaseServiceImpl<UserAuthMapper, UserAuth, UserAuthExample> implements UserAuthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthServiceImpl.class);

    @Autowired
    UserAuthMapper userAuthMapper;

}
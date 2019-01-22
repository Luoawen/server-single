package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.UserLocationMapper;
import com.alankin.ucenter.dao.model.UserLocation;
import com.alankin.ucenter.dao.model.UserLocationExample;
import com.alankin.ucenter.rpc.api.UserLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserLocationService实现
* Created by alankin on 2019/1/17.
*/
@Service
@Transactional
@BaseService
public class UserLocationServiceImpl extends BaseServiceImpl<UserLocationMapper, UserLocation, UserLocationExample> implements UserLocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLocationServiceImpl.class);

    @Autowired
    UserLocationMapper userLocationMapper;

}
package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.UserExtraMapper;
import com.alankin.ucenter.dao.model.UserExtra;
import com.alankin.ucenter.dao.model.UserExtraExample;
import com.alankin.ucenter.rpc.api.UserExtraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserExtraService实现
* Created by alankin on 2018/12/30.
*/
@Service
@Transactional
@BaseService
public class UserExtraServiceImpl extends BaseServiceImpl<UserExtraMapper, UserExtra, UserExtraExample> implements UserExtraService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserExtraServiceImpl.class);

    @Autowired
    UserExtraMapper userExtraMapper;

}
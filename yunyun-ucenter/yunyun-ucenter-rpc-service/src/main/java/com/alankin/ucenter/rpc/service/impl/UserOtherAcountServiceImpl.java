package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.UserOtherAcountMapper;
import com.alankin.ucenter.dao.model.UserOtherAcount;
import com.alankin.ucenter.dao.model.UserOtherAcountExample;
import com.alankin.ucenter.rpc.api.UserOtherAcountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserOtherAcountService实现
* Created by alankin on 2019/1/15.
*/
@Service
@Transactional
@BaseService
public class UserOtherAcountServiceImpl extends BaseServiceImpl<UserOtherAcountMapper, UserOtherAcount, UserOtherAcountExample> implements UserOtherAcountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserOtherAcountServiceImpl.class);

    @Autowired
    UserOtherAcountMapper userOtherAcountMapper;

}
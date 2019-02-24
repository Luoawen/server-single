package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.UserBaseMapper;
import com.alankin.ucenter.dao.model.UserBase;
import com.alankin.ucenter.dao.model.UserBaseExample;
import com.alankin.ucenter.rpc.api.UserBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserBaseService实现
* Created by alankin on 2019/2/24.
*/
@Service
@Transactional
@BaseService
public class UserBaseServiceImpl extends BaseServiceImpl<UserBaseMapper, UserBase, UserBaseExample> implements UserBaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserBaseServiceImpl.class);

    @Autowired
    UserBaseMapper userBaseMapper;

}
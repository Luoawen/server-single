package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.UserContactsMapper;
import com.alankin.ucenter.dao.model.UserContacts;
import com.alankin.ucenter.dao.model.UserContactsExample;
import com.alankin.ucenter.rpc.api.UserContactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserContactsService实现
* Created by alankin on 2019/1/25.
*/
@Service
@Transactional
@BaseService
public class UserContactsServiceImpl extends BaseServiceImpl<UserContactsMapper, UserContacts, UserContactsExample> implements UserContactsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserContactsServiceImpl.class);

    @Autowired
    UserContactsMapper userContactsMapper;

}
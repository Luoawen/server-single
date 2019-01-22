package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.UserEmergencyContactMapper;
import com.alankin.ucenter.dao.model.UserEmergencyContact;
import com.alankin.ucenter.dao.model.UserEmergencyContactExample;
import com.alankin.ucenter.rpc.api.UserEmergencyContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserEmergencyContactService实现
* Created by alankin on 2019/1/15.
*/
@Service
@Transactional
@BaseService
public class UserEmergencyContactServiceImpl extends BaseServiceImpl<UserEmergencyContactMapper, UserEmergencyContact, UserEmergencyContactExample> implements UserEmergencyContactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEmergencyContactServiceImpl.class);

    @Autowired
    UserEmergencyContactMapper userEmergencyContactMapper;

}
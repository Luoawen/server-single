package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.UserRemarkMapper;
import com.alankin.ucenter.dao.model.UserRemark;
import com.alankin.ucenter.dao.model.UserRemarkExample;
import com.alankin.ucenter.rpc.api.UserRemarkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserRemarkService实现
* Created by alankin on 2019/3/15.
*/
@Service
@Transactional
@BaseService
public class UserRemarkServiceImpl extends BaseServiceImpl<UserRemarkMapper, UserRemark, UserRemarkExample> implements UserRemarkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRemarkServiceImpl.class);

    @Autowired
    UserRemarkMapper userRemarkMapper;

}
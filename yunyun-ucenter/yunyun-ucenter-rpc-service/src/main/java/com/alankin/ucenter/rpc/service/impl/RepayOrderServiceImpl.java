package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.RepayOrderMapper;
import com.alankin.ucenter.dao.model.RepayOrder;
import com.alankin.ucenter.dao.model.RepayOrderExample;
import com.alankin.ucenter.rpc.api.RepayOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* RepayOrderService实现
* Created by alankin on 2019/1/13.
*/
@Service
@Transactional
@BaseService
public class RepayOrderServiceImpl extends BaseServiceImpl<RepayOrderMapper, RepayOrder, RepayOrderExample> implements RepayOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepayOrderServiceImpl.class);

    @Autowired
    RepayOrderMapper repayOrderMapper;

}
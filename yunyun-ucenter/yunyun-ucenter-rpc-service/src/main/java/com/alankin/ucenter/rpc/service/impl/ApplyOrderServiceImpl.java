package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.ApplyOrderMapper;
import com.alankin.ucenter.dao.model.ApplyOrder;
import com.alankin.ucenter.dao.model.ApplyOrderExample;
import com.alankin.ucenter.rpc.api.ApplyOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ApplyOrderService实现
* Created by alankin on 2019/1/6.
*/
@Service
@Transactional
@BaseService
public class ApplyOrderServiceImpl extends BaseServiceImpl<ApplyOrderMapper, ApplyOrder, ApplyOrderExample> implements ApplyOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyOrderServiceImpl.class);

    @Autowired
    ApplyOrderMapper applyOrderMapper;

}
package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.AfuGuizeMapper;
import com.alankin.ucenter.dao.model.AfuGuize;
import com.alankin.ucenter.dao.model.AfuGuizeExample;
import com.alankin.ucenter.rpc.api.AfuGuizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* AfuGuizeService实现
* Created by alankin on 2019/2/19.
*/
@Service
@Transactional
@BaseService
public class AfuGuizeServiceImpl extends BaseServiceImpl<AfuGuizeMapper, AfuGuize, AfuGuizeExample> implements AfuGuizeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AfuGuizeServiceImpl.class);

    @Autowired
    AfuGuizeMapper afuGuizeMapper;

}
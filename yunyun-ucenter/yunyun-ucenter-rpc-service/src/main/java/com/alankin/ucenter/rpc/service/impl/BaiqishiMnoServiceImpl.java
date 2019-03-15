package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.BaiqishiMnoMapper;
import com.alankin.ucenter.dao.model.BaiqishiMno;
import com.alankin.ucenter.dao.model.BaiqishiMnoExample;
import com.alankin.ucenter.rpc.api.BaiqishiMnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BaiqishiMnoService实现
* Created by alankin on 2019/3/11.
*/
@Service
@Transactional
@BaseService
public class BaiqishiMnoServiceImpl extends BaseServiceImpl<BaiqishiMnoMapper, BaiqishiMno, BaiqishiMnoExample> implements BaiqishiMnoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaiqishiMnoServiceImpl.class);

    @Autowired
    BaiqishiMnoMapper baiqishiMnoMapper;

}
package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.SysUserBaseMapper;
import com.alankin.ucenter.dao.model.SysUserBase;
import com.alankin.ucenter.dao.model.SysUserBaseExample;
import com.alankin.ucenter.rpc.api.SysUserBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* SysUserBaseService实现
* Created by alankin on 2019/1/10.
*/
@Service
@Transactional
@BaseService
public class SysUserBaseServiceImpl extends BaseServiceImpl<SysUserBaseMapper, SysUserBase, SysUserBaseExample> implements SysUserBaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserBaseServiceImpl.class);

    @Autowired
    SysUserBaseMapper sysUserBaseMapper;

}
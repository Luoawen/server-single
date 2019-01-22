package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.SysUserChannelMapper;
import com.alankin.ucenter.dao.model.SysUserChannel;
import com.alankin.ucenter.dao.model.SysUserChannelExample;
import com.alankin.ucenter.rpc.api.SysUserChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* SysUserChannelService实现
* Created by alankin on 2019/1/3.
*/
@Service
@Transactional
@BaseService
public class SysUserChannelServiceImpl extends BaseServiceImpl<SysUserChannelMapper, SysUserChannel, SysUserChannelExample> implements SysUserChannelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserChannelServiceImpl.class);

    @Autowired
    SysUserChannelMapper sysUserChannelMapper;

}
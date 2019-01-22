package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.ChannelMapper;
import com.alankin.ucenter.dao.model.Channel;
import com.alankin.ucenter.dao.model.ChannelExample;
import com.alankin.ucenter.rpc.api.ChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ChannelService实现
* Created by alankin on 2019/1/8.
*/
@Service
@Transactional
@BaseService
public class ChannelServiceImpl extends BaseServiceImpl<ChannelMapper, Channel, ChannelExample> implements ChannelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelServiceImpl.class);

    @Autowired
    ChannelMapper channelMapper;

}
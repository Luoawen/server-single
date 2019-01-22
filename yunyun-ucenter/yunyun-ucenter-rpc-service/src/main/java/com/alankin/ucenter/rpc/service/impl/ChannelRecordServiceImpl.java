package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.ChannelRecordMapper;
import com.alankin.ucenter.dao.model.ChannelRecord;
import com.alankin.ucenter.dao.model.ChannelRecordExample;
import com.alankin.ucenter.rpc.api.ChannelRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ChannelRecordService实现
* Created by alankin on 2019/1/7.
*/
@Service
@Transactional
@BaseService
public class ChannelRecordServiceImpl extends BaseServiceImpl<ChannelRecordMapper, ChannelRecord, ChannelRecordExample> implements ChannelRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelRecordServiceImpl.class);

    @Autowired
    ChannelRecordMapper channelRecordMapper;

}
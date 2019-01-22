package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.DataDicMapper;
import com.alankin.ucenter.dao.model.DataDic;
import com.alankin.ucenter.dao.model.DataDicExample;
import com.alankin.ucenter.rpc.api.DataDicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* DataDicService实现
* Created by alankin on 2019/1/2.
*/
@Service
@Transactional
@BaseService
public class DataDicServiceImpl extends BaseServiceImpl<DataDicMapper, DataDic, DataDicExample> implements DataDicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataDicServiceImpl.class);

    @Autowired
    DataDicMapper dataDicMapper;

}
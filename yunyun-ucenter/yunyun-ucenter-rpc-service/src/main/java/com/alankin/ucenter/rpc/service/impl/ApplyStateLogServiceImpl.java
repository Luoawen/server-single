package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.ApplyStateLogMapper;
import com.alankin.ucenter.dao.model.ApplyStateLog;
import com.alankin.ucenter.dao.model.ApplyStateLogExample;
import com.alankin.ucenter.rpc.api.ApplyStateLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ApplyStateLogService实现
* Created by alankin on 2019/1/4.
*/
@Service
@Transactional
@BaseService
public class ApplyStateLogServiceImpl extends BaseServiceImpl<ApplyStateLogMapper, ApplyStateLog, ApplyStateLogExample> implements ApplyStateLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyStateLogServiceImpl.class);

    @Autowired
    ApplyStateLogMapper applyStateLogMapper;

}
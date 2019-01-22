package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.LoanReceiptMapper;
import com.alankin.ucenter.dao.model.LoanReceipt;
import com.alankin.ucenter.dao.model.LoanReceiptExample;
import com.alankin.ucenter.rpc.api.LoanReceiptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* LoanReceiptService实现
* Created by alankin on 2019/1/20.
*/
@Service
@Transactional
@BaseService
public class LoanReceiptServiceImpl extends BaseServiceImpl<LoanReceiptMapper, LoanReceipt, LoanReceiptExample> implements LoanReceiptService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanReceiptServiceImpl.class);

    @Autowired
    LoanReceiptMapper loanReceiptMapper;

}
package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.LoanReceiptMapper;
import com.alankin.ucenter.dao.model.LoanReceipt;
import com.alankin.ucenter.dao.model.LoanReceiptExample;

/**
* 降级实现LoanReceiptService接口
* Created by alankin on 2019/1/20.
*/
public class LoanReceiptServiceMock extends BaseServiceMock<LoanReceiptMapper, LoanReceipt, LoanReceiptExample> implements LoanReceiptService {

}

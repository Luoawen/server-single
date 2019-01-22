package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.ApplyOrderMapper;
import com.alankin.ucenter.dao.model.ApplyOrder;
import com.alankin.ucenter.dao.model.ApplyOrderExample;

/**
* 降级实现ApplyOrderService接口
* Created by alankin on 2019/1/6.
*/
public class ApplyOrderServiceMock extends BaseServiceMock<ApplyOrderMapper, ApplyOrder, ApplyOrderExample> implements ApplyOrderService {

}

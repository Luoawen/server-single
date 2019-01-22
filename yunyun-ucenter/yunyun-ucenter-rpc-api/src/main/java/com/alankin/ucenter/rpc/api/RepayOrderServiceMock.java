package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.RepayOrderMapper;
import com.alankin.ucenter.dao.model.RepayOrder;
import com.alankin.ucenter.dao.model.RepayOrderExample;

/**
* 降级实现RepayOrderService接口
* Created by alankin on 2019/1/13.
*/
public class RepayOrderServiceMock extends BaseServiceMock<RepayOrderMapper, RepayOrder, RepayOrderExample> implements RepayOrderService {

}

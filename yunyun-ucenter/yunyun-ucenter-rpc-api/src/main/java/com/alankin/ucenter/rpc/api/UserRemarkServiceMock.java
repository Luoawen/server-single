package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.UserRemarkMapper;
import com.alankin.ucenter.dao.model.UserRemark;
import com.alankin.ucenter.dao.model.UserRemarkExample;

/**
* 降级实现UserRemarkService接口
* Created by alankin on 2019/3/15.
*/
public class UserRemarkServiceMock extends BaseServiceMock<UserRemarkMapper, UserRemark, UserRemarkExample> implements UserRemarkService {

}

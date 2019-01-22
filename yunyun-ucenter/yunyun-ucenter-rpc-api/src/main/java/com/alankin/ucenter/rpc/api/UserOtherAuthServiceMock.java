package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.UserOtherAuthMapper;
import com.alankin.ucenter.dao.model.UserOtherAuth;
import com.alankin.ucenter.dao.model.UserOtherAuthExample;

/**
* 降级实现UserOtherAuthService接口
* Created by alankin on 2019/1/15.
*/
public class UserOtherAuthServiceMock extends BaseServiceMock<UserOtherAuthMapper, UserOtherAuth, UserOtherAuthExample> implements UserOtherAuthService {

}

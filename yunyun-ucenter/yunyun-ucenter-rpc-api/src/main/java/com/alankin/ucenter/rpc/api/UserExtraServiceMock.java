package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.UserExtraMapper;
import com.alankin.ucenter.dao.model.UserExtra;
import com.alankin.ucenter.dao.model.UserExtraExample;

/**
* 降级实现UserExtraService接口
* Created by alankin on 2018/12/30.
*/
public class UserExtraServiceMock extends BaseServiceMock<UserExtraMapper, UserExtra, UserExtraExample> implements UserExtraService {

}

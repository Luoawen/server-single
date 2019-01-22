package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.UserLocationMapper;
import com.alankin.ucenter.dao.model.UserLocation;
import com.alankin.ucenter.dao.model.UserLocationExample;

/**
* 降级实现UserLocationService接口
* Created by alankin on 2019/1/17.
*/
public class UserLocationServiceMock extends BaseServiceMock<UserLocationMapper, UserLocation, UserLocationExample> implements UserLocationService {

}

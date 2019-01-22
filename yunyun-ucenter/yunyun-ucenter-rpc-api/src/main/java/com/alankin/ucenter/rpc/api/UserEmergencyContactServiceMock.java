package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.UserEmergencyContactMapper;
import com.alankin.ucenter.dao.model.UserEmergencyContact;
import com.alankin.ucenter.dao.model.UserEmergencyContactExample;

/**
* 降级实现UserEmergencyContactService接口
* Created by alankin on 2019/1/15.
*/
public class UserEmergencyContactServiceMock extends BaseServiceMock<UserEmergencyContactMapper, UserEmergencyContact, UserEmergencyContactExample> implements UserEmergencyContactService {

}

package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.UserContactsMapper;
import com.alankin.ucenter.dao.model.UserContacts;
import com.alankin.ucenter.dao.model.UserContactsExample;

/**
* 降级实现UserContactsService接口
* Created by alankin on 2019/1/25.
*/
public class UserContactsServiceMock extends BaseServiceMock<UserContactsMapper, UserContacts, UserContactsExample> implements UserContactsService {

}

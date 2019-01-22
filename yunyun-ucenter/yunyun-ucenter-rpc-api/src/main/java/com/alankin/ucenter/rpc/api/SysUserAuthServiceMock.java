package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.SysUserAuthMapper;
import com.alankin.ucenter.dao.model.SysUserAuth;
import com.alankin.ucenter.dao.model.SysUserAuthExample;

/**
* 降级实现SysUserAuthService接口
* Created by alankin on 2019/1/4.
*/
public class SysUserAuthServiceMock extends BaseServiceMock<SysUserAuthMapper, SysUserAuth, SysUserAuthExample> implements SysUserAuthService {

}

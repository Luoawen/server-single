package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.SysRoleUserMapper;
import com.alankin.ucenter.dao.model.SysRoleUser;
import com.alankin.ucenter.dao.model.SysRoleUserExample;

/**
* 降级实现SysRoleUserService接口
* Created by alankin on 2019/1/10.
*/
public class SysRoleUserServiceMock extends BaseServiceMock<SysRoleUserMapper, SysRoleUser, SysRoleUserExample> implements SysRoleUserService {

}

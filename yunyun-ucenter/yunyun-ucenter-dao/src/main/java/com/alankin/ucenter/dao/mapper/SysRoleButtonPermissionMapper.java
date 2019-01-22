package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.SysRoleButtonPermission;
import com.alankin.ucenter.dao.model.SysRoleButtonPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleButtonPermissionMapper {
    int countByExample(SysRoleButtonPermissionExample example);

    int deleteByExample(SysRoleButtonPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleButtonPermission record);

    int insertSelective(SysRoleButtonPermission record);

    List<SysRoleButtonPermission> selectByExample(SysRoleButtonPermissionExample example);

    SysRoleButtonPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleButtonPermission record, @Param("example") SysRoleButtonPermissionExample example);

    int updateByExample(@Param("record") SysRoleButtonPermission record, @Param("example") SysRoleButtonPermissionExample example);

    int updateByPrimaryKeySelective(SysRoleButtonPermission record);

    int updateByPrimaryKey(SysRoleButtonPermission record);
}
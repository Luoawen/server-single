package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.SysRoleModlePermission;
import com.alankin.ucenter.dao.model.SysRoleModlePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleModlePermissionMapper {
    int countByExample(SysRoleModlePermissionExample example);

    int deleteByExample(SysRoleModlePermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleModlePermission record);

    int insertSelective(SysRoleModlePermission record);

    List<SysRoleModlePermission> selectByExample(SysRoleModlePermissionExample example);

    SysRoleModlePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoleModlePermission record, @Param("example") SysRoleModlePermissionExample example);

    int updateByExample(@Param("record") SysRoleModlePermission record, @Param("example") SysRoleModlePermissionExample example);

    int updateByPrimaryKeySelective(SysRoleModlePermission record);

    int updateByPrimaryKey(SysRoleModlePermission record);
}
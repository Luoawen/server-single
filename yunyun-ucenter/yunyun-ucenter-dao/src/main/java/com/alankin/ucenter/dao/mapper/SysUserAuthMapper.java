package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.SysUserAuth;
import com.alankin.ucenter.dao.model.SysUserAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserAuthMapper {
    int countByExample(SysUserAuthExample example);

    int deleteByExample(SysUserAuthExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserAuth record);

    int insertSelective(SysUserAuth record);

    List<SysUserAuth> selectByExample(SysUserAuthExample example);

    SysUserAuth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserAuth record, @Param("example") SysUserAuthExample example);

    int updateByExample(@Param("record") SysUserAuth record, @Param("example") SysUserAuthExample example);

    int updateByPrimaryKeySelective(SysUserAuth record);

    int updateByPrimaryKey(SysUserAuth record);
}
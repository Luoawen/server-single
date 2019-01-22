package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.ApplySysUser;
import com.alankin.ucenter.dao.model.ApplySysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplySysUserMapper {
    int countByExample(ApplySysUserExample example);

    int deleteByExample(ApplySysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplySysUser record);

    int insertSelective(ApplySysUser record);

    List<ApplySysUser> selectByExample(ApplySysUserExample example);

    ApplySysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplySysUser record, @Param("example") ApplySysUserExample example);

    int updateByExample(@Param("record") ApplySysUser record, @Param("example") ApplySysUserExample example);

    int updateByPrimaryKeySelective(ApplySysUser record);

    int updateByPrimaryKey(ApplySysUser record);
}
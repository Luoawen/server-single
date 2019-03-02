package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.SysUserBase;
import com.alankin.ucenter.dao.model.SysUserBaseExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysUserBaseMapper {
    int countByExample(SysUserBaseExample example);

    int deleteByExample(SysUserBaseExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(SysUserBase record);

    int insertSelective(SysUserBase record);

    List<SysUserBase> selectByExample(SysUserBaseExample example);

    SysUserBase selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") SysUserBase record, @Param("example") SysUserBaseExample example);

    int updateByExample(@Param("record") SysUserBase record, @Param("example") SysUserBaseExample example);

    int updateByPrimaryKeySelective(SysUserBase record);

    int updateByPrimaryKey(SysUserBase record);

    List<Map> listVerifyAcount(Object o);

    List<Map> listNormalVerifyAcount();

    SysUserBase selectNormalVerifyByUid(Object o);

    SysUserBase selectNextNormalVerifyByUid(Object o);

    List<Map> listAllVerifyAcount();
}
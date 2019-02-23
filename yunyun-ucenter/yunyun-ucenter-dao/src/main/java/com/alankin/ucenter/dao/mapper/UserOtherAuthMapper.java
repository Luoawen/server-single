package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.UserOtherAuth;
import com.alankin.ucenter.dao.model.UserOtherAuthExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserOtherAuthMapper {
    int countByExample(UserOtherAuthExample example);

    int deleteByExample(UserOtherAuthExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserOtherAuth record);

    int insertSelective(UserOtherAuth record);

    List<UserOtherAuth> selectByExampleWithBLOBs(UserOtherAuthExample example);

    List<UserOtherAuth> selectByExample(UserOtherAuthExample example);

    UserOtherAuth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserOtherAuth record, @Param("example") UserOtherAuthExample example);

    int updateByExampleWithBLOBs(@Param("record") UserOtherAuth record, @Param("example") UserOtherAuthExample example);

    int updateByExample(@Param("record") UserOtherAuth record, @Param("example") UserOtherAuthExample example);

    int updateByPrimaryKeySelective(UserOtherAuth record);

    int updateByPrimaryKeyWithBLOBs(UserOtherAuth record);

    int updateByPrimaryKey(UserOtherAuth record);

}
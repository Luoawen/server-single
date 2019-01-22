package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.UserBase;
import com.alankin.ucenter.dao.model.UserBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBaseMapper {
    int countByExample(UserBaseExample example);

    int deleteByExample(UserBaseExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(UserBase record);

    int insertSelective(UserBase record);

    List<UserBase> selectByExample(UserBaseExample example);

    UserBase selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") UserBase record, @Param("example") UserBaseExample example);

    int updateByExample(@Param("record") UserBase record, @Param("example") UserBaseExample example);

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);
}
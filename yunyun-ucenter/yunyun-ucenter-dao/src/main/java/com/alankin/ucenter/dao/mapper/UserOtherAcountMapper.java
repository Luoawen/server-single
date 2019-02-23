package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.UserOtherAcount;
import com.alankin.ucenter.dao.model.UserOtherAcountExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserOtherAcountMapper {
    int countByExample(UserOtherAcountExample example);

    int deleteByExample(UserOtherAcountExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(UserOtherAcount record);

    int insertSelective(UserOtherAcount record);

    List<UserOtherAcount> selectByExample(UserOtherAcountExample example);

    UserOtherAcount selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") UserOtherAcount record, @Param("example") UserOtherAcountExample example);

    int updateByExample(@Param("record") UserOtherAcount record, @Param("example") UserOtherAcountExample example);

    int updateByPrimaryKeySelective(UserOtherAcount record);

    int updateByPrimaryKey(UserOtherAcount record);

    List<Map> selectUserOtherAcountsByUserUid(Object reqVo);
}
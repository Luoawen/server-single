package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.UserEmergencyContact;
import com.alankin.ucenter.dao.model.UserEmergencyContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserEmergencyContactMapper {
    int countByExample(UserEmergencyContactExample example);

    int deleteByExample(UserEmergencyContactExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(UserEmergencyContact record);

    int insertSelective(UserEmergencyContact record);

    List<UserEmergencyContact> selectByExample(UserEmergencyContactExample example);

    UserEmergencyContact selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") UserEmergencyContact record, @Param("example") UserEmergencyContactExample example);

    int updateByExample(@Param("record") UserEmergencyContact record, @Param("example") UserEmergencyContactExample example);

    int updateByPrimaryKeySelective(UserEmergencyContact record);

    int updateByPrimaryKey(UserEmergencyContact record);
}
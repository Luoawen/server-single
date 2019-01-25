package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.UserContacts;
import com.alankin.ucenter.dao.model.UserContactsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserContactsMapper {
    int countByExample(UserContactsExample example);

    int deleteByExample(UserContactsExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(UserContacts record);

    int insertSelective(UserContacts record);

    List<UserContacts> selectByExample(UserContactsExample example);

    UserContacts selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") UserContacts record, @Param("example") UserContactsExample example);

    int updateByExample(@Param("record") UserContacts record, @Param("example") UserContactsExample example);

    int updateByPrimaryKeySelective(UserContacts record);

    int updateByPrimaryKey(UserContacts record);
}
package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.UserRemark;
import com.alankin.ucenter.dao.model.UserRemarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRemarkMapper {
    int countByExample(UserRemarkExample example);

    int deleteByExample(UserRemarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRemark record);

    int insertSelective(UserRemark record);

    List<UserRemark> selectByExample(UserRemarkExample example);

    UserRemark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRemark record, @Param("example") UserRemarkExample example);

    int updateByExample(@Param("record") UserRemark record, @Param("example") UserRemarkExample example);

    int updateByPrimaryKeySelective(UserRemark record);

    int updateByPrimaryKey(UserRemark record);
}
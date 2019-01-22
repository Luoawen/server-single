package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.RepayOrder;
import com.alankin.ucenter.dao.model.RepayOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepayOrderMapper {
    int countByExample(RepayOrderExample example);

    int deleteByExample(RepayOrderExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(RepayOrder record);

    int insertSelective(RepayOrder record);

    List<RepayOrder> selectByExample(RepayOrderExample example);

    RepayOrder selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") RepayOrder record, @Param("example") RepayOrderExample example);

    int updateByExample(@Param("record") RepayOrder record, @Param("example") RepayOrderExample example);

    int updateByPrimaryKeySelective(RepayOrder record);

    int updateByPrimaryKey(RepayOrder record);
}
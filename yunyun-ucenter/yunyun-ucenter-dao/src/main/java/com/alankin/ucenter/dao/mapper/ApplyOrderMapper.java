package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.ApplyOrder;
import com.alankin.ucenter.dao.model.ApplyOrderExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ApplyOrderMapper {
    int countByExample(ApplyOrderExample example);

    int deleteByExample(ApplyOrderExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(ApplyOrder record);

    int insertSelective(ApplyOrder record);

    List<ApplyOrder> selectByExample(ApplyOrderExample example);

    ApplyOrder selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") ApplyOrder record, @Param("example") ApplyOrderExample example);

    int updateByExample(@Param("record") ApplyOrder record, @Param("example") ApplyOrderExample example);

    int updateByPrimaryKeySelective(ApplyOrder record);

    int updateByPrimaryKey(ApplyOrder record);

    List<Map> selectBySysUserId(Object reqVo);

    List<Map> cusUserList(Object reqVo);

    List<Map> orderDetail(Object reqVo);

    //用户查找自己的订单
    List<Map> myOrders(Object reqVo);
}
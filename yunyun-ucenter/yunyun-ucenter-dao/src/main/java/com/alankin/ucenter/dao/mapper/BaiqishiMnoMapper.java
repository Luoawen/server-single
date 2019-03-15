package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.BaiqishiMno;
import com.alankin.ucenter.dao.model.BaiqishiMnoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaiqishiMnoMapper {
    int countByExample(BaiqishiMnoExample example);

    int deleteByExample(BaiqishiMnoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaiqishiMno record);

    int insertSelective(BaiqishiMno record);

    List<BaiqishiMno> selectByExample(BaiqishiMnoExample example);

    BaiqishiMno selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaiqishiMno record, @Param("example") BaiqishiMnoExample example);

    int updateByExample(@Param("record") BaiqishiMno record, @Param("example") BaiqishiMnoExample example);

    int updateByPrimaryKeySelective(BaiqishiMno record);

    int updateByPrimaryKey(BaiqishiMno record);

    List<Map> selectMapByExample(BaiqishiMnoExample example);
}
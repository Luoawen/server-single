package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.AfuGuize;
import com.alankin.ucenter.dao.model.AfuGuizeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XXXMapper {
    int countByExample(AfuGuizeExample example);

    int deleteByExample(AfuGuizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AfuGuize record);

    int insertSelective(AfuGuize record);

    List<AfuGuize> selectByExample(AfuGuizeExample example);

    AfuGuize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AfuGuize record, @Param("example") AfuGuizeExample example);

    int updateByExample(@Param("record") AfuGuize record, @Param("example") AfuGuizeExample example);

    int updateByPrimaryKeySelective(AfuGuize record);

    int updateByPrimaryKey(AfuGuize record);
}
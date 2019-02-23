package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.AfuGuize;
import com.alankin.ucenter.dao.model.AfuGuizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AfuGuizeMapper {
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
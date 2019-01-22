package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.SysSys;
import com.alankin.ucenter.dao.model.SysSysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSysMapper {
    int countByExample(SysSysExample example);

    int deleteByExample(SysSysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysSys record);

    int insertSelective(SysSys record);

    List<SysSys> selectByExample(SysSysExample example);

    SysSys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysSys record, @Param("example") SysSysExample example);

    int updateByExample(@Param("record") SysSys record, @Param("example") SysSysExample example);

    int updateByPrimaryKeySelective(SysSys record);

    int updateByPrimaryKey(SysSys record);
}
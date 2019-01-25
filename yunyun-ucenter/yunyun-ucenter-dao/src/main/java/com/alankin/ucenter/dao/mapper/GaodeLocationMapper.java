package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.GaodeLocation;
import com.alankin.ucenter.dao.model.GaodeLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GaodeLocationMapper {
    int countByExample(GaodeLocationExample example);

    int deleteByExample(GaodeLocationExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(GaodeLocation record);

    int insertSelective(GaodeLocation record);

    List<GaodeLocation> selectByExample(GaodeLocationExample example);

    GaodeLocation selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") GaodeLocation record, @Param("example") GaodeLocationExample example);

    int updateByExample(@Param("record") GaodeLocation record, @Param("example") GaodeLocationExample example);

    int updateByPrimaryKeySelective(GaodeLocation record);

    int updateByPrimaryKey(GaodeLocation record);
}
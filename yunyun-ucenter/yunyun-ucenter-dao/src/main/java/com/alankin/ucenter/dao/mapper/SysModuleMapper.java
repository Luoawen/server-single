package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.SysModule;
import com.alankin.ucenter.dao.model.SysModuleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysModuleMapper {
    int countByExample(SysModuleExample example);

    int deleteByExample(SysModuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysModule record);

    int insertSelective(SysModule record);

    List<SysModule> selectByExample(SysModuleExample example);

    SysModule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysModule record, @Param("example") SysModuleExample example);

    int updateByExample(@Param("record") SysModule record, @Param("example") SysModuleExample example);

    int updateByPrimaryKeySelective(SysModule record);

    int updateByPrimaryKey(SysModule record);

    List<SysModule> findSysModuleByParentId(Object id);

    List<SysModule> findAllSysModuleByUserId(Object id);

    List<SysModule> findAllSysModuleByUserIdAndParentId(Object id);

    List<SysModule> findAllSysModule();
}
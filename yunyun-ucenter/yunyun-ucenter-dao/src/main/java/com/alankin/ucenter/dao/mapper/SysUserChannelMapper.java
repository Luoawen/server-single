package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.SysUserChannel;
import com.alankin.ucenter.dao.model.SysUserChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserChannelMapper {
    int countByExample(SysUserChannelExample example);

    int deleteByExample(SysUserChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserChannel record);

    int insertSelective(SysUserChannel record);

    List<SysUserChannel> selectByExample(SysUserChannelExample example);

    SysUserChannel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserChannel record, @Param("example") SysUserChannelExample example);

    int updateByExample(@Param("record") SysUserChannel record, @Param("example") SysUserChannelExample example);

    int updateByPrimaryKeySelective(SysUserChannel record);

    int updateByPrimaryKey(SysUserChannel record);
}
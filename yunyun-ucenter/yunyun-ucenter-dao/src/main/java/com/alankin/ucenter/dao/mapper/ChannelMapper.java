package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.Channel;
import com.alankin.ucenter.dao.model.ChannelExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ChannelMapper {
    int countByExample(ChannelExample example);

    int deleteByExample(ChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Channel record);

    int insertSelective(Channel record);

    List<Channel> selectByExample(ChannelExample example);

    Channel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Channel record, @Param("example") ChannelExample example);

    int updateByExample(@Param("record") Channel record, @Param("example") ChannelExample example);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

    List<Map> channelList(Object o);

    List<Map> channelAcountList(Object o);

    List<Map> verifyList();

    List<Map> adList();

    List<Map> selectAll();
}
package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.ChannelRecord;
import com.alankin.ucenter.dao.model.ChannelRecordExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ChannelRecordMapper {
    int countByExample(ChannelRecordExample example);

    int deleteByExample(ChannelRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChannelRecord record);

    int insertSelective(ChannelRecord record);

    List<ChannelRecord> selectByExample(ChannelRecordExample example);

    ChannelRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChannelRecord record, @Param("example") ChannelRecordExample example);

    int updateByExample(@Param("record") ChannelRecord record, @Param("example") ChannelRecordExample example);

    int updateByPrimaryKeySelective(ChannelRecord record);

    int updateByPrimaryKey(ChannelRecord record);

    List<Map> channelRecordList(Object o);

    List<Map> selectOrderLogByDuration(Object o);

    List<Map> selectUserLogList(Object o);

    List<Map> selectUserLogByDuration(Object o);

    List<Map> selectOrderLogGroupByChanelAndTime(Object o);

    List<Map> selectUserLogGroupByChanelAndTime(Object o);

    Map selectOrderLogSummary(Object o);

    Map selectUserLogSummary(Object o);
}
package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.ChannelRecordMapper;
import com.alankin.ucenter.dao.model.ChannelRecord;
import com.alankin.ucenter.dao.model.ChannelRecordExample;

/**
* 降级实现ChannelRecordService接口
* Created by alankin on 2019/1/7.
*/
public class ChannelRecordServiceMock extends BaseServiceMock<ChannelRecordMapper, ChannelRecord, ChannelRecordExample> implements ChannelRecordService {

}

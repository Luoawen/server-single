package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.ChannelMapper;
import com.alankin.ucenter.dao.model.Channel;
import com.alankin.ucenter.dao.model.ChannelExample;

/**
* 降级实现ChannelService接口
* Created by alankin on 2019/1/8.
*/
public class ChannelServiceMock extends BaseServiceMock<ChannelMapper, Channel, ChannelExample> implements ChannelService {

}

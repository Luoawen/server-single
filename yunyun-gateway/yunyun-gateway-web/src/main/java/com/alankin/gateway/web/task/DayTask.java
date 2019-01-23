package com.alankin.gateway.web.task;

import com.alankin.gateway.web.controller.OperateMngController;
import com.alankin.ucenter.dao.model.Channel;
import com.alankin.ucenter.dao.model.ChannelExample;
import com.alankin.ucenter.dao.model.ChannelRecord;
import com.alankin.ucenter.dao.model.ChannelRecordExample;
import com.alankin.ucenter.rpc.api.ChannelRecordService;
import com.alankin.ucenter.rpc.api.ChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: alankin
 * @Description: TODO
 * @date 创建时间：2019/1/23　13:18
 */
//@Component
public class DayTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(DayTask.class);
    @Autowired
    private ChannelService channelService;
    @Autowired
    private ChannelRecordService channelRecordService;

//    @Scheduled(cron = "0 0 0 * * ?") // 每天0点执行记录任务
    public void channelTask() {
        Calendar calendar0 = Calendar.getInstance();
        calendar0.setTime(new Date());
        calendar0.set(Calendar.HOUR_OF_DAY, 0);
        calendar0.set(Calendar.MINUTE, 0);
        calendar0.set(Calendar.SECOND, 0);

        Calendar calendar24 = Calendar.getInstance();
        calendar24.setTime(new Date());
        calendar24.set(Calendar.HOUR_OF_DAY, 0);
        calendar24.set(Calendar.MINUTE, 0);
        calendar24.set(Calendar.SECOND, 0);

//        List<Channel> channelList = channelService.selectByExample(new ChannelExample());
//        for (Channel channel : channelList) {
//            ChannelRecordExample example = new ChannelRecordExample();
//            //查询每天0点到24点之间的渠道记录
//            example.createCriteria()
//                    .andChannelIdEqualTo(channel.getId())
//                    .andSysUserIdEqualTo(channel.getResponsibleUserId())
//                    .andCreateTimeBetween((int) (calendar0.getTimeInMillis() / 1000), (int) (calendar24.getTimeInMillis() / 1000));
//            ChannelRecord channelRecord = channelRecordService.selectFirstByExample(example);
//            if (channelRecord == null) {//如果没有记录则添加
//
//            } else {//如果存在当天记录则修改
//
//            }
//        }
        LOGGER.error("日期start：" + calendar0.getTime().toString() + "  日期end：" + calendar24.getTime().toString());
    }
}

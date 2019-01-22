package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.DataDicMapper;
import com.alankin.ucenter.dao.model.DataDic;
import com.alankin.ucenter.dao.model.DataDicExample;

/**
* 降级实现DataDicService接口
* Created by alankin on 2019/1/2.
*/
public class DataDicServiceMock extends BaseServiceMock<DataDicMapper, DataDic, DataDicExample> implements DataDicService {

}

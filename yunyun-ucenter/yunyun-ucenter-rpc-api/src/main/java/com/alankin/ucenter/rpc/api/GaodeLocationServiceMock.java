package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.GaodeLocationMapper;
import com.alankin.ucenter.dao.model.GaodeLocation;
import com.alankin.ucenter.dao.model.GaodeLocationExample;

/**
* 降级实现GaodeLocationService接口
* Created by alankin on 2019/2/22.
*/
public class GaodeLocationServiceMock extends BaseServiceMock<GaodeLocationMapper, GaodeLocation, GaodeLocationExample> implements GaodeLocationService {

}

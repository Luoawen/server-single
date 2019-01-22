package com.alankin.ucenter.rpc.api;

import com.alankin.common.base.BaseServiceMock;
import com.alankin.ucenter.dao.mapper.StorageImageMapper;
import com.alankin.ucenter.dao.model.StorageImage;
import com.alankin.ucenter.dao.model.StorageImageExample;

/**
* 降级实现StorageImageService接口
* Created by alankin on 2019/1/1.
*/
public class StorageImageServiceMock extends BaseServiceMock<StorageImageMapper, StorageImage, StorageImageExample> implements StorageImageService {

}

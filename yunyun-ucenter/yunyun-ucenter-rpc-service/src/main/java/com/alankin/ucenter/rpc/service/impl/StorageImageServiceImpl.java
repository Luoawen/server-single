package com.alankin.ucenter.rpc.service.impl;

import com.alankin.common.annotation.BaseService;
import com.alankin.common.base.BaseServiceImpl;
import com.alankin.ucenter.dao.mapper.StorageImageMapper;
import com.alankin.ucenter.dao.model.StorageImage;
import com.alankin.ucenter.dao.model.StorageImageExample;
import com.alankin.ucenter.rpc.api.StorageImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* StorageImageService实现
* Created by alankin on 2019/1/1.
*/
@Service
@Transactional
@BaseService
public class StorageImageServiceImpl extends BaseServiceImpl<StorageImageMapper, StorageImage, StorageImageExample> implements StorageImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageImageServiceImpl.class);

    @Autowired
    StorageImageMapper storageImageMapper;

}
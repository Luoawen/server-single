package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.StorageImage;
import com.alankin.ucenter.dao.model.StorageImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageImageMapper {
    int countByExample(StorageImageExample example);

    int deleteByExample(StorageImageExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(StorageImage record);

    int insertSelective(StorageImage record);

    List<StorageImage> selectByExample(StorageImageExample example);

    StorageImage selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") StorageImage record, @Param("example") StorageImageExample example);

    int updateByExample(@Param("record") StorageImage record, @Param("example") StorageImageExample example);

    int updateByPrimaryKeySelective(StorageImage record);

    int updateByPrimaryKey(StorageImage record);
}
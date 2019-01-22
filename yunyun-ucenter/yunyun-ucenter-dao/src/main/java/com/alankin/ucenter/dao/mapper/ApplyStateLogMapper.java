package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.ApplyStateLog;
import com.alankin.ucenter.dao.model.ApplyStateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyStateLogMapper {
    int countByExample(ApplyStateLogExample example);

    int deleteByExample(ApplyStateLogExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(ApplyStateLog record);

    int insertSelective(ApplyStateLog record);

    List<ApplyStateLog> selectByExample(ApplyStateLogExample example);

    ApplyStateLog selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") ApplyStateLog record, @Param("example") ApplyStateLogExample example);

    int updateByExample(@Param("record") ApplyStateLog record, @Param("example") ApplyStateLogExample example);

    int updateByPrimaryKeySelective(ApplyStateLog record);

    int updateByPrimaryKey(ApplyStateLog record);
}
package com.alankin.ucenter.dao.mapper;

import com.alankin.ucenter.dao.model.LoanReceipt;
import com.alankin.ucenter.dao.model.LoanReceiptExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LoanReceiptMapper {
    int countByExample(LoanReceiptExample example);

    int deleteByExample(LoanReceiptExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(LoanReceipt record);

    int insertSelective(LoanReceipt record);

    List<LoanReceipt> selectByExample(LoanReceiptExample example);

    LoanReceipt selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") LoanReceipt record, @Param("example") LoanReceiptExample example);

    int updateByExample(@Param("record") LoanReceipt record, @Param("example") LoanReceiptExample example);

    int updateByPrimaryKeySelective(LoanReceipt record);

    int updateByPrimaryKey(LoanReceipt record);

    List<Map> loanlist(Object o);

    List<Map> brrowerList(Object o);
}
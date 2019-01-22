package com.alankin.gateway.web.controller;

import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.utils.UserUtils;
import com.alankin.gateway.web.vo.ListVo.ListReqVO;
import com.alankin.gateway.web.vo.ListVo.StringReqVO;
import com.alankin.gateway.web.vo.request.ApplyOrderReqVo;
import com.alankin.gateway.web.vo.response.ListResult;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.dao.model.*;
import com.alankin.ucenter.rpc.api.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 字典接口
 * Created by alankin.
 */
@Controller
@Api(value = "字典接口", description = "字典接口")
@RequestMapping(value = "api/dict")
public class DictController extends BaseWebController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DictController.class);
    @Autowired
    private DataDicService dataDicService;

    @ApiOperation(value = "查询字典")
    @RequestMapping(value = "/{dicType}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public Result dicList(@PathVariable("dicType") String dicType) {
        if (dicType == null) {
            return new Result(ResultConstant.FAILED);
        }
        DataDicExample dicExample = new DataDicExample();
        dicExample.createCriteria().andDataTypeCodeEqualTo(Integer.valueOf(dicType));
        List<DataDic> dataDics = dataDicService.selectByExample(dicExample);
        return new Result(ResultConstant.SUCCESS, dataDics);
    }

    @ApiOperation(value = "修改字典")
    @RequestMapping(value = "/{dicType}/{dicKey}", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Result updateDic(@PathVariable("dicType") String dicType, @PathVariable("dicKey") String dicKey, @RequestBody StringReqVO stringReqVO) {
        if (StringUtils.isEmpty(dicType)) {
            return new Result(ResultConstant.FAILED);
        }

        if (StringUtils.isEmpty(dicKey)) {
            return new Result(ResultConstant.FAILED);
        }

        DataDicExample example = new DataDicExample();
        example.createCriteria()
                .andDataTypeCodeEqualTo(Integer.valueOf(dicType))
                .andDicKeyEqualTo(dicKey);
        DataDic dataDic = dataDicService.selectFirstByExample(example);
        dataDic.setDicValue(stringReqVO.getValue());
        if (dataDicService.updateByPrimaryKeySelective(dataDic) > 0) {
            return new Result(ResultConstant.SUCCESS, dataDic);
        }
        return new Result(ResultConstant.FAILED, null);
    }
}
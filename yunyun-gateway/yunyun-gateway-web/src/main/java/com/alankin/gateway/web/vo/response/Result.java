package com.alankin.gateway.web.vo.response;

import com.alankin.common.base.BaseResult;
import com.alankin.ucenter.common.constant.UcenterResultConstant;

/**
 * Created by alankin on 2018/12/31.
 */
public class Result extends BaseResult {

    public Result(ResultConstant resultConstant, Object data) {
        super(resultConstant.getCode(), resultConstant.getMessage(), data);
    }

    public Result(ResultConstant resultConstant) {
        this(resultConstant, null);
    }

    public Result(int code, String message) {
        super(code, message, null);
    }
}

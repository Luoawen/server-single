package com.alankin.ucenter.common.constant;

import com.alankin.common.base.BaseResult;

/**
 * ucenter系统常量枚举类
 * Created by alankin on 2017/4/26.
 */
public class UcenterResult extends BaseResult {

    public UcenterResult(UcenterResultConstant resultConstant, Object data) {
        super(resultConstant.getCode(), resultConstant.getMessage(), data);
    }

    public UcenterResult(UcenterResultConstant resultConstant) {
        this(resultConstant, null);
    }

    public UcenterResult(int code, String message) {
        super(code, message, null);
    }
}

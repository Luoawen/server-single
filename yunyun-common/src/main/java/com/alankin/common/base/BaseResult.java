package com.alankin.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 统一返回结果类
 * Created by alankin on 2017/2/18.
 */
@ApiModel(value="返回结果")
public class  BaseResult<T> implements Serializable {

    /**
     * 状态码：1成功，其他为失败
     */
    @ApiModelProperty(value = "状态码")
    public int code;

    /**
     * 成功为success，其他为失败原因
     */
    @ApiModelProperty(value = "状态消息")
    public String message;

    /**
     * 数据结果集
     */
    public T data;

    public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

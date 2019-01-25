package com.alankin.gateway.web.base;

import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;

/**
 * 统一返回结果类
 * Created by alankin on 2017/2/18.
 */
public class BaseTokenResult<T> extends Result {
    public String token;

    public BaseTokenResult(ResultConstant resultConstant, Object data, String token) {
        this(resultConstant, data);
        this.token = token;
    }

    public BaseTokenResult(ResultConstant resultConstant, Object data) {
        super(resultConstant, data);
    }

    public BaseTokenResult(ResultConstant resultConstant) {
        super(resultConstant);
    }

    public BaseTokenResult(ResultConstant resultConstant, String token) {
        this(resultConstant);
        this.token = token;
    }

    public BaseTokenResult(int code, String message) {
        super(code, message);
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

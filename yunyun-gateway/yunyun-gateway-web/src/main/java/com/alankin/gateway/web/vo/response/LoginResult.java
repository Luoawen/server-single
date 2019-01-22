package com.alankin.gateway.web.vo.response;

/**
 * Created by alankin on 2018/12/31.
 */
public class LoginResult extends Result {
    public LoginResult(ResultConstant resultConstant, Object data) {
        super(resultConstant, data);
    }

    public LoginResult(ResultConstant resultConstant) {
        super(resultConstant);
    }

    public LoginResult(int code, String message) {
        super(code, message);
    }

    /**
     * 登录TOKEN
     */
    private String token;

    @Override
    public String toString() {
        return "LoginResult{" +
                "token='" + token + '\'' +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

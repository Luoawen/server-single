package com.alankin.gateway.web.vo.response;

/**
 * 系统接口结果常量枚举类
 * Created by alankin on 2017/4/26.
 */
public enum ResultConstant {

    /**
     * 失败
     */
    FAILED(0, "失败"),

    /**
     * 成功
     */
    SUCCESS(1, "成功"),

    //----------------------------------200申请单----------------------------------------
    /**
     * 异常订单
     */
    ORDER_EXCEPTION_ORDER(200, "有异常订单，不能申请"),


    //----------------------------------100全局异常----------------------------------------
    EXCEPTION_FIELD_INVALID(99, "字段异常"),
    EXCEPTION_INVALID(100, "登录信息过期，请重新登录！"),
    EXCEPTION_NO_USER(101, "没有找到登录信息！"),
    EXCEPTION_ACOUNT_OR_PWD_NOT_RIGHT(102, "手机或密码输入错误!"),
    EXCEPTION_NO_ACOUNT(103, "该用户不存在!"),
    EXCEPTION(98, "未知异常!"),

    //----------------------------------300申请用户异常----------------------------------------
    /**
     * 异常订单
     */
    NO_DISTRIBUTE_VERIFY(300, "没有分配审核人"),
    VERIFY_EXCEPTION(301, "审核人状态异常"),
    VERIFY_NOT_PASS(302, "审核未通过"),
    NO_DISTRIBUTE_BROWER(303, "没有分配借款人，无法申请");
    //----------------------------------110全局自定义消息异常----------------------------------------

    public int code;

    public String message;

    ResultConstant(int code, String message) {
        this.code = code;
        this.message = message;
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

}
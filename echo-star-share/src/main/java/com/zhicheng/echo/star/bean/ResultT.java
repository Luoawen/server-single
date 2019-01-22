package com.zhicheng.echo.star.bean;

/**
 * 响应结果
 */
public class ResultT {

    String code;

    String msg;

    Boolean success;

    String flowId;

    String data;

    public ResultT(String code, String msg, Boolean success, String flowId, String data) {
        this.code = code;
        this.msg = msg;
        this.success = success;
        this.flowId = flowId;
        this.data = data;
    }

    public static ResultT getError(){
        return new ResultT("-1","请求失败",false,null,null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

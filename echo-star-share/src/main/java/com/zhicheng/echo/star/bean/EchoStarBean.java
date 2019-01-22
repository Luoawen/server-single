package com.zhicheng.echo.star.bean;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class EchoStarBean {

    /**
     * 用户名(由致诚阿福提供)
     */
    public String user_name;

    /**
     * 用户名的RC4秘钥(由致诚阿福提供)
     */
    public String sign;

    /**
     * 业 务 码(固定值)
     * basic.info.authentication.api
     */
    public String api_name;

    /**
     * 查询原因 参考 ReasonEnum
     * @link ReasonEnum
     */
    public String query_reason;

    /**
     * 查询条件,格式为 json 格式
     */
    public String params;

    public List<NameValuePair> getFormList(){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("user_name", user_name));
        nameValuePairs.add(new BasicNameValuePair("sign", sign));
        nameValuePairs.add(new BasicNameValuePair("api_name", api_name));
        nameValuePairs.add(new BasicNameValuePair("query_reason", query_reason));
        nameValuePairs.add(new BasicNameValuePair("params", params));
        return nameValuePairs;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getApi_name() {
        return api_name;
    }

    public void setApi_name(String api_name) {
        this.api_name = api_name;
    }

    public String getQuery_reason() {
        return query_reason;
    }

    public void setQuery_reason(String query_reason) {
        this.query_reason = query_reason;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}

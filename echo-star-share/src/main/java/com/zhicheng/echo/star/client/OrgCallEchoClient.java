package com.zhicheng.echo.star.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhicheng.echo.star.bean.EchoStarBean;
import com.zhicheng.echo.star.bean.ResultT;
import com.zhicheng.echo.star.utils.HttpClientUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 请求群星系统
 */
public class OrgCallEchoClient {

    //请求平台
    public static void main(String[] args) {

        //查询条件拼接开始
        JSONObject dataJson = new JSONObject();
        dataJson.put("id_no", "");
        dataJson.put("name", "张三");
        //查询条件拼接完成
        //开始查询
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        //用户名
        nameValuePairs.add(new BasicNameValuePair("user_name", "xxxx"));
        //rc4秘钥
        nameValuePairs.add(new BasicNameValuePair("sign", "adrgjjiwiemf"));
        //接口业务码 参考接口文档
        nameValuePairs.add(new BasicNameValuePair("api_name", "credit.evaluation.share.api"));
        // 查询原因
        // LOAN_AUDIT：贷款审批 LOAN_MANAGE：贷后管理 CREDIT_CARD_AUDIT：信用卡审批
        // GUARANTEE_AUDIT:担保资格审查 PRE_GUARANTEE_AUDIT:保前审查
        nameValuePairs.add(new BasicNameValuePair("query_reason", "LOAN_AUDIT"));
        //查询条件,格式为 json 格式
        nameValuePairs.add(new BasicNameValuePair("params", dataJson.toJSONString()));
        String result= HttpClientUtil.doPost("https://starapi.zhichengcredit.com/submit", nameValuePairs, "utf-8");
        //查询完成
        System.out.println("返回结果为:"+result);

    }

    /**
     * 根据url 和form表单请求
     * @param url
     * @param params
     * @return
     */
    public static ResultT sendRequest(String url,List<NameValuePair> params){
        ResultT resultT=null;
        try {
            String strReturn = HttpClientUtil.doPost(url, params, "utf-8");
            if (StringUtils.isBlank(strReturn)){
                return ResultT.getError();
            }
            resultT=JSON.parseObject(strReturn,ResultT.class);
        }catch (Exception e){
            e.printStackTrace();
            return ResultT.getError();
        }
        return resultT;
    }

    /**
     * 根据url和map请求
     * @param url
     * @param params
     * @return
     */
    public static ResultT sendRequest(String url,Map params){
        return sendRequest(url,getParams(params));
    }

    /**
     * 根据url和封装的请求实体进行请求
     * @param url
     * @param starBean
     * @return
     */
    public static ResultT sendRequest(String url, EchoStarBean starBean){
        return sendRequest(url,starBean.getFormList());
    }

    /**
     * 根据url和各参数进行请求
     * @param url
     * @param user_name
     * @param sign
     * @param api_name
     * @param query_reason
     * @param params
     * @return
     */
    public static ResultT sendRequest(String url, String user_name,String sign,String api_name,String query_reason,String params){
        ResultT resultT=null;
        try {
            EchoStarBean starBean=new EchoStarBean();
            starBean.setUser_name(user_name);
            starBean.setSign(sign);
            starBean.setApi_name(api_name);
            starBean.setQuery_reason(query_reason);
            starBean.setParams(params);
            resultT=sendRequest(url,starBean.getFormList());
        }catch (Exception e){
            e.printStackTrace();
            return ResultT.getError();
        }
        return resultT;
    }

    /**
     * 遍历map 组合成form表单
     * @param map
     * @return
     */
    private static List<NameValuePair> getParams(Map map){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        try {
            Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return params;
    }
}

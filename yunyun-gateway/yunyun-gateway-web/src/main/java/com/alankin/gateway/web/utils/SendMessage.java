package com.alankin.gateway.web.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.Random;

public class SendMessage {

    private static final String ACCESS_KEY = "vno5mhZqsqhxWVEQ";                             //用户开发key

    private static final String ACCESS_SECRET =  "hZMLFbQZueThAsyMvCuuLuvjwkmWL2Ty";        //用户开发秘钥

    private static final String SIGN = "29183";

    private static final String TEMPLATE_ID = "44341";

    //普通短信
    public static void sendSms(String mobile, HttpSession session) throws Exception {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod("http://api.1cloudsp.com/api/v2/single_send");
        postMethod.getParams().setContentCharset("UTF-8");
        postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());

        String randomValue = getRandomValue();           //随即生成的6位验证码

        NameValuePair[] data = {
                new NameValuePair("accesskey", ACCESS_KEY),
                new NameValuePair("secret", ACCESS_SECRET),
                new NameValuePair("sign", SIGN),
                new NameValuePair("templateId", TEMPLATE_ID),
                new NameValuePair("mobile", mobile),
                new NameValuePair("content", URLEncoder.encode(randomValue, "utf-8"))//（示例模板：{1}您好，您的订单于{2}已通过{3}发货，运单号{4}）
        };
        postMethod.setRequestBody(data);
        postMethod.setRequestHeader("Connection", "close");

        int statusCode = httpClient.executeMethod(postMethod);

        String result = postMethod.getResponseBodyAsString();

        //返回UUID存入Session
        JSONObject resultJson = (JSONObject)JSONObject.parse(result);
        if ((!StringUtils.isEmpty(resultJson.getString("smUuid"))) && resultJson.getInteger("code")== 0) {
            MsgCodeUtil.saveCode(session, mobile, randomValue);
        }
        System.out.println("statusCode: " + statusCode + ", body: "
                + postMethod.getResponseBodyAsString());
    }

    private static String getRandomValue() {
        String str="0123456789";
        StringBuilder sb=new StringBuilder(6);
        for(int i = 0; i < 6; i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }


    public static void main(String[] args) throws Exception {
        SendMessage t = new SendMessage();
        //普通短信
        //t.sendSms("13668151226");
    }
}

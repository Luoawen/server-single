package com.zhicheng.echo.star.test;

import com.alibaba.fastjson.JSON;
import com.zhicheng.echo.star.client.EchoCallOrgClient;
import com.zhicheng.echo.star.bean.EchoStarBean;
import com.zhicheng.echo.star.bean.ResultT;
import com.zhicheng.echo.star.enums.ReasonEnum;
import com.zhicheng.echo.star.client.OrgCallEchoClient;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EchoStarClientTest {

    private static String api_name="credit.evaluation.share.api";
    private static String url="https://starapi.zhichengcredit.com/submit";
    private static String user_name="username";//用户名
    private static String sign="sign";//rc4秘钥

    @Test
    public void queryShareApi(){
        EchoStarBean starBean=new EchoStarBean();
        starBean.setUser_name(user_name);
        starBean.setSign(sign);
        starBean.setApi_name(api_name);
        starBean.setQuery_reason(ReasonEnum.CREDIT_CARD_AUDIT.getType());
        Map paramMap=new HashMap();
        paramMap.put("id_no","360822198609284091");
        paramMap.put("name","张三");
        starBean.setParams(JSON.toJSONString(paramMap));
        ResultT resultT= OrgCallEchoClient.sendRequest(url,starBean);
        System.out.println("返回结果："+JSON.toJSONString(resultT));
    }

    @Test
    public void decodeResult(){
        try {
            String eString = "ow6X2lFQSklfdWjAMkpY7ReZQPUtBr7%2B4%2B4wuWdidzUCJA4KkMV14TfKnqjgUZXYX2o5udViWH6FEU8SXU3Yeld%2FQlk%3D";
            String key = "7fcd08d4f0891387";
            System.out.println(EchoCallOrgClient.decrypt(eString,key));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

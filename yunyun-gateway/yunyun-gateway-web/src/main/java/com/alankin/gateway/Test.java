package com.alankin.gateway;

import com.alankin.gateway.web.utils.Invoker;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhicheng.echo.star.enums.ReasonEnum;
import com.zhicheng.echo.star.utils.HttpClientUtil;
import com.zhicheng.echo.star.utils.SSLClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by alankin on 2019/2/22.
 */
public class Test {
//    public static void main(String[] args) {
//        String url = "https://credit.baiqishi.com/clweb/api/common/gettoken";
////        partnerId: 'lfme',
////                verifyKey: '0d4aea86b58e4eb781f78966f281ecaa',
////                timeStamp: timeStamp,
////                certNo: this.messageRow.id_card,
////        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
////        nameValuePairs.add(new BasicNameValuePair("partnerId", "lfme"));
////        nameValuePairs.add(new BasicNameValuePair("verifyKey", "0d4aea86b58e4eb781f78966f281ecaa"));
////        long time = new Date().getTime();
////        System.out.println(time);
////        nameValuePairs.add(new BasicNameValuePair("timeStamp", time + ""));
////        nameValuePairs.add(new BasicNameValuePair("certNo", "510129199202114911"));
////        String s = HttpClientUtil.doPost(url, nameValuePairs, "utf-8");
////        System.out.println(s);
//
//        HttpPost httpPost = new HttpPost(url);
//        CloseableHttpClient client = HttpClients.createDefault();
//        String respContent = null;
//
//        JSONObject jsonReqObject = new JSONObject();
//        jsonReqObject.put("certNo", "510129199202114911");
//        jsonReqObject.put("partnerId", "lfme");
//        jsonReqObject.put("verifyKey", "0d4aea86b58e4eb781f78966f281ecaa");
//        String timeStamp = new Date().getTime() + "";//为当前时间戳
//        System.out.println(timeStamp);
//        jsonReqObject.put("timeStamp", timeStamp);
//        StringEntity entity = new StringEntity(jsonReqObject.toString(), "utf-8");//解决中文乱码问题
//        entity.setContentEncoding("UTF-8");
//        entity.setContentType("application/json");
//        httpPost.setEntity(entity);
//
//        HttpResponse resp = null;
//        try {
//            resp = client.execute(httpPost);
//            if (resp.getStatusLine().getStatusCode() == 200) {
//                HttpEntity he = resp.getEntity();
//                respContent = EntityUtils.toString(he, "UTF-8");
//                System.out.println(respContent);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////1550839064637
////        {"resultCode":"CCOM1000","resultDesc":"成功","data":"4B7637716F86F5E4A44AC3BF3C9AF23D50791F81"}
////        https://credit.baiqishi.com/clweb/api/mno/getreportpage?partnerId=lfme&certNo=510129199202114911&name=宋豪&mobile=13688085241&timeStamp=1550839064637&token=4B7637716F86F5E4A44AC3BF3C9AF23D50791F81
//    }

    public static void main(String[] args) {

        Invoker.init();
        //风险决策API生产环境调用地址
        String apiUrl="https://api.baiqishi.com/services/decision";
//        String apiUrl="https://apist.baiqishi.com/services/decision";

        Map params =new HashMap();
        //根据商户修改verifyKey和partnerId
        params.put("verifyKey", "0d4aea86b58e4eb781f78966f281ecaa");
        params.put("partnerId", "lfme");

        //应用的appid，根据调用的应用修改
        params.put("appId", "lfme");

        //业务参数传入
//        params.put("eventType", "login");		//根据触发的场景传入
        params.put("eventType", "loan");		//根据触发的场景传入
        params.put("mobile", "18912345678");
        params.put("name ", "梁富宇");
        params.put("certNo", "150981197202284550");
        params.put("tokenKey", "");

        try {
            long starttime=System.currentTimeMillis();
            String result=	Invoker.invoke(params, apiUrl);
            long endtime=System.currentTimeMillis();
            //返回结果输出
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

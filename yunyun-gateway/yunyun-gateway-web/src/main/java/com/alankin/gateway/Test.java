package com.alankin.gateway;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alankin on 2019/2/22.
 */
public class Test {
    public static void main(String[] args) {
        String url = "https://credit.baiqishi.com/clweb/api/common/gettoken";
//        partnerId: 'lfme',
//                verifyKey: '0d4aea86b58e4eb781f78966f281ecaa',
//                timeStamp: timeStamp,
//                certNo: this.messageRow.id_card,
//        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//        nameValuePairs.add(new BasicNameValuePair("partnerId", "lfme"));
//        nameValuePairs.add(new BasicNameValuePair("verifyKey", "0d4aea86b58e4eb781f78966f281ecaa"));
//        long time = new Date().getTime();
//        System.out.println(time);
//        nameValuePairs.add(new BasicNameValuePair("timeStamp", time + ""));
//        nameValuePairs.add(new BasicNameValuePair("certNo", "510129199202114911"));
//        String s = HttpClientUtil.doPost(url, nameValuePairs, "utf-8");
//        System.out.println(s);

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

        JSONObject jsonReqObject = new JSONObject();
        jsonReqObject.put("certNo", "510129199202114911");
        jsonReqObject.put("partnerId", "lfme");
        jsonReqObject.put("verifyKey", "0d4aea86b58e4eb781f78966f281ecaa");
        String timeStamp = new Date().getTime() + "";//为当前时间戳
        System.out.println(timeStamp);
        jsonReqObject.put("timeStamp", timeStamp);
        StringEntity entity = new StringEntity(jsonReqObject.toString(), "utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        HttpResponse resp = null;
        try {
            resp = client.execute(httpPost);
            if (resp.getStatusLine().getStatusCode() == 200) {
                HttpEntity he = resp.getEntity();
                respContent = EntityUtils.toString(he, "UTF-8");
                System.out.println(respContent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//1550839064637
//        {"resultCode":"CCOM1000","resultDesc":"成功","data":"4B7637716F86F5E4A44AC3BF3C9AF23D50791F81"}
//        https://credit.baiqishi.com/clweb/api/mno/getreportpage?partnerId=lfme&certNo=510129199202114911&name=宋豪&mobile=13688085241&timeStamp=1550839064637&token=4B7637716F86F5E4A44AC3BF3C9AF23D50791F81
    }
}

package com.zhicheng.echo.star.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

/**
 * 进行请求工具类
 *
 * @author zhicheng
 * @date 2018
 */
public class HttpClientUtil {
    @SuppressWarnings("resource")
    public static String doPost(String url, List<NameValuePair> param, String charset) {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            httpPost.setEntity(new UrlEncodedFormEntity(param, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static String doGet(String url, List<NameValuePair> params, String charset) {
        HttpClient httpClient = null;
        String result = null;
//        String urlStr = "https://star.afufintech.com/apiNest/getReport.html?api_name=credit.evaluation.share.api&flow_id=" + flowId + "&user_name=shensudai_testusr&sign=ec6aef1d861d493e";
        try {
            httpClient = HttpClients.createDefault();
         /*
         * 由于GET请求的参数都是拼装在URL地址后方，所以我们要构建一个URL，带参数
         */
            URIBuilder uriBuilder = new URIBuilder(url);
            /** 第一种添加参数的形式 */
        /*uriBuilder.addParameter("name", "root");
        uriBuilder.addParameter("password", "123456");*/
            /** 第二种添加参数的形式 */
//            List<NameValuePair> list = new LinkedList<>();
//            BasicNameValuePair param1 = new BasicNameValuePair("name", "root");
//            BasicNameValuePair param2 = new BasicNameValuePair("password", "123456");
//            list.add(param1);
//            list.add(param2);
            uriBuilder.setParameters(params);
            HttpGet get = new HttpGet(uriBuilder.build());
            HttpResponse response = httpClient.execute(get);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取风险评估报告
     * @param flowId
     * @return
     */
    public static String reqFengxianReport(String flowId) {
        String url = "https://star.afufintech.com/apiNest/getReport.html";
        List<NameValuePair> params = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("api_name", "credit.evaluation.share.api");
        BasicNameValuePair param2 = new BasicNameValuePair("flow_id",flowId);
        BasicNameValuePair param3 = new BasicNameValuePair("user_name","shensudai_testusr");
        BasicNameValuePair param4 = new BasicNameValuePair("sign","ec6aef1d861d493e");
        params.add(param1);
        params.add(param2);
        params.add(param3);
        params.add(param4);
        return doGet(url, params, "utf-8");
    }
}

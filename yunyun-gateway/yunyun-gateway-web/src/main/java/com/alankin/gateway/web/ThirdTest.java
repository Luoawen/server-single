package com.alankin.gateway.web;

import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: alankin
 * @Description: TODO
 * @date 创建时间：2019/1/8　17:06
 */
public class ThirdTest {
//    public static String userid = "gmtxsm01";
    public static String userid = "shensudai01";
//    public static String apiKey = "110978967496774c";
    public static String apiKey = "57577d636f1e193b";
    //    public static String api = "https://www.afufintech.com/ZSS/api/yixin_yys/V1";
    public static String api = "https://www.zhichengcredit.com/echo-center/api/authFetchApi/report";
    public static String username = "13688085241";
    public static String password = "114790";
    public static String name = "宋豪";
    public static String idNumber = "510129199202114911";

    public static void main(String[] args) {

//        登录接口
//        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
//        multiValueMap.add("userid", userid);
//        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
//        multiValueMap.add("op", "collect");
//        multiValueMap.add("username", username);
//        multiValueMap.add("password", password);
//        multiValueMap.add("name",name);
//        multiValueMap.add("idNumber", idNumber);
//        RestTemplate restTemplate = new RestTemplate();
//        String msg = restTemplate.postForObject(api, multiValueMap, String.class);
//        System.out.println(msg);

        //        验证码接口
//        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
//        multiValueMap.add("userid", userid);
//        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
//        multiValueMap.add("op", "code");
//        multiValueMap.add("checkcode", "828335");
//        multiValueMap.add("sid", "SichuanMobile_13688085241_1004");
//        RestTemplate restTemplate = new RestTemplate();
//        String msg = restTemplate.postForObject(api, multiValueMap, String.class);
//        System.out.println(msg);

        //        刷新验证码接口
//        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
//        multiValueMap.add("userid", userid);
//        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
//        multiValueMap.add("op", "code");
//        multiValueMap.add("sid", "SichuanMobile_13688085241_1004");
//        RestTemplate restTemplate = new RestTemplate();
//        String msg = restTemplate.postForObject(api, multiValueMap, String.class);
//        System.out.println(msg);

        //        获取数据接口
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("userid", userid);
        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("idCard",idNumber);
        multiValueMap.add("params", jsonObject.toString());
        RestTemplate restTemplate = new RestTemplate();
        String msg = restTemplate.postForObject(api, multiValueMap, String.class);
        System.out.println(msg);
    }

//    {"errorcode":"0000","message":"OK","data":{"code":"","sid":"SichuanMobile_13688085241_1004","msg":"","type":"1","extra":"","location":"四川","operator":"四川移动"}}
//    {"errorcode":"0000","message":"OK","data":{"code":"","sid":"SichuanMobile_13688085241_1004","msg":"","type":"1","extra":"","location":"四川","operator":"四川移动"}}
//{"errorcode":"61001","message":"LoginError"}

//    {"errorcode":"0000","message":"OK","data":{"code":"","sid":"SichuanMobile_13688085241_1004","msg":"","type":"1","extra":"","location":"四川","operator":"四川移动"}}
//{"errorcode":"0000","message":"OK","data":{"code":"","sid":"SichuanMobile_13688085241_1004","msg":"","type":"1","extra":"","location":"四川","operator":"四川移动"}}
//{"errorcode":"0000","message":"OK","data":{"sid":"SichuanMobile_13688085241_1004","msg":""}}

//{"errorcode":"0000","message":"查询成功","data":{"extra":"登录爬取成功","sid":"jjw38q5D1546948129776"}}
}

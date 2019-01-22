package com.zhicheng.echo.star;

import com.alibaba.fastjson.JSONObject;
import com.zhicheng.echo.star.utils.HttpClientUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
/**
 * 信用评估共享版 V1  平台访问机构
 */
public class CreditEvaluationShareApi2Demo {
    //请求致诚阿福群星接口地址
    private static String api_name="credit.evaluation.share.api";
    private static String url="https://starapi.zhichengcredit.com/submit";
    private static String user_name="username";//用户名
    private static String sign="sign";//rc4秘钥

    //请求平台
    public static void main(String[] args) {
        try {
            /*查询条件拼接 开始*/
            JSONObject dataJson = new JSONObject();
            dataJson.put("id_no", "110123199901011234");//被查询人身份证号 18 位以内
            dataJson.put("name", "张三");//被查询人姓名 2-30 位
            /*查询条件拼接 完成*/

            //开始查询
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            //用户名
            nameValuePairs.add(new BasicNameValuePair("user_name", user_name));
            //rc4秘钥
            nameValuePairs.add(new BasicNameValuePair("sign", sign));
            //接口业务码 参考接口文档
            nameValuePairs.add(new BasicNameValuePair("api_name", api_name));
            // 查询原因
            // LOAN_AUDIT：贷款审批 LOAN_MANAGE：贷后管理 CREDIT_CARD_AUDIT：信用卡审批
            // GUARANTEE_AUDIT:担保资格审查 PRE_GUARANTEE_AUDIT:保前审查
            nameValuePairs.add(new BasicNameValuePair("query_reason", "LOAN_AUDIT"));
            //查询条件,格式为 json 格式
            nameValuePairs.add(new BasicNameValuePair("params", dataJson.toJSONString()));
            String result= HttpClientUtil.doPost(url, nameValuePairs, "utf-8");
            //查询完成
            System.out.println("返回结果为:"+result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.zhicheng.echo.star;

import com.alibaba.fastjson.JSONObject;
import com.zhicheng.echo.star.client.EchoCallOrgClient;
import com.zhicheng.echo.star.utils.HttpClientUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 信用评估共享版 V1  机构访问平台
 */
public class CreditEvaluationShareApiDemo {
    //请求致诚阿福群星接口地址
    private static String sign="sign";//rc4秘钥

    //请求平台
    public static void main(String[] args) {
        try {
            CreditEvaluationShareApiDemo shareApiDemo=new CreditEvaluationShareApiDemo();
            //1.机构调用群星平台
//            shareApiDemo.shareQuery();
            //2.平台调用机构，机构响应结果
            String strData= shareApiDemo.echoCallOrg();//返回密文
            String strParam=EchoCallOrgClient.decrypt(strData,sign);//解密报文
            System.out.println("接到加密请求:"+strData);
            System.out.println("请求解密后："+strParam);
            //TODO 进行业务操作
            shareApiDemo.orgReturnEcho();//返回响应结果
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据提供接口地址，阿福群星调用机构接口
     */
    public String echoCallOrg(){
        String strData="";
        try {
            /*查询条件拼接 开始*/
            JSONObject dataJson = new JSONObject();
            dataJson.put("id_no", "110123199901011234");//被查询人身份证号 18 位以内
            dataJson.put("name", "张三");//被查询人姓名 2-30 位
            /*查询条件拼接 完成*/
            strData= EchoCallOrgClient.encrypt(dataJson.toJSONString(),sign);
            //开始查询
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            //查询条件,格式为 json 格式
            nameValuePairs.add(new BasicNameValuePair("params", strData));
            System.out.println("机构收到报文明文："+dataJson.toJSONString());
            System.out.println("机构收到报文加密："+strData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return strData;
    }

    /**
     * 机构响应结果
     */
    public void orgReturnEcho(){
        try {
            Map loanRecord=new HashMap();
            loanRecord.put("approvalStatus","");//审批结果码
            loanRecord.put("idNo","");//被查询借款人身份证号
            loanRecord.put("loanAmount","");//借款金额，通过的，取合同金额;未通过或审核中的， 取申请金额
            loanRecord.put("loanDate","");//借款时间，通过的，取合同时间;未通过或审核中的， 取申请时间。 作为数据提供方，平台可识别的时间格式有 2 种: YYYYMM或者YYYYMMDD
            loanRecord.put("loanStatus","");//还款状态码，指一笔借款合同当前的状态;若历史出 现过逾期，当前还款正常，则还款状态取“正常”
            loanRecord.put("loanType","");//借款类型码，指一笔借款所属的类型
            loanRecord.put("name","");//被查询借款人姓名
            loanRecord.put("overdueAmount","");//逾期金额，指一笔借款中，达到还款期限，尚未偿还 的总金额
            loanRecord.put("overdueM3","");//历史逾期 M3+次数(不含 M3，包括 M6 及以上)
            loanRecord.put("overdueM6","");//历史逾期 M6+次数(不含 M6)
            loanRecord.put("overdueStatus","");//逾期情况，指一笔借款当前逾期的程度
            loanRecord.put("overdueTotal","");//历史逾期总次数
            loanRecord.put("periods","");//期数, , 通过的，取合同期数;未通过或审核中的，取 申请期数，范围 1~120
            Map riskResult=new HashMap();//风险项记录
            riskResult.put("riskDetail","");//风险明细，合作机构提供的借款人的风险类别
            riskResult.put("riskItemType","");//命中项码，如证件号码(当前命中项仅包括证件号码)
            riskResult.put("riskItemValue","");//命中内容，身份证号的具体值
            riskResult.put("riskTime","");//风险最近时间，指风险记录最近一次发现的时间 平台可识别的时间格式有 3 种: YYYY YYYYMM YYYYMMDD

            List<Map> loanRecords=new ArrayList<>();
            loanRecords.add(loanRecord);
            List<Map> riskResults=new ArrayList<>();
            riskResults.add(riskResult);

            JSONObject resultJson=new JSONObject();//
            Boolean success=true; //成功:true; 失败:false
            JSONObject dataJson=new JSONObject(); //响应结果
            dataJson.put("loanRecords",loanRecords);
            dataJson.put("riskResults",riskResults);
            String strData=EchoCallOrgClient.encrypt(dataJson.toJSONString(),sign);
            System.out.println("data数据明文"+dataJson.toJSONString());
            System.out.println("data数据加密"+strData);
            resultJson.put("success",success);
            resultJson.put("data",strData);
            System.out.println("响应结果"+resultJson.toJSONString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

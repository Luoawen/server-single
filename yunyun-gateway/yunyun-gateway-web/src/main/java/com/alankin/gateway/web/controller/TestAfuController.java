package com.alankin.gateway.web.controller;

import com.alankin.common.util.RequestUtil;
import com.alankin.common.util.key.SnowflakeIdWorker;
import com.alankin.common.util.key.SystemClock;
import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.utils.Constants;
import com.alankin.gateway.web.utils.UserUtils;
import com.alankin.gateway.web.utils.Utils;
import com.alankin.gateway.web.vo.ListVo.IdReqVO;
import com.alankin.gateway.web.vo.ListVo.ListReqVO;
import com.alankin.gateway.web.vo.request.CreateApplyOrderReqVo;
import com.alankin.gateway.web.vo.request.EmergencyReqVo;
import com.alankin.gateway.web.vo.request.UserAuthReqVo;
import com.alankin.gateway.web.vo.request.UserOtherAcountReqVo;
import com.alankin.gateway.web.vo.response.ListResult;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.gateway.web.vo.thirdReq.*;
import com.alankin.ucenter.common.constant.UcenterResult;
import com.alankin.ucenter.common.constant.UcenterResultConstant;
import com.alankin.ucenter.dao.model.*;
import com.alankin.ucenter.rpc.api.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zhicheng.echo.star.enums.ReasonEnum;
import com.zhicheng.echo.star.utils.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 注册控制器
 * Created by alankin.
 */
@Controller
@Api(value = "阿福TDL测试接口", description = "阿福TDL测试接口")
@RequestMapping(value = "api/test", method = RequestMethod.POST)
@Transactional
public class TestAfuController extends BaseWebController {
    @ApiOperation(value = "欺诈甄别设备指纹接口")
    @RequestMapping(value = "testDevicePrintData")
    @ResponseBody
    public void testDevicePrintData(HttpServletRequest request, @RequestBody Map<String, String> vo) {
        //开始查询
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        //用户名
        nameValuePairs.add(new BasicNameValuePair("user_name", "shensudai_testusr"));
        //rc4秘钥
        nameValuePairs.add(new BasicNameValuePair("sign", "ec6aef1d861d493e"));
        //接口业务码 参考接口文档
        nameValuePairs.add(new BasicNameValuePair("api_name", "fraud.screening.device.api"));
        // 查询原因
        // LOAN_AUDIT：贷款审批 LOAN_MANAGE：贷后管理 CREDIT_CARD_AUDIT：信用卡审批
        // GUARANTEE_AUDIT:担保资格审查 PRE_GUARANTEE_AUDIT:保前审查
        nameValuePairs.add(new BasicNameValuePair("query_reason", "LOAN_AUDIT"));
        //查询条件,格式为 json 格式
        nameValuePairs.add(new BasicNameValuePair("params", gennerateDevicePrintRequetParam(request, vo).toJSONString()));
        String s = HttpClientUtil.doPost(Constants.url, nameValuePairs, "utf-8");
        JSONObject jsonObject = JSON.parseObject(s);
        String flowId = jsonObject.getString("flowId");

        String testDevicePrintData = request.getSession().getServletContext().getRealPath("/testDevicePrintData/");
        File filepath = new File(testDevicePrintData, "TDL");
        //判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        FileWriter output = null;
        BufferedWriter writer = null;
        try {
            output = new FileWriter(filepath, true);
            writer = new BufferedWriter(output);
            writer.write("flowId:" + flowId);
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 设备指纹参数构建
     *
     * @return
     */
    public JSONObject gennerateDevicePrintRequetParam(HttpServletRequest request, Map<String, String> vo) {
//        UserLocation userLocation = userLocationService.selectByPrimaryKey(user.getCompanyLocationUid());
        JSONObject dataJson = new JSONObject();
        dataJson.put("queryFraudScreening", "false");//不要进阶版
        dataJson.put("queryDevicePrint", "true");//需要设备指纹
        dataJson.put("amount_business", "0");
//        JSONArray addrArray = new JSONArray();
//        addrArray.add("SELF_MOBILE_1_FAMILY_ADDR");
//        addrArray.add("SELF_MOBILE_1_CORP_ADDR");
//        dataJson.put("addr_detection_types", addrArray);
        dataJson.put("id_no", "510129199202114911");//被查询人身份证号 18 位以内
        dataJson.put("name", "宋豪");//被查询人姓名 2-30 位
        dataJson.put("mobile", "13688085241");
//        dataJson.put("bank_no", "");
//        JSONObject corp_addr_json = new JSONObject();
//        corp_addr_json.put("address", userLocation.getLocation());
//        corp_addr_json.put("city", userLocation.getCurrCity());
//        corp_addr_json.put("county", userLocation.getCurrDistrict());
//        corp_addr_json.put("province", userLocation.getCurrProvince());
//        corp_addr_json.put("postal", "");
//        dataJson.put("corp_addr", corp_addr_json);
//        dataJson.put("corp_name", user.getCompanyName());
//        dataJson.put("corp_tel", user.getCompanyPhone());
        //联系人信息添加开始
//        JSONArray contacts = new JSONArray();
//        JSONObject contactJson = new JSONObject();
//        contactJson.put("contact_id_no", "370633197005042513");
//        contactJson.put("contact_mobile", "15002035914");
//        contactJson.put("contact_name", "高求");
//        contactJson.put("contact_type", "SPOUSE");
//        JSONObject corp_addrjson = new JSONObject();
//        corp_addrjson.put("address", "温特莱B座1910");
//        corp_addrjson.put("city", "北京市");
//        corp_addrjson.put("county", "朝阳区");
//        corp_addrjson.put("province", "北京市");
//        corp_addrjson.put("postal", "100000");
//        contactJson.put("corp_addr", corp_addrjson);
//
//        contactJson.put("corp_name", "微商科技有限公司");
//        contactJson.put("corp_tel", "010-61300110");
//        contactJson.put("email", "123qq@qq.com");
//        JSONObject contactfamily_addrjson = new JSONObject();
//        contactfamily_addrjson.put("address", "温特莱B座1910");
//        contactfamily_addrjson.put("city", "北京市");
//        contactfamily_addrjson.put("county", "朝阳区");
//        contactfamily_addrjson.put("province", "北京市");
//        contactfamily_addrjson.put("postal", "100000");
//        contactJson.put("family_addr", contactfamily_addrjson);
//        contactJson.put("family_tel", "010-61300110");
//        contacts.add(contactJson);
//        dataJson.put("contacts", contacts);
        //联系人封装结束;

//        dataJson.put("email", user.getEmail());
//        JSONObject family_addrjson = new JSONObject();
//        family_addrjson.put("address", "温特莱B座1910");
//        family_addrjson.put("city", "北京市");
//        family_addrjson.put("county", "朝阳区");
//        family_addrjson.put("province", "北京市");
//        dataJson.put("family_addr", family_addrjson);
        //设备指纹事件信息
        JSONObject eventObj = new JSONObject();
        LocalDateTime now = LocalDateTime.now();
//        eventObj.put("time", DateUtils.date2String(new Date(), "YYYY-MM-DD HH:mm:ss.SSS").replace(" ", "T") + "Z");
        eventObj.put("time", now.toString() + "Z");
//        eventObj.put("source", "WEB");
        JSONObject deviceObj = new JSONObject();
        deviceObj.put("ip", RequestUtil.getIpAddr(request));
        JSONObject header = new JSONObject();
        header.put("content-length", request.getContentLength());
        deviceObj.put("headers", header);
        // deviceObj.put("userIdentityCookies",{});
        deviceObj.put("jsc", vo.get("payload"));
        JSONObject hdm = new JSONObject();
        hdm.put("payload", vo.get("hdm"));
        deviceObj.put("hdim", hdm);
        eventObj.put("device", deviceObj);
//        JSONObject sessionObj = new JSONObject();
//        sessionObj.put("id", "sadhausdas929123");
//        sessionObj.put("durationInMillis", "2178000");
//        sessionObj.put("activityPageCode", "login001");
//        eventObj.put("session", sessionObj);
        dataJson.put("event", eventObj);
        return dataJson;
    }
}
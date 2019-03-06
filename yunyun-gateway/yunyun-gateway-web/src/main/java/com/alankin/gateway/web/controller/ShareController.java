package com.alankin.gateway.web.controller;

import com.alankin.common.util.DateUtils;
import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.vo.ListVo.IdReqVO;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.dao.model.ApplyOrder;
import com.alankin.ucenter.dao.model.ApplyOrderExample;
import com.alankin.ucenter.dao.model.UserBase;
import com.alankin.ucenter.dao.model.UserBaseExample;
import com.alankin.ucenter.rpc.api.ApplyOrderService;
import com.alankin.ucenter.rpc.api.UserBaseService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhicheng.echo.star.client.EchoCallOrgClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 注册控制器
 * Created by alankin.
 */
@Controller
@Api(value = "风险评估共享接口", description = "用户接口")
@RequestMapping(value = "api/share", method = RequestMethod.POST)
public class ShareController extends BaseWebController {
    private static String sign = "ec6aef1d861d493e";//rc4秘钥
//    群星平台对接地址：https://starapi.zhichengcredit.com/submit
//    测试用户名：shensudai_testusr
//    测试密钥：ec6aef1d861d493e

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareController.class);
    @Autowired
    private ApplyOrderService applyOrderService;
    @Autowired
    private UserBaseService userBaseService;

    @ApiOperation(value = "平台访问机构数据接口")
    @RequestMapping(value = "query")
    @ResponseBody
    public String query(@RequestParam("params") String strData) {
        String strParam = null;
        try {
            strParam = EchoCallOrgClient.decrypt(strData, sign);//解密报文
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSON.parseObject(strParam);
        String id_no = jsonObject.getString("id_no");
        String name = jsonObject.getString("name");
        return queryData(id_no, name);
    }

    private String queryData(String id_no, String name) {
        Boolean success = true; //成功:true; 失败:false
        JSONObject resultJson = new JSONObject();
        List<Map> loanRecords = new ArrayList<>();
        List<Map> riskResults = new ArrayList<>();

        JSONObject dataJson = new JSONObject(); //响应结果
        dataJson.put("loanRecords", loanRecords);
        dataJson.put("riskResults", riskResults);
        resultJson.put("success", success);

        UserBaseExample example = new UserBaseExample();
        example.createCriteria().andIdCardEqualTo(id_no);
        UserBase userBase = userBaseService.selectFirstByExample(example);
        if (userBase == null) {
            return resultJson.toJSONString();
        }
        ApplyOrderExample orderExample = new ApplyOrderExample();
        orderExample.createCriteria().andApplyUserUidEqualTo(userBase.getUid());
        List<ApplyOrder> applyOrders = applyOrderService.selectByExample(orderExample);
        if (applyOrders == null && applyOrders.size() < 1) {
            return resultJson.toJSONString();
        }

        for (ApplyOrder applyOrder : applyOrders) {

            Map loanRecord = new HashMap();
            loanRecord.put("approvalStatus", "test");//审批结果码
            loanRecord.put("idNo", id_no);//被查询借款人身份证号
            loanRecord.put("loanAmount", "(1000-5000]");//借款金额，通过的，取合同金额;未通过或审核中的， 取申请金额
            loanRecord.put("loanDate", DateUtils.date2String(new Date(applyOrder.getCreateTime() * 1000L), "YYYYMMDD"));//借款时间，通过的，取合同时间;未通过或审核中的， 取申请时间。 作为数据提供方，平台可识别的时间格式有 2 种: YYYYMM或者YYYYMMDD
            loanRecord.put("loanStatus", "NORMAL");//还款状态码，指一笔借款合同当前的状态;若历史出 现过逾期，当前还款正常，则还款状态取“正常” NORMAL COMPLETED
            loanRecord.put("loanType", "CREDIT");//借款类型码，指一笔借款所属的类型
            loanRecord.put("name", name);//被查询借款人姓名
            loanRecord.put("overdueAmount", "1000");//逾期金额，指一笔借款中，达到还款期限，尚未偿还 的总金额
            loanRecord.put("overdueM3", "0");//历史逾期 M3+次数(不含 M3，包括 M6 及以上)
            loanRecord.put("overdueM6", "0");//历史逾期 M6+次数(不含 M6)
            loanRecord.put("overdueStatus", "");//逾期情况，指一笔借款当前逾期的程度
            loanRecord.put("overdueTotal", "0");//历史逾期总次数
            loanRecord.put("periods", applyOrder.getLoanDuration());//期数, , 通过的，取合同期数;未通过或审核中的，取 申请期数，范围 1~120
            Map riskResult = new HashMap();//风险项记录
            riskResult.put("riskDetail", "");//风险明细，合作机构提供的借款人的风险类别
            riskResult.put("riskItemType", "");//命中项码，如证件号码(当前命中项仅包括证件号码)
            riskResult.put("riskItemValue", "");//命中内容，身份证号的具体值
            riskResult.put("riskTime", "");//风险最近时间，指风险记录最近一次发现的时间 平台可识别的时间格式有 3 种: YYYY YYYYMM YYYYMMDD

            loanRecords.add(loanRecord);
            riskResults.add(riskResult);
        }
        try {
            String strData = EchoCallOrgClient.encrypt(dataJson.toJSONString(), sign);
            resultJson.put("data", strData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJson.toJSONString();
    }

    //    msgCode	String	是	数据获取的返回码，参见返回码字典表
//    msgDesc	String	是	数据获取的返回描述
//    dataType	String	是	数据类型，参见数据类型字典表
//    name	String	是	用户姓名
//    mobile	String	是	用户手机号
//    certNo	String	是	用户身份证
//    customParam	String	否	后端回传参数（H5授信方式填写该参数才会进行回传）
    @ApiOperation(value = "白骑士授信回传接口")
    @RequestMapping(value = "baiqishiShouXinCallback")
    @ResponseBody
    @Transactional
    public Map<String, String> baiqishiShouXinCallback(@RequestBody Map<String, String> params) {
        LOGGER.error("回调接口baiqishiShouXinCallback----------------start");
        Map<String, String> ret = new HashMap<>();
//        CCOM1000	成功
//        CCOM8999	失败

        String msgCode = params.get("msgCode");
        String msgDesc = params.get("msgDesc");
        String dataType = params.get("dataType");
        String name = params.get("name");
        String mobile = params.get("mobile");
        String certNo = params.get("certNo");
        String customParam = params.get("customParam");
        UserBaseExample example = new UserBaseExample();
        if (StringUtils.isEmpty(customParam)) {
            example.createCriteria().andMobileEqualTo(mobile);
        } else {
            example.createCriteria().andMobileEqualTo(mobile).andUidEqualTo(Long.valueOf(customParam));
        }
        UserBase userBase = userBaseService.selectFirstByExample(example);
//        CCOM1000	成功
//        CCOM3074	缓存成功（缓存机制，用户第一次授信成功后，再次授信会走缓存机制，返回上一次成功的数据，不再进行爬取）
//        CCOM3016	采集数据失败
        if ("CCOM1000".equalsIgnoreCase(msgCode)||"CCOM3074".equalsIgnoreCase(msgCode)) {//授信成功
            if ("mno".equalsIgnoreCase(dataType)) {
                if (userBase != null && userBase.getOperateBaiqishiState() == 0) {
                    userBase.setOperateBaiqishiState(2);//0未授信   1爬取成功  2授信成功
                    int i = userBaseService.updateByPrimaryKeySelective(userBase);
                    ret.put("resultCode", "CCOM1000");
                    ret.put("resultDesc", "运营商授信成功" + i);
                    return ret;
                }
            } else if ("tb".equalsIgnoreCase(dataType)) {
                if (userBase != null && userBase.getTaobaoBaiqishiState() == 0) {
                    userBase.setTaobaoBaiqishiState(2);
                    int i = userBaseService.updateByPrimaryKeySelective(userBase);
                    ret.put("resultCode", "CCOM1000");
                    ret.put("resultDesc", "淘宝授信成功" + i);
                    return ret;
                }
            }
        } else {//授信失败
            if ("mno".equalsIgnoreCase(dataType)) {
                if (userBase != null && userBase.getOperateBaiqishiState() == 2) {
                    userBase.setOperateBaiqishiState(0);//0未授信   1爬取成功  2授信成功
                    int i = userBaseService.updateByPrimaryKeySelective(userBase);
                    ret.put("resultCode", "CCOM8999");
                    ret.put("resultDesc", "运营商授信失败" + i);
                    return ret;
                }
            } else if ("tb".equalsIgnoreCase(dataType)) {
                if (userBase != null && userBase.getTaobaoBaiqishiState() == 2) {
                    userBase.setTaobaoBaiqishiState(0);
                    int i = userBaseService.updateByPrimaryKeySelective(userBase);
                    ret.put("resultCode", "CCOM8999");
                    ret.put("resultDesc", "淘宝授信失败" + i);
                    return ret;
                }
            }
        }

        LOGGER.error("回调接口baiqishiShouXinCallback----------------end");
        ret.put("resultCode", "CCOM8999");
        ret.put("resultDesc", "失败");
        return ret;
//        resultCode	String	是	数据获取的结果码，参见结果码字典表
//        resultDesc	String	是	结果描述，若有更加详细的结果描述会以“［详细描述］”追加在后面；例如：参数不合法[partnerId为空]
    }

    @ApiOperation(value = "白骑士爬取回传接口")
    @RequestMapping(value = "baiqishiPaQuCallback")
    @ResponseBody
    @Transactional
    public Map<String, String> baiqishiPaQuCallback(@RequestBody Map<String, String> params) {
        LOGGER.error("回调接口baiqishiPaQuCallback----------------start");
        Map<String, String> ret = new HashMap<>();
//        CCOM1000	成功
//        CCOM8999	失败
        String msgCode = params.get("msgCode");
        String msgDesc = params.get("msgDesc");
        String dataType = params.get("dataType");
        String name = params.get("name");
        String mobile = params.get("mobile");
        String certNo = params.get("certNo");
        String customParam = params.get("customParam");
        UserBaseExample example = new UserBaseExample();
        if (StringUtils.isEmpty(customParam)) {
            example.createCriteria().andMobileEqualTo(mobile);
        } else {
            example.createCriteria().andMobileEqualTo(mobile).andUidEqualTo(Long.valueOf(customParam));
        }
        UserBase userBase = userBaseService.selectFirstByExample(example);
//        CCOM1000	成功
//        CCOM3074	缓存成功（缓存机制，用户第一次授信成功后，再次授信会走缓存机制，返回上一次成功的数据，不再进行爬取）
//        CCOM3016	采集数据失败
        if ("CCOM1000".equalsIgnoreCase(msgCode)||"CCOM3074".equalsIgnoreCase(msgCode)) {//爬取
            if ("mno".equalsIgnoreCase(dataType)) {
                if (userBase != null && userBase.getOperateBaiqishiState() != 1) {
                    userBase.setOperateBaiqishiState(1);//0未授信   1爬取成功  2授信成功
                    int i = userBaseService.updateByPrimaryKeySelective(userBase);
                    ret.put("resultCode", "CCOM1000");
                    ret.put("resultDesc", "运营商爬取成功" + i);
                    return ret;
                }
            } else if ("tb".equalsIgnoreCase(dataType)) {
                if (userBase != null && userBase.getTaobaoBaiqishiState() != 1) {
                    userBase.setTaobaoBaiqishiState(1);
                    int i = userBaseService.updateByPrimaryKeySelective(userBase);
                    ret.put("resultCode", "CCOM1000");
                    ret.put("resultDesc", "淘宝爬取成功" + i);
                    return ret;
                }
            }
        } else {//授信成功，爬取失败
            if ("mno".equalsIgnoreCase(dataType)) {
                if (userBase != null && userBase.getOperateBaiqishiState() == 1) {
                    userBase.setOperateBaiqishiState(2);//0未授信   1爬取成功  2授信成功
                    int i = userBaseService.updateByPrimaryKeySelective(userBase);
                    ret.put("resultCode", "CCOM8999");
                    ret.put("resultDesc", "运营商爬取失败" + i);
                    return ret;
                }
            } else if ("tb".equalsIgnoreCase(dataType)) {
                if (userBase != null && userBase.getTaobaoBaiqishiState() == 1) {
                    userBase.setTaobaoBaiqishiState(2);
                    int i = userBaseService.updateByPrimaryKeySelective(userBase);
                    ret.put("resultCode", "CCOM8999");
                    ret.put("resultDesc", "淘宝爬取失败" + i);
                    return ret;
                }
            }
        }
        LOGGER.error("回调接口baiqishiPaQuCallback----------------end");
        ret.put("resultCode", "CCOM8999");
        ret.put("resultDesc", "失败");
        return ret;
//        resultCode	String	是	数据获取的结果码，参见结果码字典表
//        resultDesc	String	是	结果描述，若有更加详细的结果描述会以“［详细描述］”追加在后面；例如：参数不合法[partnerId为空]
    }
}
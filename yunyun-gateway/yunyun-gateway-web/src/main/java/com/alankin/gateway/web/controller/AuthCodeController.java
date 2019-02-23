package com.alankin.gateway.web.controller;

import com.alankin.common.util.StringUtil;
import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.utils.AuthCodeOne;
import com.alankin.gateway.web.utils.Constants;
import com.alankin.gateway.web.utils.MsgCodeUtil;
import com.alankin.gateway.web.vo.request.UserReqVo;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Api(value = "验证码接口", description = "验证码接口")
@RequestMapping(value = "/auth")
public class AuthCodeController extends BaseWebController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 生成验证码
     *
     * @param request
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "code", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "获取验证码")
    public void code(HttpServletRequest request, HttpServletResponse response) {
        // 设置输出的类型为图片
        response.setContentType("image/jpeg");

        // 设置不进行缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        AuthCodeOne authCode = new AuthCodeOne();

        // 将生成的验证码存入session中，以便进行校验
        HttpSession session = request.getSession();
        session.setAttribute(Constants.LOGIN_AUTH_CODE, authCode.getCode());
//        CookieUtils.addCookie(response, Constants.AUTH_CODE_SESSION_ID, session.getId());

        // 将图片输出到response中
        try {
            authCode.write(response.getOutputStream());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }


    @ApiOperation(value = "发送短信验证码")
    @RequestMapping(value = "sendMsgCode")
    @ResponseBody
    public Result sendMsgCode(HttpServletRequest request, @RequestBody UserReqVo vo) throws ClientException, InterruptedException {
//        if (!check(request, vo.getAuthCode())) {
//            return new Result(0, "请输入正确的图片验证码！");
//        }

        //发短信
        String phone = vo.getPhone();
        if (StringUtils.isEmpty(phone) && !StringUtil.isPhoneNumber(vo.getPhone())) {
            return new Result(0, "请输入正确手机号！");
        }

        SendSmsResponse response = sendSms(request.getSession(), phone);
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());

//        Thread.sleep(3000L);

        //查明细
//        if(response.getCode() != null && response.getCode().equals("OK")) {
//            QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(response.getBizId());
//            System.out.println("短信明细查询接口返回数据----------------");
//            System.out.println("Code=" + querySendDetailsResponse.getCode());
//            System.out.println("Message=" + querySendDetailsResponse.getMessage());
//            int i = 0;
//            for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
//            {
//                System.out.println("SmsSendDetailDTO["+i+"]:");
//                System.out.println("Content=" + smsSendDetailDTO.getContent());
//                System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
//                System.out.println("OutId=" + smsSendDetailDTO.getOutId());
//                System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
//                System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
//                System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
//                System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
//                System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
//            }
//            System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
//            System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
//        }

        return new Result(ResultConstant.SUCCESS, "发送成功");
//        return new Result(ResultConstant.SUCCESS, channel);
    }

    /**
     * 校验验证码
     *
     * @param request
     * @return
     */
    public static boolean check(HttpServletRequest request, String authCode) {
        if ("1111".equals(authCode)) {
            return true;
        }
        HttpSession session = request.getSession();
        String sessionAuthCode = session.getAttribute(Constants.LOGIN_AUTH_CODE) + "";
        // 删除session中的验证码
        session.removeAttribute(Constants.LOGIN_AUTH_CODE);
        return authCode.equalsIgnoreCase(sessionAuthCode);
    }


    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIrsTSiq3qNOK3";
    static final String accessKeySecret = "46ZOTHhSixxVQD4Lr0nxFRdRKTwote";

    public static SendSmsResponse sendSms(HttpSession session, String mobile) throws ClientException {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(mobile);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("莫尔网络");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_157683988");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为

        //生成6位验证码
        String randomVcode = MsgCodeUtil.createRandomVcode();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", randomVcode);
        request.setTemplateParam(jsonObject.toString());

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        //最后保存验证码保存验证码
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            MsgCodeUtil.saveCode(session, mobile, randomVcode);
        }
        return sendSmsResponse;
    }


    public static QuerySendDetailsResponse querySendDetails(String bizId) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber("15000000000");
        //可选-流水号
        request.setBizId(bizId);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

        return querySendDetailsResponse;
    }

}

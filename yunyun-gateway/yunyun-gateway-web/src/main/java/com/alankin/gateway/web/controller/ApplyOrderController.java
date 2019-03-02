package com.alankin.gateway.web.controller;

import com.alankin.common.util.SessionUtil;
import com.alankin.common.util.key.SystemClock;
import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.utils.Constants;
import com.alankin.gateway.web.utils.UserUtils;
import com.alankin.gateway.web.utils.Utils;
import com.alankin.gateway.web.vo.ListVo.IdReqVO;
import com.alankin.gateway.web.vo.ListVo.ListReqVO;
import com.alankin.gateway.web.vo.request.ApplyOrderReqVo;
import com.alankin.gateway.web.vo.request.CusUserListReqVo;
import com.alankin.gateway.web.vo.request.UserAuthReqVo;
import com.alankin.gateway.web.vo.request.VerifyCustomerReqVo;
import com.alankin.gateway.web.vo.response.ListResult;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.dao.model.*;
import com.alankin.ucenter.rpc.api.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.zhicheng.echo.star.utils.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 申请单接口
 * Created by alankin.
 */
@Controller
@Api(value = "申请单接口", description = "申请单接口")
@RequestMapping(value = "api/ApplyOrder", method = RequestMethod.POST)
public class ApplyOrderController extends BaseWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyOrderController.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private ApplyOrderService applyOrderService;
    @Autowired
    private ApplyStateLogService applyStateLogService;
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleUserService sysRoleUserService;
    @Autowired
    private ChannelService channelService;
    @Autowired
    private UserEmergencyContactService emergencyContactService;
    @Autowired
    private UserOtherAcountService userOtherAcountService;
    @Autowired
    private GaodeLocationService gaodeLocationService;
    @Autowired
    private AfuGuizeService afuGuizeService;

    @ApiOperation(value = "所有申请单列表")
    @RequestMapping(value = "/orderList")
    @ResponseBody
    @Transactional
    public ListResult orderList(HttpServletRequest request, @RequestBody ListReqVO<ApplyOrderReqVo> listReqVO) {
        //从session获取用户信息
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        PageInfo pageInfo = null;
        //判断用户是否是超级管理员
        if (sysRole.getType() == 1) {//如果是超级管理员，展示所有列表
            pageInfo = applyOrderService.selectForStartPageByMethod("selectBySysUserId", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        } else if (sysRole.getType() == 4) {//出借人看申请单
            listReqVO.getCondition().setUid(sysUser.getUid());
            pageInfo = applyOrderService.selectForStartPageByMethod("selectBySysUserId", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        }
        if (pageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED);
    }

    @ApiOperation(value = "出借人修改申请单状态")
    @RequestMapping(value = "/updateOrderState")
    @ResponseBody
    @Transactional
    public Result updateOrderState(HttpServletRequest request, @RequestBody Map<String, String> map) {
        //从session获取用户信息
        SysUserBase sysUser = UserUtils.getSysUser(request);

        String applyState = map.get("applyState");
        String orderUid = map.get("orderUid");
        if (StringUtils.isEmpty(applyState) || StringUtils.isEmpty(orderUid)) {
            return new Result(ResultConstant.FAILED);
        }
        ApplyOrder applyOrder = applyOrderService.selectByPrimaryKey(Long.valueOf(orderUid));
        if (applyOrder == null) {//申请单不存在
            return new Result(ResultConstant.FAILED);
        }
        ApplyStateLogExample example = new ApplyStateLogExample();
        example.createCriteria().andOrderIdEqualTo(Long.valueOf(orderUid)).andNowStateEqualTo(Integer.valueOf(applyState));
        ApplyStateLog applyStateLog = applyStateLogService.selectFirstByExample(example);
        if (applyStateLog == null) {//不存在该状态的修改记录，则创建
            ApplyStateLog record = new ApplyStateLog();
            record.setLastState(applyOrder.getState());
            record.setNowState(Integer.valueOf(applyState));
            record.setOrderId(applyOrder.getUid());
            record.setSysUserId(sysUser.getUid());
            applyStateLogService.insertSelective(record);
        } else {//存在,则修改时间
            applyStateLog.setCreateTime((int) (SystemClock.now() / 1000));
            applyStateLogService.updateByPrimaryKey(applyStateLog);
        }
        applyOrder.setState(Integer.valueOf(applyState));
        if (applyOrderService.updateByPrimaryKeySelective(applyOrder) > 0) {
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "申请用户详情")
    @RequestMapping(value = "/userDetail")
    @ResponseBody
    @Transactional
    public Result userDetail(@RequestBody IdReqVO idReqVO) {
        //从session获取用户信息
//        SysUserBase sysUser = UserUtils.getSysUser(request);
//        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
//        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
//        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
//        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        UserBase userBase = null;
        userBase = userBaseService.selectByPrimaryKey(idReqVO.getId());
        if (userBase != null) {
            return new Result(ResultConstant.SUCCESS, getUserResult(userBase));
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @Autowired
    private UserLocationService userLocationService;

    private UserAuthReqVo getUserResult(UserBase userBase) {
        UserAuthReqVo userAuthReqVo = new UserAuthReqVo();
        BeanUtils.copyProperties(userBase, userAuthReqVo);
        userAuthReqVo.setUid(String.valueOf(userBase.getUid()));
        UserLocationExample example = new UserLocationExample();
        if (userBase.getCompanyLocationUid() == null || userBase.getCompanyLocationUid() == 0) {
            return userAuthReqVo;
        }
        example.createCriteria().andUidEqualTo(userBase.getCompanyLocationUid());
        UserLocation userLocation = userLocationService.selectFirstByExample(example);
        userAuthReqVo.setCompanyProvance(userLocation.getCurrProvince());
        userAuthReqVo.setCompanyCity(userLocation.getCurrCity());
        userAuthReqVo.setCompanyArea(userLocation.getCurrDistrict());
        userAuthReqVo.setCompanyLocationDetail(userLocation.getLocation());
        return userAuthReqVo;
    }

    @ApiOperation(value = "查询渠道")
    @RequestMapping(value = "/orderChanelAll")
    @ResponseBody
    @Transactional
    public Result orderChanelAll(HttpServletRequest request) {
        //从session获取用户信息
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        List<Map> data = null;
        //判断用户是否是超级管理员
//        if (sysRole.getType() == 1) {//如果是超级管理员，展示所有列表
        data = channelService.selectAllByMethod("selectAll");
//        } else if (sysRole.getType() == 2) {//审核员
//            data = channelService.selectAllByMethod("selectBySysUserId", sysUser.getUid());
//        }
        if (data == null) {
            return new Result(ResultConstant.FAILED, null);
        }
        return new Result(ResultConstant.SUCCESS, data);
    }

    @ApiOperation(value = "所有客户列表")
    @RequestMapping(value = "/cusUserList")
    @ResponseBody
    @Transactional
    public ListResult cusUserList(HttpServletRequest request, @RequestBody ListReqVO<CusUserListReqVo> listReqVO) {
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        PageInfo pageInfo = null;
        //判断用户是否是超级管理员
        if (sysRole.getType() == 1) {//如果是超级管理员查看客户列表
            pageInfo = applyOrderService.selectForStartPageByMethod("cusUserList", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        } else if (sysRole.getType() == 2) {//审核员查看客户列表
            listReqVO.getCondition().setVerifyUid(sysUser.getUid());
            pageInfo = applyOrderService.selectForStartPageByMethod("cusUserList", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        }
        if (pageInfo != null) {
            decorate(pageInfo);
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED);
    }

    private void decorate(PageInfo pageInfo) {
        List list = pageInfo.getList();
        for (Object o : list) {
            Map map = (Map) o;
            rateJiben(map);
            UserOtherAuthExample example = new UserOtherAuthExample();
            example.createCriteria().andUidEqualTo((Long) map.get("uid")).andIdentityTypeEqualTo((byte) 1);
            UserOtherAuth taobao = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
            if (taobao == null || StringUtils.isEmpty(taobao.getThirdData())) {
                map.put("isTaobaoVerify", false);
            } else {
                map.put("isTaobaoVerify", true);
            }
            example.clear();
            example.createCriteria().andUidEqualTo((Long) map.get("uid")).andIdentityTypeEqualTo((byte) 2);
            UserOtherAuth yunyin = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
            if (yunyin == null || StringUtils.isEmpty(yunyin.getThirdData())) {
                map.put("isYunyinVerify", false);
            } else {
                map.put("isYunyinVerify", true);
            }
            example.clear();
            example.createCriteria().andUidEqualTo((Long) map.get("uid")).andIdentityTypeEqualTo((byte) 3);
            UserOtherAuth duotou = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
            if (duotou == null || StringUtils.isEmpty(duotou.getThirdData())) {
                map.put("isDuotouVerify", false);
            } else {
                map.put("isDuotouVerify", true);
            }
            example.clear();
            example.createCriteria().andUidEqualTo((Long) map.get("uid")).andIdentityTypeEqualTo((byte) 4);
            UserOtherAuth qizha = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
            if (qizha == null || StringUtils.isEmpty(qizha.getThirdData())) {
                map.put("isqizhaVerify", false);
            } else {
                map.put("isqizhaVerify", true);
            }
            UserContactsExample contactsExample = new UserContactsExample();
            contactsExample.createCriteria().andUserUidEqualTo((Long) map.get("uid"));
            int count = userContactsService.countByExample(contactsExample);
            map.put("contactsCount", count);
        }
    }

    @Autowired
    private UserOtherAuthService userOtherAuthService;
    @Autowired
    private UserContactsService userContactsService;

    /**
     * 计算基本资料百分比
     *
     * @param map
     */
    private void rateJiben(Map map) {
        int count = 0;
        if (map.get("user_real_name") != null && !StringUtils.isEmpty(map.get("user_real_name").toString())) {
            count++;
        }
        if (map.get("id_card") != null && !StringUtils.isEmpty(map.get("id_card").toString())) {
            count++;
        }
        if (map.get("id_card_photo_1") != null && !StringUtils.isEmpty(map.get("id_card_photo_1").toString())) {
            count++;
        }
        if (map.get("id_card_photo_2") != null && !StringUtils.isEmpty(map.get("id_card_photo_2").toString())) {
            count++;
        }
        if (map.get("id_card_photo_3") != null && !StringUtils.isEmpty(map.get("id_card_photo_3").toString())) {
            count++;
        }
        if (map.get("wchat_id") != null && !StringUtils.isEmpty(map.get("wchat_id").toString())) {
            count++;
        }
        if (map.get("ali_score") != null && !StringUtils.isEmpty(map.get("ali_score").toString())) {
            count++;
        }
        if (map.get("company_name") != null && !StringUtils.isEmpty(map.get("company_name").toString())) {
            count++;
        }
        if (map.get("company_location_uid") != null && !StringUtils.isEmpty(map.get("company_location_uid").toString())) {
            count++;
        }
        if (map.get("company_phone") != null && !StringUtils.isEmpty(map.get("company_phone").toString())) {
            count++;
        }
        if (map.get("salary") != null && !StringUtils.isEmpty(map.get("salary").toString())) {
            count++;
        }
        if (map.get("company_job") != null && !StringUtils.isEmpty(map.get("company_job").toString())) {
            count++;
        }
        map.put("jibenRate", count / 12f);
    }


    @ApiOperation(value = "申请单详情")
    @RequestMapping(value = "/orderDetail")
    @ResponseBody
    @Transactional
    public Result orderDetail(@RequestBody IdReqVO idReqVO) {
        List<Map> maps = applyOrderService.selectAllByMethod("orderDetail", idReqVO);
        if (maps != null && maps.size() > 0) {
            return new Result(ResultConstant.SUCCESS, maps.get(0));
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "审核申请人")
    @RequestMapping(value = "/verifyCustomer")
    @ResponseBody
    @Transactional
    public Result verifyCustomer(@RequestBody VerifyCustomerReqVo vo) {
        UserBase userBase = userBaseService.selectByPrimaryKey(vo.getUserUid());
        if (userBase == null) {
            return new Result(ResultConstant.FAILED);
        }
        Integer verifyStateKey = vo.getVerifyStateKey();
        if (verifyStateKey == 2) {
            userBase.setVerifyStateTime((int) (SystemClock.now() / 1000));
        }
        userBase.setVerifyStateKey(verifyStateKey);
        userBase.setBrowerUid(vo.getBrowerUid());
        if (userBaseService.updateByPrimaryKeySelective(userBase) > 0) {
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED);
    }

    //用户创建申请单
//    @ApiOperation(value = "用户创建申请单")
//    @RequestMapping(value = "/create")
//    @ResponseBody
//    public Result create(HttpServletRequest request, @Valid @RequestBody ApplyOrderReqVo orderReqVo) {
//        //查看用户是否有异常状态的订单
//        ApplyOrderExample orderExample = new ApplyOrderExample();
//        orderExample.createCriteria().andStateNotEqualTo(4);
//        ApplyOrder exceptionOrder = applyOrderService.selectFirstByExample(orderExample);
//        if (exceptionOrder != null) {
//            return new Result(ResultConstant.ORDER_EXCEPTION_ORDER);
//        }
//
//        ApplyOrder applyOrder = new ApplyOrder();
//        BeanUtils.copyProperties(orderReqVo, applyOrder);
//        applyOrder.setState(1);
//        applyOrder.setApplyUserUid(UserUtils.getUser(request).getUid());
//        applyOrderService.insertSelective(applyOrder);
//        return new Result(ResultConstant.SUCCESS, applyOrder);
//    }

    /*暂时不用*/
//    @ApiOperation(value = "多头接口报告")
//    @RequestMapping(value = "mutiDataReport", method = RequestMethod.GET)
//    @ApiImplicitParam(name = "userUid", value = "用户Uid", dataType = "long", paramType = "query")
//    public void mutiDataReport(Long userUid, HttpServletResponse response) throws IOException {
//        UserOtherAuthExample example = new UserOtherAuthExample();
//        example.createCriteria().andUidEqualTo(userUid).andIdentityTypeEqualTo((byte) 3);
//        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
//        if (userOtherAuth == null || StringUtils.isEmpty(userOtherAuth.getThirdData())) {//存在
//            Utils.writeResponesObj(response, new Result(0, "获取多头数据失败"));
//        }
//        String thirdData = userOtherAuth.getThirdData();
//        JSONObject jsonObject = JSON.parseObject(thirdData);
//        String flowId = jsonObject.getString("flowId");
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.println(HttpClientUtil.reqFengxianReport(flowId));
//    }

    @ApiOperation(value = "获取多头报告参数")
    @RequestMapping(value = "/getMutiQianTaoParams")
    @ResponseBody
    public Result getMutiQianTaoParams(@RequestBody IdReqVO idReqVO, HttpServletResponse response) throws IOException {
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(idReqVO.getId()).andIdentityTypeEqualTo((byte) 3);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        if (userOtherAuth == null || StringUtils.isEmpty(userOtherAuth.getThirdData())) {//存在
            return new Result(0, "获取多头数据失败");
        }
        String thirdData = userOtherAuth.getThirdData();
        JSONObject jsonObject = JSON.parseObject(thirdData);
        String flowId = jsonObject.getString("flowId");
        Map<String, String> data = new HashMap<>();
        data.put("api_name", "credit.evaluation.share.api");
        data.put("flow_id", flowId);
        data.put("user_name", Constants.muti_user_name);
        data.put("sign", Constants.muti_sign);
        return new Result(ResultConstant.SUCCESS, data);
    }

    @ApiOperation(value = "获取欺诈报告参数")
    @RequestMapping(value = "/getQiZhaiQianTaoParams")
    @ResponseBody
    public Result getQiZhaiQianTaoParams(@RequestBody IdReqVO idReqVO, HttpServletResponse response) throws IOException {
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(idReqVO.getId()).andIdentityTypeEqualTo((byte) 4);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        if (userOtherAuth == null || StringUtils.isEmpty(userOtherAuth.getThirdData())) {//存在
            return new Result(0, "获取多头数据失败");
        }
        String thirdData = userOtherAuth.getThirdData();
        JSONObject jsonObject = JSON.parseObject(thirdData);
        String flowId = jsonObject.getString("flowId");
        Map<String, String> data = new HashMap<>();
        data.put("api_name", "fraud.screening.advance.api");
        data.put("flow_id", flowId);
        data.put("user_name", Constants.qizha_user_name);
        data.put("sign", Constants.qizha_sign);
        return new Result(ResultConstant.SUCCESS, data);
    }

    @ApiOperation(value = "获取用户紧急联系人")
    @RequestMapping(value = "getEmergency")
    @ResponseBody
    public Result getEmergency(@RequestBody IdReqVO idReqVO) {
        List<Map> mapList = emergencyContactService.selectAllByMethod("getEmergencyByUserUid", idReqVO);

//        UserEmergencyContactExample example = new UserEmergencyContactExample();
//        example.createCriteria().andUserUidEqualTo(idReqVO.getId()).andContactNameIsNotNull().andContactNameNotEqualTo("").andContactMobileIsNotNull().andContactMobileNotEqualTo("");
//        List<UserEmergencyContact> userEmergencyContacts = emergencyContactService.selectByExample(example);
//        List<EmergencyReqVo> ret = new ArrayList<>();
//        for (UserEmergencyContact userEmergencyContact : userEmergencyContacts) {
//            EmergencyReqVo emergencyReqVo = new EmergencyReqVo();
//            BeanUtils.copyProperties(userEmergencyContact, emergencyReqVo);
//            ret.add(emergencyReqVo);
//        }
//        if (ret.size() > 0) {
//            return new Result(ResultConstant.SUCCESS, ret);
//        }
        return new Result(ResultConstant.SUCCESS, mapList);
    }

    @ApiOperation(value = "获取借条账号")
    @RequestMapping(value = "getuserOtherAcount")
    @ResponseBody
    public Result getuserOtherAcount(@RequestBody IdReqVO idReqVO) {
//        UserOtherAcountExample example = new UserOtherAcountExample();
//        example.createCriteria().andUserUidEqualTo(idReqVO.getId()).andAcountIsNotNull().andAcountPasswordIsNotNull().andAcountNotEqualTo("").andAcountPasswordNotEqualTo("");
//        List<UserOtherAcount> userOtherAcounts = userOtherAcountService.selectByExample(example);
        List<Map> mapList = userOtherAcountService.selectAllByMethod("selectUserOtherAcountsByUserUid", idReqVO);

//        List<UserOtherAcountReqVo> ret = new ArrayList<>();
//        for (UserOtherAcount userOtherAcount : userOtherAcounts) {
//            UserOtherAcountReqVo userOtherAcountReqVo = new UserOtherAcountReqVo();
//            BeanUtils.copyProperties(userOtherAcount, userOtherAcountReqVo);
//            ret.add(userOtherAcountReqVo);
//        }
//        if (ret.size() > 0) {
//            return new Result(ResultConstant.SUCCESS, ret);
//        }
        return new Result(ResultConstant.SUCCESS, mapList);
    }

    @ApiOperation(value = "获取最近定位")
    @RequestMapping(value = "getRecentLocation")
    @ResponseBody
    public Result getRecentLocation(@RequestBody IdReqVO idReqVO) {
        GaodeLocationExample example = new GaodeLocationExample();
        example.createCriteria().andUserUidEqualTo(idReqVO.getId());
        example.setOrderByClause("create_time desc");
        GaodeLocation gaodeLocation = gaodeLocationService.selectFirstByExample(example);
        return new Result(ResultConstant.SUCCESS, gaodeLocation);
    }

    @Resource(name = "gzTypeMap")
    private Map<String, String> gzTypeMap;//规则类型

    @Resource(name = "deviceFengXianMap")
    private Map<String, Map<String, String>> deviceFengXianMap;//设备风险提示

    @ApiOperation(value = "获取设备指纹")
    @RequestMapping(value = "getDevicePrintData")
    @ResponseBody
    public Result getDevicePrintData(@RequestBody IdReqVO idReqVO) {
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(idReqVO.getId()).andIdentityTypeEqualTo((byte) 5);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        String thirdData = userOtherAuth != null ? userOtherAuth.getThirdData() : null;
        if (userOtherAuth != null && !StringUtils.isEmpty(thirdData)) {//存在
            JSONObject jsonObject = JSON.parseObject(thirdData);
            JSONObject data = jsonObject.getJSONObject("data");
            JSONObject deviceInfo = data.getJSONObject("deviceInfo");
            JSONArray deviceRule = deviceInfo.getJSONArray("deviceRule");
            JSONArray deviceRisk = deviceInfo.getJSONArray("deviceRisk");
            if (deviceRule != null) {
                for (Object o : deviceRule) {
                    JSONObject temp = (JSONObject) o;
                    String ruleCode = temp.getString("ruleCode");
                    String ruleTypeCode = temp.getString("ruleTypeCode");
                    AfuGuizeExample guizeExample = new AfuGuizeExample();
                    guizeExample.createCriteria().andGzCodeEqualTo(ruleCode);
                    AfuGuize afuGuize = afuGuizeService.selectFirstByExample(guizeExample);
                    temp.put("gzName", afuGuize != null ? afuGuize.getGzName() : "");
                    String ruleTypeCodeStr = gzTypeMap.get(ruleTypeCode);
                    temp.put("gzTypeName", ruleTypeCodeStr != null ? ruleTypeCodeStr : "");
                }
            }
            if (deviceRisk != null) {
                for (Object o : deviceRisk) {
                    JSONObject temp = (JSONObject) o;
                    String riskCode = temp.getString("riskCode");
                    String riskDescription = deviceFengXianMap.get(riskCode).get("Description");
                    temp.put("riskDescription", riskDescription);
                }
            }
            Map map = JSON.parseObject(data.toString(), Map.class);
            return new Result(ResultConstant.SUCCESS, map);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "获取登录定位")
    @RequestMapping(value = "getLoginLocations")
    @ResponseBody
    public ListResult getLoginLocations(@RequestBody ListReqVO<IdReqVO> listReqVO) {
        GaodeLocationExample example = new GaodeLocationExample();
        example.createCriteria().andUserUidEqualTo(listReqVO.getCondition().getId());
        example.setOrderByClause("create_time desc");
        PageInfo<GaodeLocation> gaodeLocationPageInfo = gaodeLocationService.selectByExampleForStartPage(example, listReqVO.getPageNum(), listReqVO.getPageSize());
        return new ListResult(ResultConstant.SUCCESS, gaodeLocationPageInfo);
    }

    //    白骑士接口
    public static final String VERIFYKEY = "0d4aea86b58e4eb781f78966f281ecaa";
    public static final String PARTNERID = "lfme";

    @ApiOperation(value = "获取报告Token 每个用户拥有不同的token")
    @RequestMapping(value = "getToken")
    @ResponseBody
    public Result getToken(HttpServletRequest request, @RequestBody IdReqVO idReqVO) {
        UserBase userBase = userBaseService.selectByPrimaryKey(idReqVO.getId());
        if (userBase == null) {
            return new Result(ResultConstant.EXCEPTION_NO_ACOUNT);
        }
        if (StringUtils.isEmpty(userBase.getMobile())) {
            return new Result(0, "用户手机号不完善");
        }
        if (StringUtils.isEmpty(userBase.getIdCard())) {
            return new Result(0, "用户身份证号不完善");
        }
        if (StringUtils.isEmpty(userBase.getUserRealName())) {
            return new Result(0, "用户姓名不完善");
        }

        long timeStamp = new Date().getTime();//为当前时间戳

        Map<String, String> lastMap = (Map<String, String>) SessionUtil.getSessionAttribute(idReqVO.getId() + "");
        if (lastMap != null) {
            String lastTimeStamp = lastMap.get("timeStamp");
            if ((timeStamp - Long.parseLong(lastTimeStamp)) < 30 * 1000) {//小于30秒
//                lastMap.put("timeStamp", timeStamp + "");
                return new Result(ResultConstant.SUCCESS, lastMap);//直接返回上一次的map
            }
        }

        String url = "https://credit.baiqishi.com/clweb/api/common/gettoken";
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;
        JSONObject jsonReqObject = new JSONObject();
        jsonReqObject.put("certNo", userBase.getIdCard());
        jsonReqObject.put("partnerId", PARTNERID);
        jsonReqObject.put("verifyKey", VERIFYKEY);

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
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(0, "连接IO异常");
        }
        JSONObject result = JSON.parseObject(respContent);
        //获取token
        String token = result.getString("data");
        String resultCode = result.getString("resultCode");
        if ("CCOM1000".equalsIgnoreCase(resultCode)) {
            Map<String, String> map = new HashMap<>();
            map.put("token", token);
            map.put("timeStamp", timeStamp + "");
            map.put("certNo", userBase.getIdCard());
            map.put("partnerId", PARTNERID);
            map.put("name", userBase.getUserRealName());
            map.put("mobile", userBase.getMobile());

            SessionUtil.setSessionAttribute(idReqVO.getId() + "", map);
            return new Result(ResultConstant.SUCCESS, map);
        } else {
            return new Result(0, result.getString("resultDesc"));
        }
    }


}
package com.alankin.gateway.web.controller;

import com.alankin.common.util.DateUtils;
import com.alankin.common.util.RequestUtil;
import com.alankin.common.util.key.SnowflakeIdWorker;
import com.alankin.common.util.key.SystemClock;
import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.utils.UserUtils;
import com.alankin.gateway.web.vo.ListVo.IdReqVO;
import com.alankin.gateway.web.vo.ListVo.ListReqVO;
import com.alankin.gateway.web.vo.request.*;
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
import java.util.*;

/**
 * 注册控制器
 * Created by alankin.
 */
@Controller
@Api(value = "用户接口", description = "用户接口")
@RequestMapping(value = "api/user", method = RequestMethod.POST)
@Transactional
public class UserController extends BaseWebController {
    //运营商认证常量
    public static String userid = "gmtxsm01";
    public static String apiKey = "110978967496774c";
    public static String operateApi = "https://www.afufintech.com/ZSS/api/yixin_yys/V1";

    //淘宝认证常量
    public static String taobaoApi = "https://www.afufintech.com/ZSS/api/yixin_taobao/V1";
    //多头认证常量

    //欺诈认证常量

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    private SysUserBaseService sysUserBaseService;

    @Autowired
    private StorageImageService storageImageService;

    @Autowired
    private UserOtherAuthService userOtherAuthService;

    @Autowired
    private UserEmergencyContactService emergencyContactService;
    @Autowired
    private UserContactsService contactsService;

    @Autowired
    private UserOtherAcountService userOtherAcountService;

    @Autowired
    private UserLocationService userLocationService;

    @Autowired
    private ApplyOrderService applyOrderService;

    @Autowired
    private LoanReceiptService loanReceiptService;

    @Autowired
    private ApplyStateLogService applyStateLogService;

    @Autowired
    private GaodeLocationService gaodeLocationService;

    //用户认证
    @ApiOperation(value = "用户认证")
    @RequestMapping(value = "auth")
    @ResponseBody
    public Object auth(HttpServletRequest request, HttpServletResponse response, @RequestBody UserAuthReqVo vo) {
        UserBase userBase = UserUtils.getUser(request);
        BeanUtils.copyProperties(vo, userBase);
        userBaseService.updateByPrimaryKeySelective(userBase);
        return new UcenterResult(UcenterResultConstant.SUCCESS, userBase);
    }

    @ApiOperation(value = "是否通过审核")
    @RequestMapping(value = "isPassVerify")
    @ResponseBody
    public Result isPassVerify(HttpServletRequest request) {
        UserBase userBase = UserUtils.getUser(request);
        if (userBase.getDistributStateKey() != 1) {//不等于1为未分配审核人
            return new Result(ResultConstant.NO_DISTRIBUTE_VERIFY);
        }
        if (userBase.getVerifyStateKey() == 2) {//为已通过审核
            return new Result(ResultConstant.SUCCESS);
        }
        SysUserBase sysUserBase = sysUserBaseService.selectByPrimaryKey(userBase.getVerifyUid());
        if (sysUserBase == null) {//没有找到该审核人
            return new Result(ResultConstant.VERIFY_EXCEPTION);
        }
        Long wchatQrcode = sysUserBase.getWchatQrcode();
        if (wchatQrcode == null) {
            return new Result(ResultConstant.VERIFY_EXCEPTION);
        }
        StorageImage storageImage = storageImageService.selectByPrimaryKey(wchatQrcode);
        Map map = new HashMap();
        map.put("wchatQrcodePath", storageImage.getFullPath());
        return new Result(ResultConstant.VERIFY_NOT_PASS, map);
    }

    /*用户基本认证>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "用户基本认证")
    @RequestMapping(value = "identityVerify")
    @ResponseBody
    public Result identityVerify(HttpServletRequest request, @RequestBody UserAuthReqVo vo) {
        UserBase user = UserUtils.getUser(request);
        UserLocationExample example = new UserLocationExample();
        example.createCriteria().andUidEqualTo(user.getCompanyLocationUid());
        UserLocation userLocation = userLocationService.selectFirstByExample(example);
        if (userLocation == null) {
            UserLocation record = new UserLocation();
            record.setUid(new SnowflakeIdWorker(0, 0).nextId());
            record.setCurrNation("中国");
            record.setCurrProvince(vo.getCompanyProvance());
            record.setCurrCity(vo.getCompanyCity());
            record.setCurrDistrict(vo.getCompanyArea());
            record.setLocation(vo.getCompanyLocationDetail());
            if (userLocationService.insertSelective(record) > 0) {
                user.setCompanyLocationUid(record.getUid());
            }
        } else {
            userLocation.setCurrNation("中国");
            userLocation.setCurrProvince(vo.getCompanyProvance());
            userLocation.setCurrCity(vo.getCompanyCity());
            userLocation.setCurrDistrict(vo.getCompanyArea());
            userLocation.setLocation(vo.getCompanyLocationDetail());
            if (userLocationService.updateByPrimaryKeySelective(userLocation) > 0) {
                user.setCompanyLocationUid(userLocation.getUid());
            }
        }
        BeanUtils.copyProperties(vo, user);
        if (userBaseService.updateByPrimaryKeySelective(user) > 0) {
            UserUtils.createUserSession(request, user);//更新session
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "获取用户基本信息")
    @RequestMapping(value = "getUser")
    @ResponseBody
    public Result getUser(HttpServletRequest request) {
        UserBase userbase = UserUtils.getUser(request);
        return new Result(ResultConstant.SUCCESS, getUserResult(userbase));
    }

    private UserAuthReqVo getUserResult(UserBase userBase) {
        UserAuthReqVo userAuthReqVo = new UserAuthReqVo();
        BeanUtils.copyProperties(userBase, userAuthReqVo);
        UserLocationExample example = new UserLocationExample();
        example.createCriteria().andUidEqualTo(userBase.getCompanyLocationUid());
        UserLocation userLocation = userLocationService.selectFirstByExample(example);
        userAuthReqVo.setCompanyProvance(userLocation.getCurrProvince());
        userAuthReqVo.setCompanyCity(userLocation.getCurrCity());
        userAuthReqVo.setCompanyArea(userLocation.getCurrDistrict());
        userAuthReqVo.setCompanyLocationDetail(userLocation.getLocation());
        return userAuthReqVo;
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<用户基本认证*/

    /*用户紧急联系人认证>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "用户紧急联系人认证")
    @RequestMapping(value = "emergencyVerify")
    @ResponseBody
    public Result emergencyVerify(HttpServletRequest request, @RequestBody List<EmergencyReqVo> reqVos) {
        UserBase user = UserUtils.getUser(request);
        for (EmergencyReqVo reqVo : reqVos) {
            UserEmergencyContactExample example = new UserEmergencyContactExample();
            example.createCriteria().andAcountTypeKeyEqualTo(reqVo.getAcountTypeKey());
            UserEmergencyContact userEmergencyContact = emergencyContactService.selectFirstByExample(example);
            if (userEmergencyContact == null) {//不存在新增
                UserEmergencyContact record = new UserEmergencyContact();
                BeanUtils.copyProperties(reqVo, record);
                record.setUserUid(user.getUid());
                emergencyContactService.insertSelective(record);
            } else {//存在即修改
                BeanUtils.copyProperties(reqVo, userEmergencyContact);
                emergencyContactService.updateByPrimaryKeySelective(userEmergencyContact);
            }
        }
        return new Result(ResultConstant.SUCCESS);
    }

    @ApiOperation(value = "获取用户紧急联系人认证")
    @RequestMapping(value = "getEmergency")
    @ResponseBody
    public Result getEmergency(HttpServletRequest request) {
        UserBase user = UserUtils.getUser(request);
        UserEmergencyContactExample example = new UserEmergencyContactExample();
        example.createCriteria().andUserUidEqualTo(user.getUid());
        List<UserEmergencyContact> userEmergencyContacts = emergencyContactService.selectByExample(example);
        List<EmergencyReqVo> ret = new ArrayList<>();
        for (UserEmergencyContact userEmergencyContact : userEmergencyContacts) {
            EmergencyReqVo emergencyReqVo = new EmergencyReqVo();
            BeanUtils.copyProperties(userEmergencyContact, emergencyReqVo);
            ret.add(emergencyReqVo);
        }
        if (ret.size() > 0) {
            return new Result(ResultConstant.SUCCESS, ret);
        }
        return new Result(ResultConstant.FAILED);
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<用户紧急联系人*/

    /*用户联系人认证>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "用户通讯录认证")
    @RequestMapping(value = "contactsVerify")
    @ResponseBody
    public Result contactsVerify(HttpServletRequest request, @RequestBody List<Map<String, String>> contactList) {
        UserBase user = UserUtils.getUser(request);
        Long userUid = user.getUid();
        if (contactList == null || contactList.size() < 1) {
            return new Result(ResultConstant.FAILED);
        }
        UserContactsExample example = new UserContactsExample();
        for (Map<String, String> contactMap : contactList) {
            String contactName = contactMap.get("contactName");
            String contactMobile = contactMap.get("contactMobile").trim().replace(" ", "");
            //清理查询条件
            example.clear();
            example.createCriteria()
                    .andUserUidEqualTo(userUid)
                    .andContactNameEqualTo(contactName)
                    .andContactMobileEqualTo(contactMobile);
            UserContacts userContacts = contactsService.selectFirstByExample(example);
            if (userContacts == null) {
                UserContacts record = new UserContacts();
                record.setUserUid(userUid);
                record.setContactName(contactName);
                record.setContactMobile(contactMobile);
                contactsService.insert(record);
            }
        }
        return new Result(ResultConstant.SUCCESS);
    }

    @ApiOperation(value = "获取通讯录")
    @RequestMapping(value = "getContacts")
    @ResponseBody
    public Result getContacts(HttpServletRequest request, ListReqVO listReqVO) {
        UserBase user = UserUtils.getUser(request);
        UserContactsExample example = new UserContactsExample();
        example.createCriteria().andUserUidEqualTo(user.getUid());
        PageInfo<UserContacts> pageInfo = contactsService.selectByExampleForStartPage(example, listReqVO.getPageNum(), listReqVO.getPageSize());
        return new Result(ResultConstant.SUCCESS, pageInfo);
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<用户通讯录*/

    /*定位>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "上传用户定位")
    @RequestMapping(value = "uploadGaoDeLocation")
    @ResponseBody
    @Transactional
    public Result uploadGaoDeLocation(HttpServletRequest request, @RequestBody GaodeLocation location) {
        UserBase user = UserUtils.getUser(request);
        location.setUserUid(user.getUid());
        if (gaodeLocationService.insertSelective(location) > 0) {
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "获取用户定位")
    @RequestMapping(value = "getGaoDeLocation")
    @ResponseBody
    public Result getGaoDeLocation(HttpServletRequest request, @RequestBody ListReqVO listReqVO) {
        UserBase user = UserUtils.getUser(request);
        GaodeLocationExample example = new GaodeLocationExample();
        example.createCriteria().andUidEqualTo(user.getUid());
        PageInfo<GaodeLocation> pageInfo = gaodeLocationService.selectByExampleForStartPage(example, listReqVO.getPageNum(), listReqVO.getPageSize());
        if (pageInfo != null) {
            return new Result(ResultConstant.SUCCESS, pageInfo);
        }
        return new Result(ResultConstant.FAILED);
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<定位*/

    /*借条账号认证>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "借条账号认证")
    @RequestMapping(value = "userOtherAcountVerify")
    @ResponseBody
    public Result userOtherAcountVerify(HttpServletRequest request, @RequestBody List<UserOtherAcountReqVo> reqVos) {
        UserBase user = UserUtils.getUser(request);
        for (UserOtherAcountReqVo reqVo : reqVos) {
            UserOtherAcountExample example = new UserOtherAcountExample();
            example.createCriteria().andAcountTypeKeyEqualTo(reqVo.getAcountTypeKey());
            UserOtherAcount userOtherAcount = userOtherAcountService.selectFirstByExample(example);
            if (userOtherAcount == null) {//不存在新增
                UserOtherAcount record = new UserOtherAcount();
                BeanUtils.copyProperties(reqVo, record);
                record.setUserUid(user.getUid());
                userOtherAcountService.insertSelective(record);
            } else {//存在即修改
                BeanUtils.copyProperties(reqVo, userOtherAcount);
                userOtherAcountService.updateByPrimaryKeySelective(userOtherAcount);
            }
        }
        return new Result(ResultConstant.SUCCESS);
    }

    @ApiOperation(value = "获取借条账号")
    @RequestMapping(value = "getuserOtherAcount")
    @ResponseBody
    public Result getuserOtherAcount(HttpServletRequest request) {
        UserBase user = UserUtils.getUser(request);
        UserOtherAcountExample example = new UserOtherAcountExample();
        example.createCriteria().andUserUidEqualTo(user.getUid());
        List<UserOtherAcount> userOtherAcounts = userOtherAcountService.selectByExample(example);
        List<UserOtherAcountReqVo> ret = new ArrayList<>();
        for (UserOtherAcount userOtherAcount : userOtherAcounts) {
            UserOtherAcountReqVo userOtherAcountReqVo = new UserOtherAcountReqVo();
            BeanUtils.copyProperties(userOtherAcount, userOtherAcountReqVo);
            ret.add(userOtherAcountReqVo);
        }
        if (ret.size() > 0) {
            return new Result(ResultConstant.SUCCESS, ret);
        }
        return new Result(ResultConstant.FAILED);
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<借条*/

    /*运营商接口>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "获取运营商账号")
    @RequestMapping(value = "getOperate")
    @ResponseBody
    public Result getOperate(HttpServletRequest request) {
        UserBase user = UserUtils.getUser(request);
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 2);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExample(example);
        if (userOtherAuth != null) {
            Map map = new HashMap();
            map.put("username", userOtherAuth.getIdentifier());
            map.put("password", userOtherAuth.getCertificate());
            return new Result(ResultConstant.SUCCESS, map);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "检验运营商认证")
    @RequestMapping(value = "operateVerify")
    @ResponseBody
    public Result operateVerify(HttpServletRequest request) {
        UserBase user = UserUtils.getUser(request);
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 2);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExample(example);
        if (userOtherAuth != null && !StringUtils.isEmpty(userOtherAuth.getThirdData())) {
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "运营商登录")
    @RequestMapping(value = "operateLogin")
    @ResponseBody
    public Object operateLogin(HttpServletRequest request, @RequestBody OperateLoginReqVo vo) {
        UserBase user = UserUtils.getUser(request);
        if (user == null) {
            return new Result(ResultConstant.EXCEPTION_INVALID);
        }
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("userid", userid);
        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
        multiValueMap.add("op", "collect");
        multiValueMap.add("username", vo.getUsername());
        multiValueMap.add("password", vo.getPassword());
        multiValueMap.add("name", vo.getName());
        multiValueMap.add("idNumber", vo.getIdNumber());
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.postForObject(operateApi, multiValueMap, String.class);
        JSONObject jsonObject = JSON.parseObject(s);
        String errorcode = jsonObject.getString("errorcode");
        if (errorcode.equals("0000")) {
            UserOtherAuthExample example = new UserOtherAuthExample();
            example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 2);
            UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExample(example);
            if (userOtherAuth != null) {//存在
                String certificate = userOtherAuth.getCertificate();
                if (!StringUtils.isEmpty(certificate) && !certificate.equals(vo.getPassword())) {
                    //并且密码有改变
                    userOtherAuth.setCertificate(vo.getPassword());
                    userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth);
                }
            } else {//不存在
                UserOtherAuth record = new UserOtherAuth();
                record.setUid(user.getUid());
                record.setCertificate(vo.getPassword());
                record.setIdentifier(vo.getUsername());
                record.setIdentityType((byte) 2);
                userOtherAuthService.insert(record);
            }
        }
        return s;
    }

    @ApiOperation(value = "运营商验证码接口")
    @RequestMapping(value = "operateCode")
    @ResponseBody
    public Object operateCode(@RequestBody CheckCodeReqVo vo) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("userid", userid);
        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
        multiValueMap.add("op", "code");
        multiValueMap.add("checkcode", vo.getCheckcode());
        multiValueMap.add("sid", vo.getSid());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(operateApi, multiValueMap, String.class);
    }

    @ApiOperation(value = "运营商验证码刷新接口")
    @RequestMapping(value = "operateRefrshCode")
    @ResponseBody
    public Object operateRefrshCode(@RequestBody BaseSidReqVo vo) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("userid", userid);
        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
        multiValueMap.add("op", "code");
        multiValueMap.add("sid", vo.getSid());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(operateApi, multiValueMap, String.class);
    }

    @ApiOperation(value = "运营商获取数据接口")
    @RequestMapping(value = "operateGetData")
    @ResponseBody
    public Object operateGetData(HttpServletRequest request, @RequestBody GetDataReqVo vo) {
        UserBase user = UserUtils.getUser(request);

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("userid", userid);
        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
        multiValueMap.add("op", "get");
        multiValueMap.add("username", vo.getUsername());
        multiValueMap.add("sid", vo.getSid());
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.postForObject(operateApi, multiValueMap, String.class);
        JSONObject jsonObject = JSON.parseObject(s);
        String errorcode = jsonObject.getString("errorcode");
        if (errorcode.equals("0000")) {
            String data = jsonObject.getString("data");
            UserOtherAuthExample example = new UserOtherAuthExample();
            example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 2);
            UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExample(example);
            //添加数据
            userOtherAuth.setThirdData(data);
            userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth);
        }
        return s;
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<运营商接口*/

    /*淘宝接口>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "获取淘宝账号")
    @RequestMapping(value = "getTaobao")
    @ResponseBody
    public Result getTaobao(HttpServletRequest request) {
        UserBase user = UserUtils.getUser(request);
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 1);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExample(example);
        if (userOtherAuth != null) {
            Map map = new HashMap();
            map.put("username", userOtherAuth.getIdentifier());
            map.put("password", userOtherAuth.getCertificate());
            return new Result(ResultConstant.SUCCESS, userOtherAuth);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "检验淘宝认证")
    @RequestMapping(value = "taobaoVerify")
    @ResponseBody
    public Result taobaoVerify(HttpServletRequest request) {
        UserBase user = UserUtils.getUser(request);
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 1);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExample(example);
        if (userOtherAuth != null && !StringUtils.isEmpty(userOtherAuth.getThirdData())) {
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "淘宝登录")
    @RequestMapping(value = "taobaoLogin")
    @ResponseBody
    public Object taobaoLogin(HttpServletRequest request, @RequestBody ThirdLoginReqVo vo) {
        UserBase user = UserUtils.getUser(request);
        if (user == null) {
            return new Result(ResultConstant.EXCEPTION_INVALID);
        }
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("userid", userid);
        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
        multiValueMap.add("op", "collect");
        multiValueMap.add("username", vo.getUsername());
        multiValueMap.add("password", vo.getPassword());
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.postForObject(taobaoApi, multiValueMap, String.class);
        JSONObject jsonObject = JSON.parseObject(s);
        String errorcode = jsonObject.getString("errorcode");
        if (errorcode.equals("0000")) {
            UserOtherAuthExample example = new UserOtherAuthExample();
            example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 1);
            UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExample(example);
            if (userOtherAuth != null) {//存在
                String certificate = userOtherAuth.getCertificate();
                if (!StringUtils.isEmpty(certificate) && !certificate.equals(vo.getPassword())) {
                    //并且密码有改变
                    userOtherAuth.setCertificate(vo.getPassword());
                    userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth);
                }
            } else {//不存在
                UserOtherAuth record = new UserOtherAuth();
                record.setUid(user.getUid());
                record.setCertificate(vo.getPassword());
                record.setIdentifier(vo.getUsername());
                record.setIdentityType((byte) 1);
                userOtherAuthService.insert(record);
            }
        }
        return s;
    }

    @ApiOperation(value = "淘宝验证码接口")
    @RequestMapping(value = "taobaoCode")
    @ResponseBody
    public Object taobaoCode(@RequestBody CheckCodeReqVo vo) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("userid", userid);
        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
        multiValueMap.add("op", "code");
        multiValueMap.add("checkcode", vo.getCheckcode());
        multiValueMap.add("sid", vo.getSid());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(taobaoApi, multiValueMap, String.class);
    }

    @ApiOperation(value = "淘宝验证码刷新接口")
    @RequestMapping(value = "taobaoRefrshCode")
    @ResponseBody
    public Object taobaoRefrshCode(@RequestBody BaseSidReqVo vo) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("userid", userid);
        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
        multiValueMap.add("op", "code");
        multiValueMap.add("sid", vo.getSid());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(taobaoApi, multiValueMap, String.class);
    }

    @ApiOperation(value = "淘宝获取数据接口")
    @RequestMapping(value = "taobaoCheckStatus")
    @ResponseBody
    public Object taobaoCheckStatus(@RequestBody BaseSidReqVo vo) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("userid", userid);
        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
        multiValueMap.add("op", "checkstatus");
        multiValueMap.add("sid", vo.getSid());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(taobaoApi, multiValueMap, String.class);
    }

    @ApiOperation(value = "淘宝获取数据接口")
    @RequestMapping(value = "taobaoGetData")
    @ResponseBody
    public Object taobaoGetData(HttpServletRequest request, @RequestBody GetDataReqVo vo) {
        UserBase user = UserUtils.getUser(request);
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("userid", userid);
        multiValueMap.add("sign", DigestUtils.md5Hex(userid + apiKey));
        multiValueMap.add("op", "get");
        multiValueMap.add("username", vo.getUsername());
        multiValueMap.add("sid", vo.getSid());
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.postForObject(taobaoApi, multiValueMap, String.class);
        JSONObject jsonObject = JSON.parseObject(s);
        String errorcode = jsonObject.getString("errorcode");
        if (errorcode.equals("0000")) {
            String data = jsonObject.getString("data");
            UserOtherAuthExample example = new UserOtherAuthExample();
            example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 1);
            UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExample(example);
            //添加数据
            userOtherAuth.setThirdData(data);
            userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth);
        }
        return s;
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<淘宝接口*/

    /*多头接口>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //请求致诚阿福群星接口地址
    private static String api_name = "credit.evaluation.share.api";
    private static String url = "https://starapi.zhichengcredit.com/submit";
    private static String user_name = "shensudai_testusr";//用户名
    private static String sign = "ec6aef1d861d493e";//rc4秘钥

    @ApiOperation(value = "多头接口")
    @RequestMapping(value = "mutiData")
    @ResponseBody
    public Object mutiData(HttpServletRequest request, @RequestBody MutiReqVo vo) {
        UserBase user = UserUtils.getUser(request);
        if (user == null) {
            return new Result(ResultConstant.EXCEPTION_INVALID);
        }
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 3);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExample(example);
        if (userOtherAuth != null && !StringUtils.isEmpty(userOtherAuth.getThirdData())) {//存在
            return new Result(ResultConstant.SUCCESS);
        }

        /*查询条件拼接 开始*/
        JSONObject dataJson = new JSONObject();
        dataJson.put("id_no", vo.getIdNo());//被查询人身份证号 18 位以内
        dataJson.put("name", vo.getName());//被查询人姓名 2-30 位
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
        nameValuePairs.add(new BasicNameValuePair("query_reason", ReasonEnum.LOAN_AUDIT.getType()));
        //查询条件,格式为 json 格式
        nameValuePairs.add(new BasicNameValuePair("params", dataJson.toJSONString()));
        String s = HttpClientUtil.doPost(url, nameValuePairs, "utf-8");
        JSONObject jsonObject = JSON.parseObject(s);
        String code = jsonObject.getString("code");
        if (code.equals("10000")) {
            if (userOtherAuth != null && !StringUtils.isEmpty(userOtherAuth.getThirdData())) {//存在,但是没有三方数据
                userOtherAuth.setThirdData(jsonObject.getString("data"));
                userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth);
                return new Result(ResultConstant.SUCCESS);
            } else {//不存在
                UserOtherAuth record = new UserOtherAuth();
                record.setUid(user.getUid());
                record.setCertificate(vo.getIdNo());
                record.setIdentifier(vo.getName());
                record.setIdentityType((byte) 3);
                record.setThirdData(jsonObject.getString("data"));
                userOtherAuthService.insert(record);
                return new Result(ResultConstant.SUCCESS);
            }
        }else {
            return new Result(Integer.parseInt(code), jsonObject.getString("msg"));
        }
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<多头接口*/

    /*欺诈甄别接口>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "欺诈甄别接口")
    @RequestMapping(value = "qizhaData")
    @ResponseBody
    public Object qizhaData(HttpServletRequest request, @RequestBody Map<String, String> vo) {
        UserBase user = UserUtils.getUser(request);
        if (user == null) {
            return new Result(ResultConstant.EXCEPTION_INVALID);
        }
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 4);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExample(example);
        if (userOtherAuth != null && !StringUtils.isEmpty(userOtherAuth.getThirdData())) {//存在
            return new Result(ResultConstant.SUCCESS);
        }

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
        nameValuePairs.add(new BasicNameValuePair("params", gennerateRequetParam(request, vo).toJSONString()));
        String s = HttpClientUtil.doPost(url, nameValuePairs, "utf-8");
        JSONObject jsonObject = JSON.parseObject(s);
        String code = jsonObject.getString("code");
        if (code.equals("10000")) {
            if (userOtherAuth != null && !StringUtils.isEmpty(userOtherAuth.getThirdData())) {//存在,但是没有三方数据
                userOtherAuth.setThirdData(jsonObject.getString("data"));
                userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth);
                return new Result(ResultConstant.SUCCESS);
            } else {//不存在
                UserOtherAuth record = new UserOtherAuth();
                record.setUid(user.getUid());
                record.setCertificate(user.getIdCard());
                record.setIdentifier(user.getUserRealName());
                record.setIdentityType((byte) 4);
                record.setThirdData(jsonObject.getString("data"));
                userOtherAuthService.insert(record);
                return new Result(ResultConstant.SUCCESS);
            }
        } else {
            return new Result(Integer.parseInt(code), jsonObject.getString("msg"));
        }
    }

    public JSONObject gennerateRequetParam(HttpServletRequest request, Map<String, String> vo) {
        UserBase user = UserUtils.getUser(request);
        UserLocation userLocation = userLocationService.selectByPrimaryKey(user.getCompanyLocationUid());
        JSONObject dataJson = new JSONObject();
        dataJson.put("queryFraudScreening", "true");
        dataJson.put("queryDevicePrint", "true");
        dataJson.put("amount_business", "0");
        JSONArray addrArray = new JSONArray();
        addrArray.add("SELF_MOBILE_1_FAMILY_ADDR");
        addrArray.add("SELF_MOBILE_1_CORP_ADDR");
        dataJson.put("addr_detection_types", addrArray);
        dataJson.put("id_no", user.getIdCard());//被查询人身份证号 18 位以内
        dataJson.put("name", user.getUserRealName());//被查询人姓名 2-30 位
        dataJson.put("mobile", user.getMobile());
        dataJson.put("bank_no", "");
        JSONObject corp_addr_json = new JSONObject();
        corp_addr_json.put("address", userLocation.getLocation());
        corp_addr_json.put("city", userLocation.getCurrCity());
        corp_addr_json.put("county", userLocation.getCurrDistrict());
        corp_addr_json.put("province", userLocation.getCurrProvince());
        corp_addr_json.put("postal", "");
        dataJson.put("corp_addr", corp_addr_json);
        dataJson.put("corp_name", user.getCompanyName());
        dataJson.put("corp_tel", user.getCompanyPhone());
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

        dataJson.put("email", user.getEmail());
        JSONObject family_addrjson = new JSONObject();
//        family_addrjson.put("address", "温特莱B座1910");
//        family_addrjson.put("city", "北京市");
//        family_addrjson.put("county", "朝阳区");
//        family_addrjson.put("province", "北京市");
        dataJson.put("family_addr", family_addrjson);
        //设备指纹事件信息
        JSONObject eventObj = new JSONObject();
        eventObj.put("time", DateUtils.date2String(new Date(), "YYYY-MM-DDHH:mm:ss.SSS"));
//        eventObj.put("source", "WEB");
        JSONObject deviceObj = new JSONObject();
        deviceObj.put("ip", RequestUtil.getIpAddr(request));
        JSONObject header = new JSONObject();
        header.put("content-length", request.getContentLength());
        deviceObj.put("headers", header);
        // deviceObj.put("userIdentityCookies",{});
        deviceObj.put("jsc", vo.get("jsc"));
        eventObj.put("device", deviceObj);
//        JSONObject sessionObj = new JSONObject();
//        sessionObj.put("id", "sadhausdas929123");
//        sessionObj.put("durationInMillis", "2178000");
//        sessionObj.put("activityPageCode", "login001");
//        eventObj.put("session", sessionObj);
        dataJson.put("event", eventObj);
        return dataJson;
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<欺诈甄别接口*/


    /*申请>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    @ApiOperation(value = "用户创建申请单")
    @RequestMapping(value = "createApplyOrder")
    @ResponseBody
    public Result createApplyOrder(HttpServletRequest request, @RequestBody CreateApplyOrderReqVo vo) {
        UserBase user = UserUtils.getUser(request);
        if (user.getVerifyStateKey() != 2) {
            return new Result(ResultConstant.VERIFY_NOT_PASS);
        }
        if (user.getBrowerUid() == null) {
            return new Result(ResultConstant.NO_DISTRIBUTE_BROWER);
        }
        ApplyOrder record = new ApplyOrder();
        record.setApplyUserUid(user.getUid());
        record.setState(1);//未签订状态
        record.setLoanDuration(vo.getDuration());
        record.setOrderMoney(Math.toIntExact(vo.getApplyMoney()));
        record.setVerifyUserId(user.getVerifyUid());
        if (applyOrderService.insertSelective(record) > 0) {
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "用户查找自己的申请单")
    @RequestMapping(value = "/myOrders")
    @ResponseBody
    @Transactional
    public ListResult myOrders(HttpServletRequest request, @RequestBody ListReqVO<IdReqVO> listReqVO) {
        //从session获取用户信息
        UserBase user = UserUtils.getUser(request);
        ApplyOrderExample example = new ApplyOrderExample();
        example.createCriteria().andApplyUserUidEqualTo(user.getUid());
        IdReqVO condition = new IdReqVO();
        condition.setId(user.getUid());
        listReqVO.setCondition(condition);
        PageInfo pageInfo = applyOrderService.selectForStartPageByMethod("myOrders", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        if (pageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED);
    }

    @ApiOperation(value = "用户签订合同")
    @RequestMapping(value = "signOrder")
    @ResponseBody
    public Result signOrder(HttpServletRequest request, @RequestBody IdReqVO vo) {
//        UserBase user = UserUtils.getUser(request);
        Long orderUid = vo.getId();
        if (orderUid == null) {
            return new Result(ResultConstant.FAILED);
        }
        LoanReceiptExample loanExample = new LoanReceiptExample();
        loanExample.createCriteria().andApplyOrderUidEqualTo(orderUid);
        LoanReceipt loanReceipt = loanReceiptService.selectFirstByExample(loanExample);
        if (loanReceipt == null) {
            return new Result(ResultConstant.FAILED);
        }
        ApplyOrder applyOrder = applyOrderService.selectByPrimaryKey(orderUid);
        if (applyOrder == null) {
            return new Result(ResultConstant.FAILED);
        }

        ApplyStateLogExample example = new ApplyStateLogExample();
        example.createCriteria().andOrderIdEqualTo(orderUid).andNowStateEqualTo(3);
        ApplyStateLog applyStateLog = applyStateLogService.selectFirstByExample(example);
        if (applyStateLog == null) {//不存在该状态的修改记录，则创建
            ApplyStateLog record = new ApplyStateLog();
            record.setLastState(applyOrder.getState());
            record.setNowState(3);
            record.setOrderId(applyOrder.getUid());
            record.setSysUserId(loanReceipt.getBrowerId());
            applyStateLogService.insertSelective(record);
        } else {//存在,则修改时间
            applyStateLog.setCreateTime((int) (SystemClock.now() / 1000));
            applyStateLogService.updateByPrimaryKey(applyStateLog);
        }
        loanReceipt.setState((byte) 3);
        applyOrder.setState(3);
        if (loanReceiptService.updateByPrimaryKeySelective(loanReceipt) > 0 && applyOrderService.updateByPrimaryKeySelective(applyOrder) > 0) {
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED);
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<申请*/
}
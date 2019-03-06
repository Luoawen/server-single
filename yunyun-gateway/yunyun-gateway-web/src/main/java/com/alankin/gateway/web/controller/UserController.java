package com.alankin.gateway.web.controller;

import com.alankin.common.util.RequestUtil;
import com.alankin.common.util.key.SnowflakeIdWorker;
import com.alankin.common.util.key.SystemClock;
import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.utils.Constants;
import com.alankin.gateway.web.utils.Invoker;
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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
    private UserContactsService userContactsService;

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
        UserBase user = UserUtils.getUser(request);
        UserBase userBase = userBaseService.selectByPrimaryKey(user.getUid());
        UserUtils.createUserSession(request, userBase);
        if (userBase.getDistributStateKey() != 1) {//不等于1为未分配审核人
            return new Result(ResultConstant.NO_DISTRIBUTE_VERIFY);
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
        map.put("wchatId", sysUserBase.getWchatId());
        if (userBase.getVerifyStateKey() == 2) {//为已通过审核
            return new Result(ResultConstant.SUCCESS, map);
        }
        return new Result(ResultConstant.VERIFY_NOT_PASS, map);
    }

    /*用户基本认证>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "用户基本认证")
    @RequestMapping(value = "identityVerify")
    @ResponseBody
    public Result identityVerify(HttpServletRequest request, @Valid @RequestBody UserAuthReqVo vo) {
        UserBase user = UserUtils.getUser(request);

        if (user.getCompanyLocationUid() == null) {//没有公司Uid
            if (!StringUtils.isEmpty(vo.getCompanyProvance()) ||
                    !StringUtils.isEmpty(vo.getCompanyCity()) ||
                    !StringUtils.isEmpty(vo.getCompanyArea()) ||
                    !StringUtils.isEmpty(vo.getCompanyLocationDetail())) {//上传了地址
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
            }
        } else {//存在公司Uid
            UserLocationExample example = new UserLocationExample();
            example.createCriteria().andUidEqualTo(user.getCompanyLocationUid());
            UserLocation userLocation = userLocationService.selectFirstByExample(example);
            if (userLocation == null) {//没找到公司位置
                if (!StringUtils.isEmpty(vo.getCompanyProvance()) ||
                        !StringUtils.isEmpty(vo.getCompanyCity()) ||
                        !StringUtils.isEmpty(vo.getCompanyArea()) ||
                        !StringUtils.isEmpty(vo.getCompanyLocationDetail())) {//且用户上传了位置，则添加
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
                }
            } else {//找到公司位置，则修改
                userLocation.setCurrNation("中国");
                userLocation.setCurrProvince(vo.getCompanyProvance());
                userLocation.setCurrCity(vo.getCompanyCity());
                userLocation.setCurrDistrict(vo.getCompanyArea());
                userLocation.setLocation(vo.getCompanyLocationDetail());
                if (userLocationService.updateByPrimaryKeySelective(userLocation) > 0) {
                    user.setCompanyLocationUid(userLocation.getUid());
                }
            }
        }
        BeanUtils.copyProperties(vo, user);
        if (userBaseService.updateByPrimaryKeySelective(user) > 0) {
            UserUtils.createUserSession(request, user);//更新session
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED);
    }

    /*用户基本认证>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "用户身份照片认证")
    @RequestMapping(value = "identityPhotoVerify")
    @ResponseBody
    public Result identityPhotoVerify(HttpServletRequest request, @Valid @RequestBody Map<String, String> vo) {
        UserBase user = UserUtils.getUser(request);
        String idCardPhoto1 = vo.get("idCardPhoto1");
        String idCardPhoto2 = vo.get("idCardPhoto2");
        String idCardPhoto3 = vo.get("idCardPhoto3");
        user.setIdCardPhoto1(!StringUtils.isEmpty(idCardPhoto1) ? Long.valueOf(idCardPhoto1) : null);
        user.setIdCardPhoto2(!StringUtils.isEmpty(idCardPhoto2) ? Long.valueOf(idCardPhoto2) : null);
        user.setIdCardPhoto3(!StringUtils.isEmpty(idCardPhoto3) ? Long.valueOf(idCardPhoto3) : null);
        if (userBaseService.updateByPrimaryKeySelective(user) > 0) {
            UserUtils.createUserSession(request, user);//更新session
            return new Result(ResultConstant.SUCCESS);
        }
//        if (!StringUtils.isEmpty(idCardPhoto1) || !StringUtils.isEmpty(idCardPhoto2) || !StringUtils.isEmpty(idCardPhoto3)) {
//            user.setIdCardPhoto1(!StringUtils.isEmpty(idCardPhoto1)?Long.valueOf(idCardPhoto1):null);
//            user.setIdCardPhoto2(!StringUtils.isEmpty(idCardPhoto2)?Long.valueOf(idCardPhoto2):null);
//            user.setIdCardPhoto3(!StringUtils.isEmpty(idCardPhoto3)?Long.valueOf(idCardPhoto3):null);
//            if (userBaseService.updateByPrimaryKeySelective(user) > 0) {
//                UserUtils.createUserSession(request, user);//更新session
//                return new Result(ResultConstant.SUCCESS);
//            }
//        } else {
//            return new Result(ResultConstant.EXCEPTION_FIELD_INVALID.getCode(), "没有添加任何照片");
//        }
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
        userAuthReqVo.setUid(String.valueOf(userBase.getUid()));
        if (userBase.getCompanyLocationUid() != null) {
            UserLocationExample example = new UserLocationExample();
            example.createCriteria().andUidEqualTo(userBase.getCompanyLocationUid());
            UserLocation userLocation = userLocationService.selectFirstByExample(example);
            if (userLocation != null) {
                userAuthReqVo.setCompanyProvance(userLocation.getCurrProvince());
                userAuthReqVo.setCompanyCity(userLocation.getCurrCity());
                userAuthReqVo.setCompanyArea(userLocation.getCurrDistrict());
                userAuthReqVo.setCompanyLocationDetail(userLocation.getLocation());
            }
        }
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
            example.createCriteria().andUserUidEqualTo(user.getUid()).andAcountTypeKeyEqualTo(reqVo.getAcountTypeKey());
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
        return new Result(ResultConstant.SUCCESS, ret);
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<用户紧急联系人*/

    /*用户联系人认证>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "用户通讯录认证")
    @RequestMapping(value = "contactsVerify")
    @ResponseBody
    @Transactional
    public Result contactsVerify(HttpServletRequest request, @RequestBody List<Map<String, String>> contactList) {
        UserBase user = UserUtils.getUser(request);
        Long userUid = user.getUid();
        if (contactList == null || contactList.size() < 1) {
            return new Result(ResultConstant.FAILED);
        }
        UserContactsExample example = new UserContactsExample();
        for (Map<String, String> contactMap : contactList) {
            String contactName = contactMap.get("contactName");
            String contactMobile = contactMap.get("contactMobile").trim().replace(" ", "").replace("-", "").replace("+86", "");
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
    public Result getContacts(HttpServletRequest request, @RequestBody ListReqVO<Map<String, String>> listReqVO) {
        UserContactsExample example = new UserContactsExample();
        Map<String, String> condition = listReqVO.getCondition();
        String id = condition.get("id");
        if (StringUtils.isEmpty(id)) {
            return new Result(0, "id不能为空");
        }
        String contactName = condition.get("contactName");
        String contactMobile = condition.get("contactMobile");
        UserContactsExample.Criteria criteria = example.createCriteria().andUserUidEqualTo(Long.valueOf(id));
        if (!StringUtils.isEmpty(contactName)) {
            criteria.andContactNameLike("%" + contactName + "%");
        }
        if (!StringUtils.isEmpty(contactMobile)) {
            criteria.andContactMobileLike("%" + contactMobile + "%");
        }
        PageInfo<UserContacts> pageInfo = contactsService.selectByExampleForStartPage(example, listReqVO.getPageNum(), listReqVO.getPageSize());
        return new ListResult(ResultConstant.SUCCESS, pageInfo);
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
            example.createCriteria().andUserUidEqualTo(user.getUid()).andAcountTypeKeyEqualTo(reqVo.getAcountTypeKey());
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
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
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
        String s = restTemplate.postForObject(operateApi, multiValueMap, String.class);
        return s;
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
        String s = restTemplate.postForObject(operateApi, multiValueMap, String.class);
        return s;
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
//            String data = jsonObject.getString("data");
            UserOtherAuthExample example = new UserOtherAuthExample();
            example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 2);
            UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
            //添加数据
            userOtherAuth.setThirdData(s);
            userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth);
        }
        return s;
    }

    static String userid1 = "shensudai01";
    static String apiKey1 = "57577d636f1e193b";
    static String api1 = "https://www.zhichengcredit.com/echo-center/api/authFetchApi/report";
    static String name1 = "宋豪";
    static String idNumber1 = "510129199202114911";

    @ApiOperation(value = "运营商获取分析报告接口")
    @RequestMapping(value = "operateGetAnlyasisData")
    @ResponseBody
    public Object operateGetAnlyasisData(HttpServletRequest request, @RequestBody IdReqVO vo) {
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(vo.getId()).andIdentityTypeEqualTo((byte) 6);
        UserOtherAuth userOtherAuth1 = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        String thirdData1 = userOtherAuth1 != null ? userOtherAuth1.getThirdData() : null;

        if (userOtherAuth1 != null && !StringUtils.isEmpty(thirdData1)) {//运营商分析报告不为空，直接返回
            return matchContactInOperateReportData(vo.getId(), thirdData1);
        } else {//没有运营商分析报告,通过运营商基础数据去请求
            example.clear();
            example.createCriteria().andUidEqualTo(vo.getId()).andIdentityTypeEqualTo((byte) 2);
            UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
            String thirdData = userOtherAuth != null ? userOtherAuth.getThirdData() : null;
            if (userOtherAuth == null || StringUtils.isEmpty(thirdData)) {
                return new Result(0, "运营商数据为空，无法获取分析报告");
            }

            JSONObject jsonObject = JSON.parseObject(thirdData);
            String data = jsonObject.getString("data");
            InputStream inputStream = Utils.string2InputStream(data);
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("/temp/");

            String filename = userOtherAuth.getUid() + ".txt";

            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }

            try {
                Utils.inputstreamtofile(inputStream, filepath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String respBody = null;
            try {
                String sign = DigestUtils.md5Hex(userid1 + apiKey1);

                JSONObject params = new JSONObject();
                params.put("name", name1);
                params.put("idCard", idNumber1);

//            File file = new File("D:\\AuthFetchTest\\13800138000-1.txt");
                FileSystemResource resource = new FileSystemResource(filepath);

                MultiValueMap<String, Object> paraMap = new LinkedMultiValueMap<String, Object>();
                paraMap.add("userid", userid1);
                paraMap.add("sign", sign);
                paraMap.add("params", params.toJSONString());
                paraMap.add("file", resource);
                paraMap.add("fileName", "yys-data.txt");

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.MULTIPART_FORM_DATA);
                HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(paraMap, headers);
                RestTemplate restTemplate = new RestTemplate();
                String url = "https://www.zhichengcredit.com/echo-center/api/authFetchApi/report";
                ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
                respBody = responseEntity.getBody();
                filepath.delete();//请求完成之后删除

                JSONObject jsonObject1 = JSON.parseObject(respBody);
                String errorcode = jsonObject1.getString("errorCode");
                if (errorcode.equals("0000")) {
                    if (userOtherAuth1 != null) {
                        userOtherAuth1.setThirdData(respBody);
                        userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth1);
                    } else {
                        UserOtherAuth record = new UserOtherAuth();
                        record.setUid(vo.getId());
                        record.setCertificate("");
                        record.setIdentifier("");
                        record.setIdentityType((byte) 6);
                        record.setThirdData(respBody);
                        userOtherAuthService.insert(record);
                    }
                    return matchContactInOperateReportData(vo.getId(), respBody);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return respBody;
        }
    }

    /**
     * 匹配通讯录
     *
     * @param userUid
     * @param callCountsList
     * @param mobileKey
     * @param cache          缓存
     * @return
     */
    private JSONArray matchContacts(Long userUid, JSONArray callCountsList, String mobileKey, Map<String, String> cache) {
        for (Object o : callCountsList) {
            JSONObject temp = (JSONObject) o;
            String mobile = temp.getString(mobileKey);
            String contactName = null;

            if (cache.containsKey(mobile)) {//存在该号码缓存
                contactName = cache.get(mobile);
                temp.put("contactName", contactName);
            } else {//不存在查找数据库
                UserContactsExample contactsExample = new UserContactsExample();
                contactsExample.createCriteria().andUserUidEqualTo(userUid).andContactMobileEqualTo(mobile);
                UserContacts userContacts = contactsService.selectFirstByExample(contactsExample);
                if (userContacts != null && !StringUtils.isEmpty(userContacts.getContactName())) {
                    contactName = userContacts.getContactName();
                } else {
                    contactName = "";
                }
                temp.put("contactName", contactName);
                cache.put(mobile, contactName);
            }
        }
        return callCountsList;
    }

    private String matchContactInOperateReportData(Long userUid, String thirdData) {
        Map<String, String> cache = new HashMap<>();
        JSONObject jsonObject = JSON.parseObject(thirdData);
        JSONObject dataJson = jsonObject.getJSONObject("data");
        //匹配通讯录
        matchContacts(userUid, dataJson.getJSONArray("callCountsList"), "mobile", cache);
        matchContacts(userUid, dataJson.getJSONArray("callTimesList"), "mobile", cache);
        matchContacts(userUid, dataJson.getJSONArray("singleCallList"), "mobile", cache);
        matchContacts(userUid, dataJson.getJSONArray("detailsCallList"), "mobile", cache);
        cache.clear();
        cache = null;
        return jsonObject.toString();
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
//            String data = jsonObject.getString("data");
            UserOtherAuthExample example = new UserOtherAuthExample();
            example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 1);
            UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
            //添加数据
            userOtherAuth.setThirdData(s);
            userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth);
        }
        return s;
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<淘宝接口*/

    /*多头接口>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
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
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
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
        nameValuePairs.add(new BasicNameValuePair("user_name", Constants.muti_user_name));
        //rc4秘钥
        nameValuePairs.add(new BasicNameValuePair("sign", Constants.muti_sign));
        //接口业务码 参考接口文档
        nameValuePairs.add(new BasicNameValuePair("api_name", Constants.api_name));
        // 查询原因
        // LOAN_AUDIT：贷款审批 LOAN_MANAGE：贷后管理 CREDIT_CARD_AUDIT：信用卡审批
        // GUARANTEE_AUDIT:担保资格审查 PRE_GUARANTEE_AUDIT:保前审查
        nameValuePairs.add(new BasicNameValuePair("query_reason", ReasonEnum.LOAN_AUDIT.getType()));
        //查询条件,格式为 json 格式
        nameValuePairs.add(new BasicNameValuePair("params", dataJson.toJSONString()));
        String s = HttpClientUtil.doPost(Constants.url, nameValuePairs, "utf-8");
        JSONObject jsonObject = JSON.parseObject(s);
        String code = jsonObject.getString("code");
        if (code.equals("10000")) {
            if (userOtherAuth != null) {//存在,但是没有三方数据
//                userOtherAuth.setThirdData(jsonObject.getString("data"));
                userOtherAuth.setThirdData(s);
                userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth);
                return new Result(ResultConstant.SUCCESS);
            } else {//不存在
                UserOtherAuth record = new UserOtherAuth();
                record.setUid(user.getUid());
                record.setCertificate(vo.getIdNo());
                record.setIdentifier(vo.getName());
                record.setIdentityType((byte) 3);
//                record.setThirdData(jsonObject.getString("data"));
                record.setThirdData(s);
                userOtherAuthService.insert(record);
                return new Result(ResultConstant.SUCCESS);
            }
        } else {
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
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        if (userOtherAuth != null && !StringUtils.isEmpty(userOtherAuth.getThirdData())) {//存在
            return new Result(ResultConstant.SUCCESS);
        }

        //开始查询
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        //用户名
        nameValuePairs.add(new BasicNameValuePair("user_name", Constants.qizha_user_name));
        //rc4秘钥
        nameValuePairs.add(new BasicNameValuePair("sign", Constants.qizha_sign));
        //接口业务码 参考接口文档
        nameValuePairs.add(new BasicNameValuePair("api_name", Constants.api_name_jinjie));
        // 查询原因
        // LOAN_AUDIT：贷款审批 LOAN_MANAGE：贷后管理 CREDIT_CARD_AUDIT：信用卡审批
        // GUARANTEE_AUDIT:担保资格审查 PRE_GUARANTEE_AUDIT:保前审查
        nameValuePairs.add(new BasicNameValuePair("query_reason", "LOAN_AUDIT"));
        //查询条件,格式为 json 格式
        nameValuePairs.add(new BasicNameValuePair("params", gennerateRequetParam(request, vo).toJSONString()));
        String s = HttpClientUtil.doPost(Constants.url, nameValuePairs, "utf-8");
        JSONObject jsonObject = JSON.parseObject(s);
        String code = jsonObject.getString("code");
        if (code.equals("10000")) {
            if (userOtherAuth != null) {//存在,但是没有三方数据
//                userOtherAuth.setThirdData(jsonObject.getString("data"));
                userOtherAuth.setThirdData(s);
                userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth);
                return new Result(ResultConstant.SUCCESS);
            } else {//不存在
                UserOtherAuth record = new UserOtherAuth();
                record.setUid(user.getUid());
                record.setCertificate(user.getIdCard());
                record.setIdentifier(user.getUserRealName());
                record.setIdentityType((byte) 4);
//                record.setThirdData(jsonObject.getString("data"));
                record.setThirdData(s);
                userOtherAuthService.insert(record);
                return new Result(ResultConstant.SUCCESS);
            }
        } else {
            return new Result(Integer.parseInt(code), jsonObject.getString("msg"));
        }
    }

    /*欺诈甄别接口>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "欺诈甄别TDL测试接口")
    @RequestMapping(value = "qizhaDataTDL")
    @ResponseBody
    public Object qizhaDataTDL(HttpServletRequest request, @RequestBody Map<String, String> vo) {
        //开始查询
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        //用户名
        nameValuePairs.add(new BasicNameValuePair("user_name", Constants.qizha_user_name));
        //rc4秘钥
        nameValuePairs.add(new BasicNameValuePair("sign", Constants.qizha_sign));
        //接口业务码 参考接口文档
        nameValuePairs.add(new BasicNameValuePair("api_name", Constants.api_name_jinjie));
        // 查询原因
        // LOAN_AUDIT：贷款审批 LOAN_MANAGE：贷后管理 CREDIT_CARD_AUDIT：信用卡审批
        // GUARANTEE_AUDIT:担保资格审查 PRE_GUARANTEE_AUDIT:保前审查
        nameValuePairs.add(new BasicNameValuePair("query_reason", "LOAN_AUDIT"));
        //查询条件,格式为 json 格式
        nameValuePairs.add(new BasicNameValuePair("params", gennerateRequetParam(request, vo).toJSONString()));
        String s = HttpClientUtil.doPost(Constants.url, nameValuePairs, "utf-8");
        JSONObject jsonObject = JSON.parseObject(s);
        String code = jsonObject.getString("code");
        return new Result(Integer.parseInt(code), jsonObject.getString("msg"));
    }


    @ApiOperation(value = "欺诈甄别设备指纹接口")
    @RequestMapping(value = "devicePrintData")
    @ResponseBody
    public Object devicePrintData(HttpServletRequest request, @RequestBody Map<String, String> vo) {
        UserBase user = UserUtils.getUser(request);
        if (user == null) {
            return new Result(ResultConstant.EXCEPTION_INVALID);
        }
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 5);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        if (userOtherAuth != null && !StringUtils.isEmpty(userOtherAuth.getThirdData())) {//存在
            return new Result(ResultConstant.SUCCESS);
        }

        //开始查询
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        //用户名
        nameValuePairs.add(new BasicNameValuePair("user_name", Constants.qizha_user_name));
        //rc4秘钥
        nameValuePairs.add(new BasicNameValuePair("sign", Constants.qizha_sign));
        //接口业务码 参考接口文档
        nameValuePairs.add(new BasicNameValuePair("api_name", Constants.api_name1));
        // 查询原因
        // LOAN_AUDIT：贷款审批 LOAN_MANAGE：贷后管理 CREDIT_CARD_AUDIT：信用卡审批
        // GUARANTEE_AUDIT:担保资格审查 PRE_GUARANTEE_AUDIT:保前审查
        nameValuePairs.add(new BasicNameValuePair("query_reason", "LOAN_AUDIT"));
        //查询条件,格式为 json 格式
        nameValuePairs.add(new BasicNameValuePair("params", gennerateDevicePrintRequetParam(request, vo).toJSONString()));
        String s = HttpClientUtil.doPost(Constants.url, nameValuePairs, "utf-8");
        JSONObject jsonObject = JSON.parseObject(s);
        String code = jsonObject.getString("code");
        if (code.equals("10000")) {
            if (userOtherAuth != null) {//存在,但是没有三方数据
//                userOtherAuth.setThirdData(jsonObject.getString("data"));
                userOtherAuth.setThirdData(s);
                userOtherAuthService.updateByPrimaryKeySelective(userOtherAuth);
                return new Result(ResultConstant.SUCCESS);
            } else {//不存在
                UserOtherAuth record = new UserOtherAuth();
                record.setUid(user.getUid());
                record.setCertificate(user.getIdCard());
                record.setIdentifier(user.getUserRealName());
                record.setIdentityType((byte) 5);
//                record.setThirdData(jsonObject.getString("data"));
                record.setThirdData(s);
                userOtherAuthService.insert(record);
                return new Result(ResultConstant.SUCCESS);
            }
        } else {
            return new Result(Integer.parseInt(code), jsonObject.getString("msg"));
        }
    }


    /**
     * 设备指纹参数构建
     *
     * @param request
     * @param vo
     * @return
     */
    public JSONObject gennerateDevicePrintRequetParam(HttpServletRequest request, Map<String, String> vo) {
        UserBase user = UserUtils.getUser(request);
//        UserLocation userLocation = userLocationService.selectByPrimaryKey(user.getCompanyLocationUid());
        JSONObject dataJson = new JSONObject();
        dataJson.put("queryFraudScreening", "false");//不要进阶版
        dataJson.put("queryDevicePrint", "true");//需要设备指纹
        dataJson.put("amount_business", "0");
//        JSONArray addrArray = new JSONArray();
//        addrArray.add("SELF_MOBILE_1_FAMILY_ADDR");
//        addrArray.add("SELF_MOBILE_1_CORP_ADDR");
//        dataJson.put("addr_detection_types", addrArray);
        dataJson.put("id_no", user.getIdCard());//被查询人身份证号 18 位以内
        dataJson.put("name", user.getUserRealName());//被查询人姓名 2-30 位
        dataJson.put("mobile", user.getMobile());
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

        dataJson.put("email", user.getEmail());
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

    /**
     * 进阶版（无设备指纹参数构建）
     *
     * @param request
     * @param vo
     * @return
     */
    public static JSONObject gennerateRequetParam(HttpServletRequest request, Map<String, String> vo) {
        UserBase user = UserUtils.getUser(request);
        JSONObject dataJson = new JSONObject();
        dataJson.put("amount_business", "0");
        dataJson.put("id_no", user.getIdCard());//被查询人身份证号 18 位以内
        dataJson.put("name", user.getUserRealName());//被查询人姓名 2-30 位
        dataJson.put("mobile", user.getMobile());//被查询人姓名 2-30 位
        dataJson.put("bank_no", "");
//        JSONObject corp_addr_json = new JSONObject();
//        corp_addr_json.put("address", "温特莱B座1910");
//        corp_addr_json.put("city", "北京市");
//        corp_addr_json.put("county", "朝阳区");
//        corp_addr_json.put("province", "北京市");
//        dataJson.put("corp_addr", corp_addr_json);

//        dataJson.put("corp_tel", "010-61300110");
//        JSONArray contacts = new JSONArray();
//        JSONObject cpntactJson = new JSONObject();
//        cpntactJson.put("contact_id_no", "370633197005042513");
//        cpntactJson.put("contact_mobile", "15002035914");
//        cpntactJson.put("contact_name", "高求");
//        cpntactJson.put("contact_type", "SPOUSE");
//        contacts.add(cpntactJson);
//        dataJson.put("contacts", contacts);
        dataJson.put("email", user.getEmail());
//        JSONObject family_addrjson = new JSONObject();
//        family_addrjson.put("address", "温特莱B座1910");
//        family_addrjson.put("city", "北京市");
//        family_addrjson.put("county", "朝阳区");
//        family_addrjson.put("province", "北京市");
//        dataJson.put("family_addr", family_addrjson);
//        dataJson.put("family_tel", "010-61300110");
//        dataJson.put("qq", "532537296");
        return dataJson;
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<欺诈甄别接口*/

    /*白骑士接口>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @ApiOperation(value = "白骑士欺诈接口")
    @RequestMapping(value = "qiZhaDatabaiqishi")
    @ResponseBody
    public Object qiZhaDatabaiqishi(HttpServletRequest request, @RequestBody Map<String, String> vo) {
        UserBase user = UserUtils.getUser(request);
        if (user == null) {
            return new Result(ResultConstant.EXCEPTION_INVALID);
        }
        if (StringUtils.isEmpty(user.getMobile())) {
            return new Result(0, "电话不能为空,请完善基础认证");
        }
        if (StringUtils.isEmpty(user.getIdCard())) {
            return new Result(0, "身份证不能为空,请完善基础认证");
        }
        if (StringUtils.isEmpty(user.getUserRealName())) {
            return new Result(0, "姓名不能为空,请完善基础认证");
        }
        String tokenKey = vo.get("tokenKey");
        if (StringUtils.isEmpty(tokenKey)) {
            return new Result(0, "tokenKey为空");
        }
        Map params = new HashMap();
        //根据商户修改verifyKey和partnerId
        params.put("verifyKey", Constants.verifyKey_baiqishi);
        params.put("partnerId", Constants.partnerId_baiqishi);
        //应用的appid，根据调用的应用修改
        params.put("appId", Constants.appId_baiqishi);
        //业务参数传入
        params.put("eventType", Constants.eventType_login);        //根据触发的场景传入
        params.put("mobile", user.getMobile());
        params.put("name ", user.getUserRealName());
        params.put("certNo", user.getIdCard());
        params.put("tokenKey", tokenKey);
        Invoker.init();
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 7);
        UserOtherAuth loginAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);//登录事件已存在数据
        if (loginAuth == null) {//不存在存在
            UserOtherAuth login = new UserOtherAuth();
            String loginResult = "";
            try {
                loginResult = Invoker.invoke(params, Constants.apiUrl_baiqishi);
                JSONObject jsonObject = JSON.parseObject(loginResult);
                String resultCode = jsonObject.getString("resultCode");
                if("BQS000".equalsIgnoreCase(resultCode)){
                    login.setUid(user.getUid());
                    login.setCertificate(user.getIdCard());
                    login.setIdentifier(tokenKey);
                    login.setIdentityType((byte) 7);
                    login.setThirdData(loginResult);
                    userOtherAuthService.insertSelective(login);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            if (StringUtils.isEmpty(loginAuth.getThirdData())) {//没有白骑士数据
                String loginResult = "";
                try {
                    loginResult = Invoker.invoke(params, Constants.apiUrl_baiqishi);
                    JSONObject jsonObject = JSON.parseObject(loginResult);
                    String resultCode = jsonObject.getString("resultCode");
                    if("BQS000".equalsIgnoreCase(resultCode)){
                        loginAuth.setThirdData(loginResult);
                        userOtherAuthService.updateByPrimaryKeySelective(loginAuth);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        example.clear();
        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 8);
        UserOtherAuth loanAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);//贷款事件已存在数据
        params.put("eventType",Constants.eventType_loan);
        if (loanAuth == null) {//不存在存在
            UserOtherAuth loan = new UserOtherAuth();
            String loanResult = "";
            try {
                loanResult = Invoker.invoke(params, Constants.apiUrl_baiqishi);
                JSONObject jsonObject = JSON.parseObject(loanResult);
                String resultCode = jsonObject.getString("resultCode");
                if("BQS000".equalsIgnoreCase(resultCode)){
                    loan.setUid(user.getUid());
                    loan.setCertificate(user.getIdCard());
                    loan.setIdentifier(tokenKey);
                    loan.setIdentityType((byte) 8);
                    loan.setThirdData(loanResult);
                    userOtherAuthService.insertSelective(loan);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (StringUtils.isEmpty(loanAuth.getThirdData())) {//没有白骑士数据
                String loanResult = "";
                try {
                    loanResult = Invoker.invoke(params, Constants.apiUrl_baiqishi);
                    JSONObject jsonObject = JSON.parseObject(loanResult);
                    String resultCode = jsonObject.getString("resultCode");
                    if("BQS000".equalsIgnoreCase(resultCode)){
                        loanAuth.setThirdData(loanResult);
                        userOtherAuthService.updateByPrimaryKeySelective(loanAuth);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return new Result(ResultConstant.SUCCESS);
    }

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


    @ApiOperation(value = "获取运营商报告")
    @RequestMapping(value = "getOperateData")
    @ResponseBody
    public Result getOperateData(HttpServletRequest request, @RequestBody IdReqVO vo) {
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(vo.getId()).andIdentityTypeEqualTo((byte) 2);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        if (userOtherAuth == null || StringUtils.isEmpty(userOtherAuth.getThirdData())) {
            return new Result(ResultConstant.SUCCESS);
        }
        String thirdData = userOtherAuth.getThirdData();
        Map map = JSON.parseObject(thirdData, Map.class);
        return new Result(ResultConstant.SUCCESS, map);
    }

    @ApiOperation(value = "获取淘宝报告")
    @RequestMapping(value = "getTaobaoData")
    @ResponseBody
    public Result getTaobaoData(HttpServletRequest request, @RequestBody IdReqVO vo) {
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(vo.getId()).andIdentityTypeEqualTo((byte) 1);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        if (userOtherAuth == null || StringUtils.isEmpty(userOtherAuth.getThirdData())) {
            return new Result(ResultConstant.SUCCESS);
        }
        String thirdData = userOtherAuth.getThirdData();
        Map map = JSON.parseObject(thirdData, Map.class);
        return new Result(ResultConstant.SUCCESS, map);
    }

    @ApiOperation(value = "获取多头报告")
    @RequestMapping(value = "getMutiPartData")
    @ResponseBody
    public Result getMutiPartData(HttpServletRequest request, @RequestBody IdReqVO vo) {
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(vo.getId()).andIdentityTypeEqualTo((byte) 3);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        if (userOtherAuth == null || StringUtils.isEmpty(userOtherAuth.getThirdData())) {
            return new Result(ResultConstant.SUCCESS);
        }
        String thirdData = userOtherAuth.getThirdData();
        Map map = JSON.parseObject(thirdData, Map.class);
        return new Result(ResultConstant.SUCCESS, map);
    }

    @ApiOperation(value = "获取反欺诈报告")
    @RequestMapping(value = "getFanQizhaData")
    @ResponseBody
    public Result getFanQizhaData(HttpServletRequest request, @RequestBody IdReqVO vo) {
        UserOtherAuthExample example = new UserOtherAuthExample();
        example.createCriteria().andUidEqualTo(vo.getId()).andIdentityTypeEqualTo((byte) 4);
        UserOtherAuth userOtherAuth = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        if (userOtherAuth == null || StringUtils.isEmpty(userOtherAuth.getThirdData())) {
            return new Result(ResultConstant.SUCCESS);
        }
        String thirdData = userOtherAuth.getThirdData();
        Map map = JSON.parseObject(thirdData, Map.class);
        return new Result(ResultConstant.SUCCESS, map);
    }


    @ApiOperation(value = "获取认证结果")
    @RequestMapping(value = "/getVerifyResult")
    @ResponseBody
    @Transactional
    public Result getVerifyResult(HttpServletRequest request) {
        UserBase user = UserUtils.getUser(request);
        UserBase userBase = userBaseService.selectByPrimaryKey(user.getUid());
        Map map = new HashMap();
        rateJiben(map, user);
        UserOtherAuthExample example = new UserOtherAuthExample();
//        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 1);
//        UserOtherAuth taobao = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        if (userBase.getTaobaoBaiqishiState() == 0) {
            map.put("isTaobaoVerify", false);
        } else {
            map.put("isTaobaoVerify", true);
        }
//        example.clear();
//        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 2);
//        UserOtherAuth yunyin = userOtherAuthService.selectFirstByExampleWithBLOBs(example);

        if (userBase.getOperateBaiqishiState() == 0) {
            map.put("isYunyinVerify", false);
        } else {
            map.put("isYunyinVerify", true);
        }
        example.clear();
        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 3);
        UserOtherAuth duotou = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        if (duotou == null || StringUtils.isEmpty(duotou.getThirdData())) {
            map.put("isDuotouVerify", false);
        } else {
            map.put("isDuotouVerify", true);
        }
        example.clear();
        example.createCriteria().andUidEqualTo(user.getUid()).andIdentityTypeEqualTo((byte) 4);
        UserOtherAuth qizha = userOtherAuthService.selectFirstByExampleWithBLOBs(example);
        if (qizha == null || StringUtils.isEmpty(qizha.getThirdData())) {
            map.put("isqizhaVerify", false);
        } else {
            map.put("isqizhaVerify", true);
        }
        UserContactsExample contactsExample = new UserContactsExample();
        contactsExample.createCriteria().andUserUidEqualTo(user.getUid());
        int count = userContactsService.countByExample(contactsExample);
        map.put("contactsCount", count);
        UserEmergencyContactExample emergencyContactExample = new UserEmergencyContactExample();
        emergencyContactExample.createCriteria().andUserUidEqualTo(user.getUid()).andContactNameNotEqualTo("").andContactMobileNotEqualTo("");
        int emergencyCount = emergencyContactService.countByExample(emergencyContactExample);
        map.put("emergencyCount", emergencyCount);
        UserOtherAcountExample otherAcountExample = new UserOtherAcountExample();
        otherAcountExample.createCriteria().andUserUidEqualTo(user.getUid()).andAcountNotEqualTo("").andAcountPasswordNotEqualTo("");
        int otherAcountCount = userOtherAcountService.countByExample(otherAcountExample);
        map.put("otherAcountCount", otherAcountCount);
        return new Result(ResultConstant.SUCCESS, map);
    }

    /**
     * 计算基本资料百分比
     *
     * @param map
     * @param user
     */
    private void rateJiben(Map map, UserBase user) {
        int count = 0;
        if (!StringUtils.isEmpty(user.getUserRealName())) {
            count++;
        }
        if (!StringUtils.isEmpty(user.getIdCard())) {
            count++;
        }

        if (!StringUtils.isEmpty(user.getWchatId())) {
            count++;
        }
        if (user.getAliScore() != null && user.getAliScore() > 0) {
            count++;
        }
        if (!StringUtils.isEmpty(user.getCompanyName())) {
            count++;
        }
        if (user.getCompanyLocationUid() != null) {
            count++;
        }
        if (!StringUtils.isEmpty(user.getCompanyPhone())) {
            count++;
        }
        if (user.getSalary() != null && user.getSalary() > 0) {
            count++;
        }
        if (!StringUtils.isEmpty(user.getCompanyJob())) {
            count++;
        }
        map.put("jibenRate", count / 9f);

        int photoCount = 0;
        if (user.getIdCardPhoto1() != null) {
            photoCount++;
        }
        if (user.getIdCardPhoto2() != null) {
            photoCount++;
        }
        if (user.getIdCardPhoto3() != null) {
            photoCount++;
        }
        map.put("photoCount", photoCount);
    }

    @Autowired
    private ChannelService channelService;

    @ApiOperation(value = "根据id获取渠道")
    @RequestMapping(value = "getChannel")
    @ResponseBody
    public Result getChannel(@RequestBody IdReqVO vo) {
        Channel channel = channelService.selectByPrimaryKey(vo.getId());
        if (channel == null) {
            return new Result(ResultConstant.FAILED);
        }
        return new Result(ResultConstant.SUCCESS, channel);
    }


    @ApiOperation(value = "获取管理用户信息")
    @RequestMapping(value = "/getSysUser")
    @ResponseBody
    public Result getSysUser(HttpServletRequest request) {
        UserBase user = UserUtils.getUser(request);
        UserBase userBase = userBaseService.selectByPrimaryKey(user.getUid());
        UserUtils.createUserSession(request, userBase);
        Map map = new HashMap();
        Long verifyUid = userBase.getVerifyUid();
        if (verifyUid != null && verifyUid != 0) {
            SysUserBase verifyBase = sysUserBaseService.selectByPrimaryKey(verifyUid);
            Long wchatQrcode = verifyBase.getWchatQrcode();
            if (wchatQrcode == null) {
                map.put("verifyWchatQrcodePath", "");
            } else {
                StorageImage storageImage = storageImageService.selectByPrimaryKey(wchatQrcode);
                map.put("verifyWchatQrcodePath", storageImage != null ? storageImage.getFullPath() : "");
            }
        } else {
            map.put("verifyWchatQrcodePath", "");
        }
        Long browerUid = userBase.getBrowerUid();
        if (browerUid != null && browerUid != 0) {
            SysUserBase browerBase = sysUserBaseService.selectByPrimaryKey(browerUid);
            Long wchatQrcode = browerBase.getWchatQrcode();
            if (wchatQrcode == null) {
                map.put("browerBaseWchatQrcodePath", "");
            } else {
                StorageImage storageImage = storageImageService.selectByPrimaryKey(wchatQrcode);
                map.put("browerBaseWchatQrcodePath", storageImage != null ? storageImage.getFullPath() : "");
            }
        } else {
            map.put("browerBaseWchatQrcodePath", "");
        }
        return new Result(ResultConstant.SUCCESS, map);
    }

    //白骑士相关接口
    @ApiOperation(value = "更新运营商认证状态")
    @RequestMapping(value = "/updateOperateBaiqishiState")
    @ResponseBody
    public Result updateOperateBaiqishiState(HttpServletRequest request, @RequestBody Map<String, String> data) {
//        certNo	申请人填写的身份证
//        mobile	申请人填写的手机号
//        name	申请人填写的姓名
        String certNo = data.get("certNo");
        String mobile = data.get("mobile");
        String name = data.get("name");
        if (StringUtils.isEmpty(certNo)) {
            return new Result(0, "身份证不能为空");
        }
        if (StringUtils.isEmpty(mobile)) {
            return new Result(0, "手机号不能为空");
        }
        if (StringUtils.isEmpty(name)) {
            return new Result(0, "姓名不能为空");
        }

        UserBaseExample example = new UserBaseExample();
        example.createCriteria().andMobileEqualTo(mobile);
        UserBase userBase = userBaseService.selectFirstByExample(example);
        if (userBase == null) {
            return new Result(0, "不存在该用户");
        }
        if (userBase.getOperateBaiqishiState() == 0) {
            userBase.setOperateBaiqishiState(1);
            if (userBaseService.updateByPrimaryKeySelective(userBase) > 0) {
                return new Result(ResultConstant.SUCCESS);
            }
        }
        return new Result(ResultConstant.FAILED);
    }

    //白骑士相关接口
    @ApiOperation(value = "更新淘宝认证状态")
    @RequestMapping(value = "/updateTaoboBaiqishiState")
    @ResponseBody
    public Result updateTaoboBaiqishiState(HttpServletRequest request, @RequestBody Map<String, String> data) {
        String certNo = data.get("certNo");
        String mobile = data.get("mobile");
        String name = data.get("name");
        if (StringUtils.isEmpty(certNo)) {
            return new Result(0, "身份证不能为空");
        }
        if (StringUtils.isEmpty(mobile)) {
            return new Result(0, "手机号不能为空");
        }
        if (StringUtils.isEmpty(name)) {
            return new Result(0, "姓名不能为空");
        }

        UserBaseExample example = new UserBaseExample();
        example.createCriteria().andMobileEqualTo(mobile);
        UserBase userBase = userBaseService.selectFirstByExample(example);
        if (userBase == null) {
            return new Result(0, "不存在该用户");
        }
        if (userBase.getTaobaoBaiqishiState() == 0) {
            userBase.setTaobaoBaiqishiState(1);//更新淘宝状态
            if (userBaseService.updateByPrimaryKeySelective(userBase) > 0) {
                return new Result(ResultConstant.SUCCESS);
            }
        }
        return new Result(ResultConstant.FAILED);
    }
}
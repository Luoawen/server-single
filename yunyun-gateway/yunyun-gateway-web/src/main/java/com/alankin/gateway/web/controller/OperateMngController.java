package com.alankin.gateway.web.controller;

import com.alankin.common.util.StringUtil;
import com.alankin.common.util.key.SnowflakeIdWorker;
import com.alankin.common.util.key.SystemClock;
import com.alankin.gateway.web.utils.UserUtils;
import com.alankin.gateway.web.vo.ListVo.IdReqVO;
import com.alankin.gateway.web.vo.ListVo.IdsReqVO;
import com.alankin.gateway.web.vo.ListVo.ListReqVO;
import com.alankin.gateway.web.vo.request.ChannelAcountEditReqVo;
import com.alankin.gateway.web.vo.request.ChannelAcountListReqVo;
import com.alankin.gateway.web.vo.request.ChannelEditReqVo;
import com.alankin.gateway.web.vo.response.ListResult;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.dao.model.*;
import com.alankin.ucenter.rpc.api.*;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 注册控制器
 * Created by alankin.
 */
@Controller
@Api(value = "运营管理接口", description = "运营管理接口")
@RequestMapping(value = "/api/operate", method = RequestMethod.POST)
public class OperateMngController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperateMngController.class);

    @Autowired
    private ChannelService channelService;
    @Autowired
    private ChannelRecordService channelRecordService;
    @Autowired
    private SysRoleUserService sysRoleUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserBaseService sysUserBaseService;
    @Autowired
    private SysUserAuthService sysUserAuthService;

    @ApiOperation(value = "渠道列表")
    @RequestMapping(value = "/channelList")
    @ResponseBody
    @Transactional
    public ListResult channelList(HttpServletRequest request, @RequestBody ListReqVO<IdReqVO> listReqVO) {
        IdReqVO condition = new IdReqVO();
        listReqVO.setCondition(condition);
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        PageInfo pageInfo = null;
        //判断用户是否是超级管理员
        if (sysRole.getType() == 1) {//如果是超级管理员查看渠道列表
            pageInfo = channelService.selectForStartPageByMethod("channelList", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        } else if (sysRole.getType() == 3) {//广告商查看渠道列表
            condition.setId(sysUser.getUid());
            listReqVO.setCondition(condition);
            pageInfo = channelService.selectForStartPageByMethod("channelList", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        }
        if (pageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED);
    }

    @ApiOperation(value = "渠道账号列表")
    @RequestMapping(value = "/channelAcountList")
    @ResponseBody
    @Transactional
    public ListResult channelAcountList(HttpServletRequest request, @RequestBody ListReqVO<ChannelAcountListReqVo> listReqVO) {
        PageInfo pageInfo = channelService.selectForStartPageByMethod("channelAcountList", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        if (pageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "审核人列表")
    @RequestMapping(value = "/verifyList")
    @ResponseBody
    @Transactional
    public Result verifyList() {
        List<Map> verifyList = channelService.selectAllByMethod("verifyList");
        return new Result(ResultConstant.SUCCESS, verifyList);
    }

    @ApiOperation(value = "广告商列表")
    @RequestMapping(value = "/adList")
    @ResponseBody
    @Transactional
    public Result adList() {
        List<Map> adList = channelService.selectAllByMethod("adList");
        return new Result(ResultConstant.SUCCESS, adList);
    }

    @ApiOperation(value = "添加渠道")
    @RequestMapping(value = "/addChannel")
    @ResponseBody
    @Transactional
    public Result addChannel(@RequestBody ChannelEditReqVo channelEditReqVo) throws Exception {
        Channel record = new Channel();
        String channelName = channelEditReqVo.getChannelName();
        String state = channelEditReqVo.getState();
        String adUid = channelEditReqVo.getAdUid();
        String verifyUid = channelEditReqVo.getVerifyUid();
        String logoId = channelEditReqVo.getLogoId();
        String welcomeBgId = channelEditReqVo.getWelcomeBgId();

        if (StringUtils.isNotEmpty(channelName)) {
            record.setChannelName(channelEditReqVo.getChannelName());
        }
        if (StringUtils.isNotEmpty(state)) {
            record.setState(Byte.valueOf(state));
        }
        if (StringUtils.isNotEmpty(adUid)) {
            record.setResponsibleUserId(Long.valueOf(adUid));
        }
        if (StringUtils.isNotEmpty(verifyUid)) {
            record.setVerifyUserId(Long.valueOf(verifyUid));
        }
        if (StringUtils.isNotEmpty(logoId)) {
            record.setLogoId(Long.valueOf(logoId));
        }
        if (StringUtils.isNotEmpty(welcomeBgId)) {
            record.setWelcomeBgId(Long.valueOf(welcomeBgId));
        }
        if (channelService.insertSelective(record) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "修改渠道")
    @RequestMapping(value = "/updateChannel")
    @ResponseBody
    @Transactional
    public Result updateChannel(@RequestBody ChannelEditReqVo channelEditReqVo) {
        Channel channel = null;
        String id = channelEditReqVo.getId();
        String channelName = channelEditReqVo.getChannelName();
        String state = channelEditReqVo.getState();
        String adUid = channelEditReqVo.getAdUid();
        String verifyUid = channelEditReqVo.getVerifyUid();
        String logoId = channelEditReqVo.getLogoId();
        String welcomeBgId = channelEditReqVo.getWelcomeBgId();
        if (StringUtils.isNotEmpty(id)) {
            channel = channelService.selectByPrimaryKey(Long.valueOf(id));
        }
        if (StringUtils.isNotEmpty(channelName)) {
            channel.setChannelName(channelEditReqVo.getChannelName());
        }
        if (StringUtils.isNotEmpty(state)) {
            channel.setState(Byte.valueOf(state));
        }
        if (StringUtils.isNotEmpty(adUid)) {
            channel.setResponsibleUserId(Long.valueOf(adUid));
        }
        if (StringUtils.isNotEmpty(verifyUid)) {
            channel.setVerifyUserId(Long.valueOf(verifyUid));
        }

        if (StringUtils.isNotEmpty(logoId)) {
            channel.setLogoId(Long.valueOf(logoId));
        } else {
            channel.setLogoId(null);
        }

        if (StringUtils.isNotEmpty(welcomeBgId)) {
            channel.setWelcomeBgId(Long.valueOf(welcomeBgId));
        } else {
            channel.setWelcomeBgId(null);
        }
        if (channelService.updateByPrimaryKey(channel) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "删除渠道")
    @RequestMapping(value = "/delChannel")
    @ResponseBody
    @Transactional
    public Result delChannel(@RequestBody IdReqVO idReqVO) {
        if (channelService.deleteByPrimaryKey(idReqVO.getId()) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "批量删除渠道")
    @RequestMapping(value = "/batchDelChannel")
    @ResponseBody
    @Transactional
    public Result batchDelChannel(@RequestBody IdsReqVO idsReqVO) {
        if (channelService.deleteByPrimaryKeys(idsReqVO.getIds()) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

/////////////////////////////////////渠道账号////////////////////////////////////////

    @ApiOperation(value = "添加渠道账号")
    @RequestMapping(value = "/addChannelAcount")
    @ResponseBody
    @Transactional
    public Result addChannelAcount(@RequestBody ChannelAcountEditReqVo acountEditReqVo) throws Exception {
        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria()
                .andIdentifierEqualTo(acountEditReqVo.getMobile()).andIsDelEqualTo(false);
        SysUserAuth userAuth = sysUserAuthService.selectFirstByExample(example);
        if (userAuth != null) {
            return new Result(0, "已存在该账号!");
        }
        SysUserBaseExample userBaseExample = new SysUserBaseExample();
        userBaseExample.createCriteria()
                .andUserNameEqualTo(acountEditReqVo.getUserName());
        SysUserBase sysUserBase = sysUserBaseService.selectFirstByExample(userBaseExample);
        if (sysUserBase != null) {
            return new Result(0, "已存在该用户名!");
        }
        //不存在账号时，创建用户
        SysUserBase userBase = new SysUserBase();
        userBase.setUid(new SnowflakeIdWorker(0, 0).nextId());
        int curentTime = SystemClock.currentTimeSecond();

        //获得登录账号
        //注册来源：1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博
        String identifier = acountEditReqVo.getMobile();
        if (!StringUtil.isPhoneNumber(identifier)) {
            return new Result(0, "请输入正确的手机号");
        }

        userBaseExample.clear();
        userBaseExample.createCriteria()
                .andMobileEqualTo(acountEditReqVo.getMobile());
        if (sysUserBaseService.selectFirstByExample(userBaseExample) != null) {
            return new Result(0, "已存在该手机号!");
        }

        userBase.setMobile(identifier);
        userBase.setRegisterSource((byte) 1);
        userBase.setMobileBindTime(curentTime);
        userBase.setUserName(acountEditReqVo.getUserName());
        userBase.setUserRole(Byte.valueOf(acountEditReqVo.getUserRole()));
        userBase.setRealName(acountEditReqVo.getRealName());
        userBase.setEmail(acountEditReqVo.getEmail());
        if (sysUserBaseService.insertSelective(userBase) > 0) {
            SysUserAuth sysUserAuth = new SysUserAuth();
            sysUserAuth.setUid(userBase.getUid());
            sysUserAuth.setCertificate(acountEditReqVo.getPassword());
            sysUserAuth.setIdentifier(acountEditReqVo.getMobile());
            sysUserAuth.setIdentityType((byte) 1);

            SysRoleExample roleExample = new SysRoleExample();
            roleExample.createCriteria().andTypeEqualTo(3).andStatuEqualTo(1).andSysIdEqualTo(1);
            SysRole sysRole = sysRoleService.selectFirstByExample(roleExample);
            if (sysRole == null) {
                return new Result(ResultConstant.FAILED, null);
            }
            SysRoleUser roleUser = new SysRoleUser();
            roleUser.setRoleId(sysRole.getId());
            roleUser.setRolename(sysRole.getName());
            roleUser.setUserId(userBase.getUid());
            sysRoleUserService.insertSelective(roleUser);

            //添加密码认证权限
            sysUserAuthService.insertSelective(sysUserAuth);
            return new Result(ResultConstant.SUCCESS, userBase);
        } else {
            return new Result(ResultConstant.FAILED, null);
        }
    }

    @ApiOperation(value = "添加渠道账号")
    @RequestMapping(value = "/updateChannelAcount")
    @ResponseBody
    @Transactional
    public Result updateChannelAcount(@RequestBody ChannelAcountEditReqVo acountEditReqVo) {
        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria()
                .andUidEqualTo(Long.valueOf(acountEditReqVo.getUid()))
                .andIsDelEqualTo(false);
        SysUserAuth userAuth = sysUserAuthService.selectFirstByExample(example);
        if (userAuth == null) {
            return new Result(ResultConstant.EXCEPTION_NO_ACOUNT, null);
        }
        String identifier = acountEditReqVo.getMobile();
        if (!StringUtil.isPhoneNumber(identifier)) {
            return new Result(ResultConstant.FAILED, "请输入正确的手机号");
        }
        userAuth.setIdentifier(identifier);
        userAuth.setCertificate(acountEditReqVo.getPassword());
        sysUserAuthService.updateByPrimaryKeySelective(userAuth);

        SysUserBaseExample example1 = new SysUserBaseExample();
        example1.createCriteria()
                .andUidEqualTo(Long.valueOf(acountEditReqVo.getUid()))
                .andIsDelEqualTo(false);
        SysUserBase userBase = sysUserBaseService.selectFirstByExample(example1);
        if (userBase == null) {
            return new Result(ResultConstant.EXCEPTION_NO_ACOUNT, null);
        }
        userBase.setMobile(identifier);
        userBase.setUserName(acountEditReqVo.getUserName());
        userBase.setUserRole(Byte.valueOf(acountEditReqVo.getUserRole()));
        userBase.setRealName(acountEditReqVo.getRealName());
        userBase.setEmail(acountEditReqVo.getEmail());
        sysUserBaseService.updateByPrimaryKeySelective(userBase);
        return new Result(ResultConstant.SUCCESS, null);
    }

    @ApiOperation(value = "删除渠道账号")
    @RequestMapping(value = "/delChannelAcount")
    @ResponseBody
    @Transactional
    public Result delChannelAcount(@RequestBody IdReqVO idReqVO) {
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andTypeEqualTo(3).andStatuEqualTo(1).andSysIdEqualTo(1);
        SysRole sysRole = sysRoleService.selectFirstByExample(roleExample);
        if (sysRole == null) {
            return new Result(ResultConstant.FAILED, "没有创建广告商角色");
        }

        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(idReqVO.getId()).andRoleIdEqualTo(sysRole.getId());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        if (sysRoleUser == null) {
            return new Result(ResultConstant.FAILED, "该账号不是" + sysRole.getName());
        }

        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria()
                .andUidEqualTo(idReqVO.getId()).andIsDelEqualTo(false);
        SysUserAuth userAuth = sysUserAuthService.selectFirstByExample(example);
        if (userAuth == null) {
            return new Result(ResultConstant.EXCEPTION_NO_ACOUNT, null);
        }
        if (sysUserAuthService.deleteByPrimaryKey(userAuth.getId()) > 0 && sysRoleUserService.deleteByPrimaryKey(sysRoleUser.getId()) > 0 && sysUserBaseService.deleteByPrimaryKey(idReqVO.getId()) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "批量删除渠道账号")
    @RequestMapping(value = "/batchDelChannelAcount")
    @ResponseBody
    @Transactional
    public Result batchDelChannelAcount(@RequestBody IdsReqVO idsReqVO) {
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andTypeEqualTo(3).andStatuEqualTo(1).andSysIdEqualTo(1);
        SysRole sysRole = sysRoleService.selectFirstByExample(roleExample);
        if (sysRole == null) {
            return new Result(ResultConstant.FAILED, "没有创建广告商角色");
        }

        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        List<String> strings = Arrays.asList(idsReqVO.getIds());
        List<Long> ids = new ArrayList<>();
        for (String string : strings) {
            ids.add(Long.valueOf(string));
        }
        sysRoleUserExample.createCriteria().andUserIdIn(ids).andRoleIdEqualTo(sysRole.getId());

        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria().andUidIn(ids);
        if (sysUserAuthService.deleteByExample(example) > 0 && sysRoleUserService.deleteByExample(sysRoleUserExample) > 0 && sysUserBaseService.deleteByPrimaryKeys(idsReqVO.getIds()) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    //----------------------------统计相关
    @ApiOperation(value = "selectOrderLogByDuration")
    @RequestMapping(value = "/selectOrderLogByDuration")
    @ResponseBody
    @Transactional
    public Result selectOrderLogByDuration(@RequestBody Map<String, String> params) {
        //recordDateEndTime
        //recordDateStartTime
        //orderUid
        //channelId
        //channelRespUid
        List<Map> maps = channelRecordService.selectAllByMethod("selectOrderLogByDuration", params);
        if (maps != null) {
            return new Result(ResultConstant.SUCCESS, maps);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "selectUserLogByDuration")
    @RequestMapping(value = "/selectUserLogByDuration")
    @ResponseBody
    @Transactional
    public Result selectUserLogByDuration(@RequestBody Map<String, String> params) {
        //recordDateEndTime
        //recordDateStartTime
        //channelId
        //channelRespUid
        List<Map> maps = channelRecordService.selectAllByMethod("selectUserLogByDuration", params);
        if (maps != null) {
            return new Result(ResultConstant.SUCCESS, maps);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "selectOrderLogSummary")
    @RequestMapping(value = "/selectOrderLogSummary")
    @ResponseBody
    @Transactional
    public Result selectOrderLogSummary(@RequestBody Map<String, String> params) {
        //recordDateEndTime
        //recordDateStartTime
        //orderUid
        //channelId
        //channelRespUid
        Map map = channelRecordService.selectByMethod("selectOrderLogSummary", params);
        if (map != null) {
            return new Result(ResultConstant.SUCCESS, map);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "selectUserLogSummary")
    @RequestMapping(value = "/selectUserLogSummary")
    @ResponseBody
    @Transactional
    public Result selectUserLogSummary(@RequestBody Map<String, String> params) {
        //recordDateEndTime
        //recordDateStartTime
        //channelId
        //channelRespUid
        Map map = channelRecordService.selectByMethod("selectUserLogSummary", params);
        if (map != null) {
            return new Result(ResultConstant.SUCCESS, map);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "注册统计列表")
    @RequestMapping(value = "/selectUserLogGroupByChanelAndTime")
    @ResponseBody
    public ListResult selectUserLogGroupByChanelAndTime(HttpServletRequest request, @RequestBody ListReqVO<Map<String, String>> listReqVO) {
        //从session获取用户信息
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        PageInfo pageInfo = null;

        Map<String, String> map = listReqVO.getCondition();
        if (map == null) {
            map = new HashMap<>();
            listReqVO.setCondition(map);
        }
        //判断用户是否是超级管理员
        if (sysRole.getType() == 1) {//如果是超级管理员，展示所有列表
            map.remove("channelRespUid");//移除负责人id，从而查询全部渠道
            pageInfo = channelRecordService.selectForStartPageByMethod("selectUserLogGroupByChanelAndTime", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        } else if (sysRole.getType() == 3) {//渠道商
            map.put("channelRespUid", String.valueOf(sysUser.getUid()));
            pageInfo = channelRecordService.selectForStartPageByMethod("selectUserLogGroupByChanelAndTime", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        }
        if (pageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "查询用户注册列表")
    @RequestMapping(value = "/selectUserLogList")
    @ResponseBody
    public ListResult selectUserLogList(HttpServletRequest request, @RequestBody ListReqVO<Map<String, String>> listReqVO) {
        //从session获取用户信息
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        PageInfo pageInfo = null;

        Map<String, String> map = listReqVO.getCondition();
        if (map == null) {
            map = new HashMap<>();
            listReqVO.setCondition(map);
        }
        //判断用户是否是超级管理员
        if (sysRole.getType() == 1) {//如果是超级管理员，展示所有列表
            if (map.containsKey("channelRespUid")) {
                map.remove("channelRespUid");//移除负责人id，从而查询全部渠道
            }
            pageInfo = channelRecordService.selectForStartPageByMethod("selectUserLogList", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        } else if (sysRole.getType() == 3) {//渠道商
            map.put("channelRespUid", String.valueOf(sysUser.getUid()));
            pageInfo = channelRecordService.selectForStartPageByMethod("selectUserLogList", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        }
        if (pageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "订单统计列表")
    @RequestMapping(value = "/selectOrderLogGroupByChanelAndTime")
    @ResponseBody
    public ListResult selectOrderLogGroupByChanelAndTime(HttpServletRequest request, @RequestBody ListReqVO<Map<String, String>> listReqVO) {
        //从session获取用户信息
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        PageInfo pageInfo = null;

        Map<String, String> map = listReqVO.getCondition();
        if (map == null) {
            map = new HashMap<>();
            listReqVO.setCondition(map);
        }
        //判断用户是否是超级管理员
        if (sysRole.getType() == 1) {//如果是超级管理员，展示所有列表
            if (map.containsKey("channelRespUid")) {
                map.remove("channelRespUid");//移除负责人id，从而查询全部渠道
            }
            pageInfo = channelRecordService.selectForStartPageByMethod("selectOrderLogGroupByChanelAndTime", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        } else if (sysRole.getType() == 3) {//渠道商
            map.put("channelRespUid", String.valueOf(sysUser.getUid()));
            pageInfo = channelRecordService.selectForStartPageByMethod("selectOrderLogGroupByChanelAndTime", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        }
        if (pageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED);
    }
}

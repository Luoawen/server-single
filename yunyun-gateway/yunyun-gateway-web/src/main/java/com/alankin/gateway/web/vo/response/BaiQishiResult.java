package com.alankin.gateway.web.vo.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by alankin on 2018/12/31.
 */
public class BaiQishiResult extends Result {
    //    CCOM1000	成功	表示获取数据成功	解析data字段中的数据
//    CCOM3001	参数不合法	表示参数有问题，需要检查请求参数	检查参数，重新请求接口
//    CCOM3004	未获取到原始数据	1.实时原始数据查询：表示正在正在爬取，数据还未获取到；2.历史原始数据查询：表示用户无90天以前的历史数据	1.等待30s后重新请求该接口；
//    CCOM3010	请求过于频繁，请稍后再试	表示同一用户获取数据过于频繁	等待30s后重新请求该接口
//    CCOM3016	采集数据失败	表示该用户采集数据失败	需要用户重新授信
//    CCOM3017	用户未授权或授权失败	表示该用户未授信获取授信失败	需要用户授信或核对参数是否正确
//    CCOM3081	非法IP	表示商户IP校验不通过	联系白骑士工作人员，确认商户调用IP白名单状态
//    CCOM3083	调用权限不足	表示商户未开通资信云相关服务	联系白骑士工作人员，开通资信云相关服务
//    CCOM9999	资信云系统异常，请联系白骑士工作人员	表示资信云系统出现未知错误，需要联系资信云开发人员	联系工作人员，重新请求接口
    public BaiQishiResult(ResultConstant resultConstant, Object data) {
        super(resultConstant, data);
    }

    public BaiQishiResult(ResultConstant resultConstant) {
        super(resultConstant);
    }

    public BaiQishiResult(int code, String message) {
        super(code, message);
    }

    public static BaiQishiResult getBaiQishiResult(String baiqishiDataStr) {
        JSONObject jsonObject = JSON.parseObject(baiqishiDataStr);
        String resultCode = jsonObject.getString("resultCode");
        if ("CCOM1000".equalsIgnoreCase(resultCode)) {
            Map map = JSON.parseObject(jsonObject.getString("data"), Map.class);
            return new BaiQishiResult(ResultConstant.SUCCESS, map);
        } else if ("CCOM3001".equalsIgnoreCase(resultCode)) {
            return new BaiQishiResult(0, jsonObject.getString("resultDesc"));
        }
        return null;
    }
}

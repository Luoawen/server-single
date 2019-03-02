package com.alankin.gateway.web.vo.request;

import com.alankin.common.annotation.WhereLike;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "VerifyListReqVo", description = "审核人账号列表请求Vo")
public class VerifyListReqVo extends BaseReqVO {
    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户姓名")
    @WhereLike(dbFieldName = "real_name")
    private String realName;

    /**
     * 用户名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户名")
    @WhereLike(dbFieldName = "user_name")
    private String userName;

    /**
     * 分配状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分配状态")
    @WhereLike(dbFieldName = "user_role")
    private String userRole;

    /**
     * 账号状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "账号状态")
    @WhereLike(dbFieldName = "is_del")
    private String isDel;

    @Override
    public String toString() {
        return "ChannelAcountListReqVo{" +
                "realName='" + realName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

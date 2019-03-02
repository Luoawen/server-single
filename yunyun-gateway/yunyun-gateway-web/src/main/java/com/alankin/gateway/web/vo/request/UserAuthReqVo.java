package com.alankin.gateway.web.vo.request;

import com.alankin.gateway.web.utils.MsgCodeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * Created by alankin on 2018/12/30.
 */
@ApiModel(value = "UserAuthReqVo", description = "")
public class UserAuthReqVo extends BaseReqVO {
    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private String uid;

    /**
     * 用户昵称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户昵称", example = "摇尾巴的狗")
    private String nickName;

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名", example = "张三")
    @NotEmpty(message = "请输入姓名")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{2,4}$", message = "请输入正确姓名")
    private String userRealName;

    /**
     * 用户性别 0-female 1-male
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户性别", example = "true")
    private Boolean gender;

    /**
     * 用户生日
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户生日", example = "1111")
    private Long birthday;

    /**
     * 身份证号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证", example = "510000000000000000")
    @NotEmpty(message = "请填写身份证号")
    @Pattern(regexp = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)", message = "请输入正确的身份证号")
    private String idCard;

    /**
     * 用户个人签名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户个人签名", example = "我的个人签名")
    private String signature;

    /**
     * 邮箱(唯一)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮箱", example = "422222222@qq.com")
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 微信号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "微信号", example = "123456")
    private String wchatId;

    /**
     * 原图头像
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "原图头像", example = "")
    private String srcface;

    /**
     * 身份证正面照片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证正面照片", example = "")
    private Long idCardPhoto1;

    /**
     * 身份证背面照片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证背面照片", example = "")
    private Long idCardPhoto2;

    /**
     * 手持身份证照片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手持身份证照片", example = "")
    private Long idCardPhoto3;

    /**
     * 公司名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公司名称", example = "某某牛逼公司")
    private String companyName;

    /**
     * 公司地址
     *
     * @mbggenerated
     */
//    @ApiModelProperty(value = "公司地址")
//    private Long companyLocationUid;
    @ApiModelProperty(value = "公司地址省份")
    private String companyProvance;
    @ApiModelProperty(value = "公司地址城市")
    private String companyCity;
    @ApiModelProperty(value = "公司地址地区")
    private String companyArea;
    @ApiModelProperty(value = "公司具体地址")
    private String companyLocationDetail;

    /**
     * 公司联系方式
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公司联系方式", example = "11111")
    private String companyPhone;

    /**
     * 公司职位
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公司职位", example = "总经理")
    private String companyJob;

    /**
     * 工资
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "工资", example = "10000")
    private Integer salary;

    /**
     * 芝麻分
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "芝麻分", example = "666")
    private Integer aliScore;

    @Override
    public String toString() {
        return "UserAuthReqVo{" +
                "nickName='" + nickName + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", idCard='" + idCard + '\'' +
                ", signature='" + signature + '\'' +
                ", email='" + email + '\'' +
                ", wchatId='" + wchatId + '\'' +
                ", srcface='" + srcface + '\'' +
                ", idCardPhoto1=" + idCardPhoto1 +
                ", idCardPhoto2=" + idCardPhoto2 +
                ", idCardPhoto3=" + idCardPhoto3 +
                ", companyName='" + companyName + '\'' +
//                ", companyLocationUid=" + companyLocationUid +
                ", companyProvance='" + companyProvance + '\'' +
                ", companyCity='" + companyCity + '\'' +
                ", companyArea='" + companyArea + '\'' +
                ", companyLocationDetail='" + companyLocationDetail + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", companyJob='" + companyJob + '\'' +
                ", salary=" + salary +
                ", aliScore=" + aliScore +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCompanyProvance() {
        return companyProvance;
    }

    public void setCompanyProvance(String companyProvance) {
        this.companyProvance = companyProvance;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public String getCompanyArea() {
        return companyArea;
    }

    public void setCompanyArea(String companyArea) {
        this.companyArea = companyArea;
    }

    public String getCompanyLocationDetail() {
        return companyLocationDetail;
    }

    public void setCompanyLocationDetail(String companyLocationDetail) {
        this.companyLocationDetail = companyLocationDetail;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWchatId() {
        return wchatId;
    }

    public void setWchatId(String wchatId) {
        this.wchatId = wchatId;
    }

    public String getSrcface() {
        return srcface;
    }

    public void setSrcface(String srcface) {
        this.srcface = srcface;
    }

    public Long getIdCardPhoto1() {
        return idCardPhoto1;
    }

    public void setIdCardPhoto1(Long idCardPhoto1) {
        this.idCardPhoto1 = idCardPhoto1;
    }

    public Long getIdCardPhoto2() {
        return idCardPhoto2;
    }

    public void setIdCardPhoto2(Long idCardPhoto2) {
        this.idCardPhoto2 = idCardPhoto2;
    }

    public Long getIdCardPhoto3() {
        return idCardPhoto3;
    }

    public void setIdCardPhoto3(Long idCardPhoto3) {
        this.idCardPhoto3 = idCardPhoto3;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

//    public Long getCompanyLocationUid() {
//        return companyLocationUid;
//    }
//
//    public void setCompanyLocationUid(Long companyLocationUid) {
//        this.companyLocationUid = companyLocationUid;
//    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyJob() {
        return companyJob;
    }

    public void setCompanyJob(String companyJob) {
        this.companyJob = companyJob;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAliScore() {
        return aliScore;
    }

    public void setAliScore(Integer aliScore) {
        this.aliScore = aliScore;
    }
}

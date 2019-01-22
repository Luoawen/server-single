package com.zhicheng.echo.star.enums;

/**
 * 查询原因
 */
public enum ReasonEnum {

    LOAN_AUDIT("LOAN_AUDIT", "贷款审批"),

    LOAN_MANAGE("LOAN_MANAGE", "贷后管理"),

    CREDIT_CARD_AUDIT("CREDIT_CARD_AUDIT", "信用卡审批"),

    GUARANTEE_AUDIT("GUARANTEE_AUDIT", "担保资格审查"),

    PRE_GUARANTEE_AUDIT("PRE_GUARANTEE_AUDIT", "保前审查");

    private String type;

    private String value;

    ReasonEnum(String type,String value){
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}

package com.alankin.gateway.web.vo.thirdReq;

import com.alankin.gateway.web.vo.request.BaseReqVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by alankin on 2019/1/16.
 */
public class BaseSidReqVo extends BaseReqVO {
    @ApiModelProperty(value = "操作码")
    private String sid;

    @Override
    public String toString() {
        return "BaseSidReqVo{" +
                "sid='" + sid + '\'' +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}

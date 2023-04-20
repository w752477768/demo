package com.fsg.hps.auth.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName WechatAuthDTO
 * @Description TODO
 * @Author dxq
 * @Date 2023/4/18 10:02
 * @Version 1.0
 **/
@Data
public class WechatAuthVO {

    @ApiModelProperty(value = "小程序openid的code", required = true)
    private String openIdCode;


    @ApiModelProperty(value = "手机号", required = true)
    private String phone;

}

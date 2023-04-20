package com.fsg.hps.auth.dto;

import cn.hutool.core.codec.Base64;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName WechatAuthResponseDTO
 * @Description TODO
 * @Author dxq
 * @Date 2023/4/18 10:08
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WechatAuthResponseDTO {

    private String sessionKey;
    private String unionId;
    private String errorMsg;
    private String openId;
    private int errorCode;

    public WechatAuthResponseDTO(String sessionKey, String unionId, String openId) {
        this.sessionKey = sessionKey;
        this.unionId = unionId;
        this.openId = openId;
    }
}

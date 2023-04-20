package com.fsg.hps.auth.utils;

import com.alibaba.fastjson.JSONObject;
import com.fsg.hps.auth.constant.ResponseCodeConstants;
import com.fsg.hps.auth.dto.WechatAuthResponseDTO;
import com.fsg.hps.conf.okhttp.HttpClient;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import static com.fsg.hps.auth.constant.Constant.*;

@Slf4j
@Component
public class WechatUtil {

    @Value("${MiniClient.appid}")
    private String appId;
    @Value("${MiniClient.secret}")
    private String secret;
    @Value("${MiniClient.weChatLoginUrl}")
    private String weChatLoginUrl;


    @Autowired
    private HttpClient httpClient;

    public WechatAuthResponseDTO getOpenId(String code) {

        // 构造微信登录 API 请求 URL
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(weChatLoginUrl)
                .queryParam("appid", appId)
                .queryParam("secret", secret)
                .queryParam("js_code", code)
                .queryParam("grant_type", "authorization_code");

        // 调用微信登录 API，并获取响应结果
        Response response = httpClient.getResponse(weChatLoginUrl, builder.build().getQueryParams().toSingleValueMap());
        // 解析响应结果，构造 WechatAuthResponseDTO 对象
        JSONObject tokenObject = JSONObject.parseObject(String.valueOf(response.body()));
        String openId = tokenObject.getString("openid");
        if (openId.length() < 0) {
            // 如果有错误响应，返回错误信息
            throw new RuntimeException(ResponseCodeConstants.HPS_DELIVERY_HPS0004);
        }
        WechatAuthResponseDTO authResponse = new WechatAuthResponseDTO(tokenObject.getString(OPENID), tokenObject.getString(SESSION_KEY), tokenObject.getString(UNION_ID));
        // 返回包含 WechatAuthResponseDTO 对象的响应结果
        return authResponse;

    }

}

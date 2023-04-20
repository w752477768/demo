package com.fsg.hps.auth.controller;

import com.fsg.hps.auth.dto.ResponseDTO;
import com.fsg.hps.auth.vo.WechatAuthVO;
import com.fsg.hps.auth.service.WechatAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author dxq
 * @Date 2023/4/18 14:28
 * @Version 1.0
 **/
@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private WechatAuthService wechatAuthService;

    @ApiOperation(value = "小程序登录返回token")
    @PostMapping("/auth/login")
    public ResponseDTO weChatMiniLogin(@RequestBody WechatAuthVO wechatAuthVO, HttpServletRequest request) {
        return wechatAuthService.login(wechatAuthVO, request);
    }
}

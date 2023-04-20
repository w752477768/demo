package com.fsg.hps.auth.service;

import com.fsg.hps.auth.dto.ResponseDTO;
import com.fsg.hps.auth.vo.WechatAuthVO;

import javax.servlet.http.HttpServletRequest;

public interface WechatAuthService {
    ResponseDTO login(WechatAuthVO wechatAuthVO, HttpServletRequest request);
}

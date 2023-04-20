package com.fsg.hps.auth.service.impl;

import com.fsg.hps.auth.constant.ResponseCodeConstants;
import com.fsg.hps.auth.dao.model.CiamIdentityPO;
import com.fsg.hps.auth.dao.model.CiamLoginStatusPO;
import com.fsg.hps.auth.dto.ResponseDTO;
import com.fsg.hps.auth.dto.WechatAuthResponseDTO;
import com.fsg.hps.auth.infra.mysql.CiamIdentityRepository;
import com.fsg.hps.auth.infra.mysql.CiamLoginStatusRepository;
import com.fsg.hps.auth.infra.redis.RedisService;
import com.fsg.hps.auth.service.WechatAuthService;
import com.fsg.hps.auth.utils.JwtTokenUtil;
import com.fsg.hps.auth.utils.WechatUtil;
import com.fsg.hps.auth.vo.WechatAuthVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.fsg.hps.auth.constant.Constant.*;

/**
 * @ClassName WechatAuthService
 * @Description TODO
 * @Author dxq
 * @Date 2023/4/18 9:59
 * @Version 1.0
 **/
@Service
@Slf4j
public class WechatAuthServiceImpl implements WechatAuthService {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private WechatUtil wechatUtil;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisService redisService;
    @Autowired
    private CiamIdentityRepository ciamIdentityRepository;
    @Autowired
    private CiamLoginStatusRepository ciamLoginStatusRepository;


    /**
     * 调用微信登录 API，获取用户 openid 和 session_key
     *
     * @param code
     * @return
     */
    public ResponseDTO login(WechatAuthVO wechatAuthVO, HttpServletRequest request) {
        try {
            // 1. -------------------- 用code 换取openid-----------------
            WechatAuthResponseDTO responseDTO = wechatUtil.getOpenId(wechatAuthVO.getOpenIdCode());

            //2.-------------------- 判断手机号是否已注册(根据OpenId和phone 查询数据库)-------------------
            Optional<CiamIdentityPO> ciamIdentity = Optional.ofNullable(ciamIdentityRepository.getCiamIdentity(responseDTO.getOpenId(), wechatAuthVO.getPhone()))
                    .orElseGet(() -> ciamIdentityRepository.initCiamIdentity(responseDTO, wechatAuthVO.getPhone()));
            //生成token
            String token = jwtTokenUtil.createToken(responseDTO);

            //5.组装登录态PO，插入数据库
            CiamLoginStatusPO ciamLoginStatusPO = ciamLoginStatusRepository.saveCiamLoginStatus(ciamIdentity.get(), token);

            //6.存入redis
            redisService.putObject(WX_LOGIN + ciamLoginStatusPO.getSessionKey(), ciamLoginStatusPO, 10);

            Map<String, String> tokenMap = new HashMap<>();
            // 令牌
            tokenMap.put(TOKEN, token);
            // 头部信息
            tokenMap.put(TOKEN_HEAD, tokenHead);
            // 8.登录成功后将token返回给前端
            return ResponseDTO.newInstance(ResponseCodeConstants.HPS_DELIVERY_HPS0000, tokenMap);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return ResponseDTO.newInstance(ResponseCodeConstants.HPS_DELIVERY_HPS9999);
        }
    }
}

package com.fsg.hps.auth.utils;

import com.fsg.hps.auth.dto.WechatAuthResponseDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt处理Token工具类
 *
 * @author dxq
 * @date 2023/4/19
 */
@Component
public class JwtTokenUtil {

    /**
     * 秘钥
     */
    @Value("${jwt.secret}")
    private String secret;
    /**
     * token失效时间
     */
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 生成token
     *
     * @param openId     用户唯一标识
     * @param sessionKey 会话密钥
     * @return 生成的token
     */
    public String createToken(WechatAuthResponseDTO wechatAuthResponseDTO) {

        // 设置载荷
        Map<String, Object> payloadMap = new HashMap<>();
        payloadMap.put("openId", wechatAuthResponseDTO.getOpenId());
        payloadMap.put("sessionKey", wechatAuthResponseDTO.getSessionKey());

        // 生成token
        String token = Jwts.builder()
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                .setClaims(payloadMap)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();


        return token;
    }

    /**
     * 生成token失效时间
     *
     * @return token的失效时间
     */
    private Date generateExpirationDate() {
        // token失效时间：当前系统时间 + 自己定义的时间
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 获取openId
     *
     * @param token 待解析的token
     * @return openId
     */
    public String getOpenId(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

            return (String) claims.get("openId");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取sessionKey
     *
     * @param token 待解析的token
     * @return sessionKey
     */
    public String getSessionKey(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

            return (String) claims.get("sessionKey");
        } catch (Exception e) {
            return null;
        }
    }

    public static Date getExpirationDateFromToken(String token) {
        Claims claims = Jwts.parser()
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }

}

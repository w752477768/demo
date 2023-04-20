package com.fsg.hps.auth.infra.mysql;

import com.fsg.hps.auth.dao.model.CiamIdentityPO;
import com.fsg.hps.auth.dto.WechatAuthResponseDTO;

import java.util.Optional;

/**
 * @ClassName CiamIdentityRepositoryImpl
 * @Description TODO
 * @Author dxq
 * @Date 2023/4/19 20:12
 * @Version 1.0
 **/
public interface CiamIdentityRepository {

    Optional<CiamIdentityPO> getCiamIdentity(String openId,  String phone);

    Optional<CiamIdentityPO> initCiamIdentity(WechatAuthResponseDTO responseDTO, String phone);
}

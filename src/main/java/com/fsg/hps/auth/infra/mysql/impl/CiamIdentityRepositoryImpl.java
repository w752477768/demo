package com.fsg.hps.auth.infra.mysql.impl;

import com.fsg.hps.auth.dao.mapper.CiamIdentityMapper;
import com.fsg.hps.auth.dao.model.CiamIdentityPO;
import com.fsg.hps.auth.dto.WechatAuthResponseDTO;
import com.fsg.hps.auth.infra.factory.CiamIdentityPOFactory;
import com.fsg.hps.auth.infra.mysql.CiamIdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @ClassName CiamIdentityRepositoryImpl
 * @Description TODO
 * @Author dxq
 * @Date 2023/4/19 20:12
 * @Version 1.0
 **/
@Repository
public class CiamIdentityRepositoryImpl implements CiamIdentityRepository {

    @Autowired
    private CiamIdentityMapper ciamIdentityMapper;


    @Override
    public Optional<CiamIdentityPO> getCiamIdentity(String openId, String phone) {

        return Optional.ofNullable(ciamIdentityMapper.selectByOpenIdAndPhone(openId, phone))
                .orElse(null);
    }

    @Override
    public Optional<CiamIdentityPO> initCiamIdentity(WechatAuthResponseDTO responseDTO, String phone) {
        CiamIdentityPO ciamIdentityPO = CiamIdentityPOFactory.createCiamIdentityPO(responseDTO, phone);
        ciamIdentityMapper.insert(ciamIdentityPO);
        return Optional.of(ciamIdentityPO);
    }

}

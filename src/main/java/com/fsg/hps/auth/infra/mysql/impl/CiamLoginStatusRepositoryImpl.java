package com.fsg.hps.auth.infra.mysql.impl;

import com.fsg.hps.auth.dao.mapper.CiamLoginStatusMapper;
import com.fsg.hps.auth.dao.model.CiamIdentityPO;
import com.fsg.hps.auth.dao.model.CiamLoginStatusPO;
import com.fsg.hps.auth.infra.factory.CiamLoginStatusPOFactory;
import com.fsg.hps.auth.infra.mysql.CiamLoginStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @ClassName CiamLoginStatusRepositoryImpl
 * @Description TODO
 * @Author dxq
 * @Date 2023/4/19 20:30
 * @Version 1.0
 **/
@Repository
public class CiamLoginStatusRepositoryImpl  implements CiamLoginStatusRepository {

    @Autowired
    private CiamLoginStatusMapper ciamLoginStatusMapper;

    @Override
    public CiamLoginStatusPO saveCiamLoginStatus(CiamIdentityPO ciamIdentityPO, String token) {
        CiamLoginStatusPO ciamLoginStatusPO = CiamLoginStatusPOFactory.createCiamLoginStatusPO(ciamIdentityPO, token);
        ciamLoginStatusMapper.insert(ciamLoginStatusPO);
        return ciamLoginStatusPO;
    }
}

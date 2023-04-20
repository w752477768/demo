package com.fsg.hps.auth.infra.mysql;

import com.fsg.hps.auth.dao.model.CiamIdentityPO;
import com.fsg.hps.auth.dao.model.CiamLoginStatusPO;

public interface CiamLoginStatusRepository {

    CiamLoginStatusPO saveCiamLoginStatus(CiamIdentityPO ciamIdentityPO, String token);
}

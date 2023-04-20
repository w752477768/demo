package com.fsg.hps.auth.infra.factory;

import com.alibaba.fastjson.JSON;
import com.fsg.hps.auth.dao.model.CiamIdentityPO;
import com.fsg.hps.auth.dao.model.CiamLoginStatusPO;

import java.util.Date;

import static com.fsg.hps.auth.constant.Constant.ADMIN;
import static com.fsg.hps.auth.utils.JwtTokenUtil.getExpirationDateFromToken;

/**
 * @ClassName CiamLoginStatusPOFactory
 * @Description TODO
 * @Author dxq
 * @Date 2023/4/20 13:41
 * @Version 1.0
 **/
public class CiamLoginStatusPOFactory {


    public static CiamLoginStatusPO createCiamLoginStatusPO(CiamIdentityPO ciamIdentityPO,String token ) {
        CiamLoginStatusPO ciamLoginStatusPO = new CiamLoginStatusPO();
        Date date = new Date();
        ciamLoginStatusPO.setJwtToken(token);
        ciamLoginStatusPO.setSessionKey(ciamLoginStatusPO.getSessionKey());
        ciamLoginStatusPO.setIdentityInfo(JSON.toJSONString(new CiamIdentityPO(ciamIdentityPO.getMobileNo(),ciamIdentityPO.getOpenId())));
        ciamLoginStatusPO.setExpireTime(getExpirationDateFromToken(token));
        ciamLoginStatusPO.setCreator(ADMIN);
        ciamLoginStatusPO.setCreatorName(ADMIN);
        ciamLoginStatusPO.setCreateTime(date);
        ciamLoginStatusPO.setUpdater(ADMIN);
        ciamLoginStatusPO.setUpdaterName(ADMIN);
        ciamLoginStatusPO.setUpdateTime(date);
        return ciamLoginStatusPO;
    }


}

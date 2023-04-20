package com.fsg.hps.auth.infra.factory;

import com.fsg.hps.auth.dao.model.CiamIdentityPO;
import com.fsg.hps.auth.dto.WechatAuthResponseDTO;

import java.util.Date;

import static com.fsg.hps.auth.constant.Constant.ADMIN;

/**
 * @ClassName CiamIdentityPOFactory
 * @Description TODO
 * @Author dxq
 * @Date 2023/4/20 13:41
 * @Version 1.0
 **/
public class CiamIdentityPOFactory {

    public static CiamIdentityPO createCiamIdentityPO(WechatAuthResponseDTO responseDTO, String phone) {
        CiamIdentityPO ciamIdentityPO = new CiamIdentityPO();
        Date date = new Date();
        ciamIdentityPO.setMobileNo(phone);
        ciamIdentityPO.setOpenId(responseDTO.getOpenId());
        ciamIdentityPO.setCreator(ADMIN);
        ciamIdentityPO.setCreatorName(ADMIN);
        ciamIdentityPO.setCreateTime(date);
        ciamIdentityPO.setUpdater(ADMIN);
        ciamIdentityPO.setUpdaterName(ADMIN);
        ciamIdentityPO.setUpdateTime(date);
        return ciamIdentityPO;
    }
}

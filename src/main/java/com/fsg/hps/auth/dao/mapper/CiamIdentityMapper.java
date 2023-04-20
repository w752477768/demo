package com.fsg.hps.auth.dao.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fsg.hps.auth.dao.model.CiamIdentityPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * @ClassName TicketMapper
 * @Description TODO
 * @Author zhensen.ding
 * @Date 4/6/2023 1:33 PM
 * @Version 1.0
 */
@Mapper
@InterceptorIgnore(illegalSql = "1")
public interface CiamIdentityMapper extends BaseMapper<CiamIdentityPO> {


    Optional<CiamIdentityPO> selectByOpenIdAndPhone(@Param("openId") String openId, @Param("phone") String phone);
}

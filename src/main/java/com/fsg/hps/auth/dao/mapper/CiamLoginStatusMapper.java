package com.fsg.hps.auth.dao.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fsg.hps.auth.dao.model.CiamLoginStatusPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName TicketMapper
 * @Description TODO
 * @Author zhensen.ding
 * @Date 4/6/2023 1:33 PM
 * @Version 1.0
 */
@Mapper
@InterceptorIgnore(illegalSql = "1")
public interface CiamLoginStatusMapper extends BaseMapper<CiamLoginStatusPO> {

}

package com.fsg.hps.auth.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName CiamLoginStatusPO
 * @Description TODO
 * @Author dxq
 * @Date 2023/4/19 10:45
 * @Version 1.0
 **/
@Data
@ApiModel("登录状态")
public class CiamLoginStatusPO implements Serializable {

    /**
     登录态主键
     */
    @TableId(type= IdType.ASSIGN_ID)
    private String id;
    /**
     登录凭证
     */
    private String jwtToken;
    /**
     微信登录密钥
     */
    private String sessionKey;
    /**
     身份信息
     */
    private Object identityInfo;
    /**
     过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expireTime;
    /**
     创建人姓名
     */
    private String creatorName;
    /**
     创建人编码
     */
    private String creator;
    /**
     创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     修改人姓名
     */
    private String updaterName;
    /**
     修改人编码
     */
    private String updater;
    /**
     修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}

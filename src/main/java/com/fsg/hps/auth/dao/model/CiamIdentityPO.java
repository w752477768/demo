package com.fsg.hps.auth.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName CiamLoginStatusPO
 * @Description TODO
 * @Author dxq
 * @Date 2023/4/19 10:45
 * @Version 1.0
 **/
@Data
@ApiModel("身份信息")
@NoArgsConstructor
public class CiamIdentityPO {

    /**
     * 主键
     */
    @TableId(type= IdType.ASSIGN_ID)
    private String id;
    /**
     * 手机号
     */
    private String mobileNo;
    /**
     * 身份证号
     */
    private String identityCard;
    /**
     * openID
     */
    private String openId;
    /**
     * 创建人姓名
     */
    private String creatorName;
    /**
     * 创建人编码
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人姓名
     */
    private String updaterName;
    /**
     * 修改人编码
     */
    private String updater;
    /**
     * 修改时间
     */
    private Date updateTime;



    public CiamIdentityPO(String mobileNo, String openId) {
        this.mobileNo = mobileNo;
        this.openId = openId;
    }
}

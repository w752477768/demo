package com.fsg.hps.auth.constant;

public class ResponseCodeConstants {

    private ResponseCodeConstants(){}

    /** FSG NCP HPS BFF使用返回值Code */
    public static final String NCP_BFF_NCP9001 = "NCP9001";
    public static final String NCP_BFF_NCP9002 = "NCP9002";
    public static final String NCP_BFF_NCP9003 = "NCP9003";
    public static final String NCP_BFF_NCP9004 = "NCP9004";
    public static final String NCP_BFF_NCP9999 = "NCP9999";
    public static final String NCP_BFF_NCP0000 = "NCP0000";    //成功
    public static final String NCP_BFF_NCP0001 = "NCP0001";    //失败
    public static final String NCP_BFF_NCP0002 = "NCP0002";    // PDF文件路径不存在
    public static final String NCP_BFF_NCP0003 = "NCP0003";    // 参数解析超时
    public static final String NCP_BFF_NCP0004 = "NCP0004";    // IO异常

    /** FSG HPS SERVICE使用返回值Code */
    public static final String HPS_DELIVERY_HPS9001 = "HPS9001";
    public static final String HPS_DELIVERY_HPS9002 = "HPS9002";
    public static final String HPS_DELIVERY_HPS9003 = "HPS9003";
    public static final String HPS_DELIVERY_HPS9004 = "HPS9004";
    public static final String HPS_DELIVERY_HPS9999 = "HPS9999";
    public static final String HPS_DELIVERY_HPS0000 = "HPS0000";    //成功
    public static final String HPS_DELIVERY_HPS0001 = "HPS0001";    //失败
    public static final String HPS_DELIVERY_HPS0002 = "HPS0002";    // PDF文件路径不存在
    public static final String HPS_DELIVERY_HPS0003 = "HPS0003";    // 参数解析超时
    public static final String HPS_DELIVERY_HPS0004 = "HPS0004";    // IO异常



}

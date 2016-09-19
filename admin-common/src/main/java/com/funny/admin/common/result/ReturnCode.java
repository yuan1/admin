package com.funny.admin.common.result;

/**
 * Created by funny on 16/9/19.
 */
public class ReturnCode {
// ---------------------------公共异常----------------------
    /** 系统内部异常 **/
    public static final int SERVICE_ERROR = 500;

    /** 缺少必填参数 **/
    public static final int MISSIN_MUST_PARAMS = 100;

    /** 参数不合法 **/
    public static final int PARAMS_IS_NOT_VALID = 200;

    /** 业务异常 **/
    public static final int BUSINESS_VALID = 300;

    /** 调用远程服务异常 **/
    public static final int RPC_ERROR = 400;
}

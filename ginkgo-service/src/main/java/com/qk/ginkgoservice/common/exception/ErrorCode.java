package com.qk.ginkgoservice.common.exception;

/**
 * 通用错误码,用于Exception
 * @author zhangyu
 * @data 2018/7/15
 */
public enum ErrorCode{
    /**
     *  OK
     */
    OK(0, ""),
    /**
     *  操作失败
     */
    FAIL(-1, "操作失败"),
    /**
     *  远程调度失败
     */
    RPC_ERROR(-2,"远程调度失败"),
    /**
     * 用户名或密码为空
     * */
    EMPTY_USERNAME_PASSWORD(-3,"请输入用户名和密码"),
    /**
     * 用户名或密码为空
     * */
    NOT_LOGINED(-4,"未登录或登录超时"),
    /**
     * 请求时Header中缺失Authorization或USERNAME
     * */
    HEADER_NO_AUTHORIZATION_USERNAME(-5,"请求时Header中缺失Authorization或USERNAME"),
    /**
     *  用户不存在
     */
    USER_NOT_FOUND(1000,"用户不存在"),
    /**
     *  密码错误
     */
    USER_PASSWORD_ERROR(1001,"密码错误"),
    /**
     * 获取token失败
     */
    GET_TOKEN_FAIL(1002,"获取token失败"),
    /**
     * 请使用自己的token进行接口请求
     */
    TOKEN_IS_NOT_MATCH_USER(1003,"请使用自己的token进行接口请求"),
    /**
     *  该博客不存在
     */
    BLOG_IS_NOT_EXIST(2001,"该博客不存在");

    private int code;
    private String msg;


    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ErrorCode codeOf(int code) {
        for (ErrorCode state : values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        return null;
    }
}

package com.qk.ginkgoservice.common.exception;

/**
 * 通用提示类，用于返回数据时的提示
 * @author fuxuelong
 */
public enum MessageCode {
    /**
     *  登录成功
     */
    LOGIN_SUCCESS(0, "登录成功"),
    /**
     *查询成功
     * */
    SEARCH_SUCCESS(2, "查询成功"),
    /**
     * token有效
     * */
    VALID_TOKEN(3,"token有效"),
    /**
     * token无效
     * */
    INVALID_TOKEN(-3,"token无效"),
    /**
     * 保存成功
     * */
    SAVE_SUCCESS(4,"保存成功"),
    /**
     * 极光推送推送成功
     * */
    JIGUANG_PUSH_SUCCESS(5,"推送成功"),
    /**
     * 极光推送失败
     * */
    JIGUANG_PUSH_FAILD(5,"推送失败")
    ;
    private int code;
    private String msg;
    MessageCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static MessageCode codeOf(int code) {
        for (MessageCode state : values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        return null;
    }
}

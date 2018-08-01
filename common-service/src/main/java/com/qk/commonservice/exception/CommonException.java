package com.qk.commonservice.exception;


/**
 * @author zhangyu
 * @data 2018/7/15
 */
public class CommonException extends RuntimeException {

    private ErrorCode errorCode;
    private String message ="";


    public CommonException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.message = "ggg";
        this.errorCode = errorCode;
    }

    public CommonException(ErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }


    public int getCode() {
        return errorCode.getCode();
    }

    public String getMsg() {
        return errorCode.getMsg();
    }

}

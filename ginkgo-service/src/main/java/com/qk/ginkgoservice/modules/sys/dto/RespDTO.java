package com.qk.ginkgoservice.modules.sys.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qk.ginkgoservice.common.constant.Constant;
import com.qk.ginkgoservice.common.exception.ErrorCode;
import com.qk.ginkgoservice.common.exception.MessageCode;

import java.io.Serializable;

/**
 *
 * 数据传输类
 * @author fuxuelong
 * @data 2018/7/13
 */
public class RespDTO<T> implements Serializable{

    /**数据返回状态代码*/
    public int code;
    /**数据传输提示信息*/
    public String message;
    public MessageCode messageCode;
    public ErrorCode errorCode;

    public RespDTO(){
        this.messageCode = messageCode;
    }
    public RespDTO(MessageCode messageCode){
        this.setMessageCode(messageCode);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T data;

    public static RespDTO onSuc(Object data) {
        RespDTO resp = new RespDTO();
        resp.data = data;
        return resp;
    }

    @Override
    public String toString() {
        return "RespDTO{" +
                "code=" + code + ';' +
                ", message='" + message + ';' +
//                ", data=" + data +
                '}';
    }

    @JsonIgnore
    public MessageCode getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(MessageCode messageCode) {
        this.code = messageCode.getCode();
        this.message = messageCode.getMsg();
    }
}

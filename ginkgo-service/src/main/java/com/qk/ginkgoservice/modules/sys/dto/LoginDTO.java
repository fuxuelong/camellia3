package com.qk.ginkgoservice.modules.sys.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qk.ginkgoservice.common.exception.MessageCode;
import com.qk.ginkgoservice.modules.sys.entity.User;

import java.io.Serializable;

/**
 * @author fuxuelong
 * @data 2018/7/25
 */
public class LoginDTO<T> implements Serializable {
    private int code;
    private String username;
    private String token;
    private String message;
    private MessageCode messageCode;

    public LoginDTO(MessageCode messageCode){
        this.setMessageCode(messageCode);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

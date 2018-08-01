package com.qk.userservice.service;

import com.qk.userservice.entity.JWT;
import org.springframework.stereotype.Component;

/**
 * @author zhangyu
 * @data 2018/7/14
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient{

    /**
     * 获取token的熔断方法
     * @param authorization
     * @param type
     * @param username
     * @param password
     * @return
     */
    @Override
    public JWT getToken(String authorization, String type,
                        String username, String password){
        System.out.println(authorization+"------"+type+"-------"+username+"------"+password);
        return null;
    }
}

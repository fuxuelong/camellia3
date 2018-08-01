package com.qk.userservice.service;


import com.qk.userservice.entity.JWT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhangyu
 * @data 2018/7/14
 */
@FeignClient(value = "uaa-server",fallback = AuthServiceHystrix.class)
public interface AuthServiceClient {

    /**
     * 获取token
     * @param authorization
     * @param type
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/oauth/token")
    JWT getToken(
            @RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type,
            @RequestParam("username") String username,
            @RequestParam("password") String password);

}

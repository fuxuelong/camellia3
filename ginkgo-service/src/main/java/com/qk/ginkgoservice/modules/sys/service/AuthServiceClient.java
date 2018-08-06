package com.qk.ginkgoservice.modules.sys.service;


import com.qk.ginkgoservice.modules.sys.entity.JWT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "uaa-ginkgoapp-server",fallback = AuthServiceHystrix.class)
public interface AuthServiceClient {
    @PostMapping(value = "/oauth/token")
    JWT getToken(
            @RequestHeader(value = "Authorization") String authorization,
            @RequestParam("grant_type") String type,
            @RequestParam("username") String username,
            @RequestParam("password") String password);
    /**
     * 刷新token
     */
    @PostMapping(value = "/oauth/token")
    JWT refreshToken( @RequestHeader(value = "Authorization") String authorization,
                      @RequestParam("grant_type") String type,
                      @RequestParam("refresh_token") String refresh_token);
}

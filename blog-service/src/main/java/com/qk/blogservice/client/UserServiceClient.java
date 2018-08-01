package com.qk.blogservice.client;


import com.qk.blogservice.client.hystrix.UserServiceHystrix;
import com.qk.blogservice.entity.User;
import com.qk.commonservice.dto.RespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;


/**
 * @author Zhy
 * @date 2018/7/24
 * @description 
 */
@FeignClient(value = "user-service",fallback = UserServiceHystrix.class )
public interface UserServiceClient {

    /**
     * 获取用户
     * @param token
     * @param username
     * @return
     */
    @PostMapping(value = "/user/{username}")
    RespDTO<User> getUser(@RequestHeader(value = "Authorization") String token,
                          @PathVariable("username") String username);
}




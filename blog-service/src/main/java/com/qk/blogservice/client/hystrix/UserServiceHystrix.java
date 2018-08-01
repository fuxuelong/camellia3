package com.qk.blogservice.client.hystrix;


import com.qk.blogservice.client.UserServiceClient;
import com.qk.blogservice.entity.User;
import com.qk.commonservice.dto.RespDTO;
import org.springframework.stereotype.Component;

/**
 * @author Zhy
 * @date 2018/7/24
 * @description 
 */
@Component
public class UserServiceHystrix implements UserServiceClient {

    @Override
    public RespDTO<User> getUser(String token, String username) {
        System.out.println(token);
        System.out.println(username);
        return null;
    }
}

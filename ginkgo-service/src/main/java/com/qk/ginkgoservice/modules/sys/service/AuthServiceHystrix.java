package com.qk.ginkgoservice.modules.sys.service;

import com.qk.ginkgoservice.modules.sys.entity.JWT;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceHystrix implements AuthServiceClient{
    @Override
    public JWT getToken(String authorization, String type,
                        String username, String password){
        System.out.println(authorization+"------"+type+"-------"+username+"------"+password);
        return null;
    }

    @Override
    public JWT refreshToken(String authorization, String type, String refresh_token) {
        return null;
    }
}

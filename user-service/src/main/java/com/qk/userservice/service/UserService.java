package com.qk.userservice.service;


import com.qk.commonservice.dto.RespDTO;
import com.qk.commonservice.exception.CommonException;
import com.qk.commonservice.exception.ErrorCode;
import com.qk.userservice.dao.UserDao;
import com.qk.userservice.dto.LoginDTO;
import com.qk.userservice.entity.JWT;
import com.qk.userservice.entity.User;
import com.qk.userservice.utils.BPwdEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu
 * @data 2018/7/14
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    AuthServiceClient authServiceClient;
    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 注册新用户
     * @param user
     */
    public void createUser(User user){
        userDao.save(user);
    }

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    public User getUserInfo(String username){
        return userDao.findByUsername(username);
    }

    /**
     * 登录的处理逻辑
     * @param username
     * @param password
     * @return
     */
    public RespDTO login(HttpServletRequest request, HttpServletResponse response, String username , String password){
        User user= userDao.findByUsername(username);
        if(null==user){
            throw new CommonException(ErrorCode.USER_NOT_FOUND);
        }
        if(!BPwdEncoderUtils.matches(password,user.getPassword())){
            throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
        }

        JWT jwt = authServiceClient.getToken("Basic dXNlci1zZXJ2aWNlOnFreHNANjQ2OQ==", "password", username, password);
        System.out.println(username+"----------"+password+"----------"+jwt);

        // 获得用户菜单
        if(null==jwt){
            throw new CommonException(ErrorCode.GET_TOKEN_FAIL);
        }

        LoginDTO loginDTO=new LoginDTO();
        loginDTO.setUser(user);
        loginDTO.setToken(jwt.getAccess_token());

        /**
         * JWT存到Redis缓存中
         */
        redisTemplate.opsForValue().set(username,jwt.getAccess_token(),300,TimeUnit.SECONDS);
        /**
         * 设置cookie
         */
        Cookie jwtCookie = new Cookie("access_token", jwt.getAccess_token());
        jwtCookie.setMaxAge(3600);
        jwtCookie.setDomain(request.getServerName());
        jwtCookie.setPath("/");
        response.addCookie(jwtCookie);

        System.out.println("==="+request.getServerName());
        return RespDTO.onSuc(loginDTO);
    }
}

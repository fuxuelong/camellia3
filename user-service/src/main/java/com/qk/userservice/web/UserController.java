package com.qk.userservice.web;



import com.alibaba.fastjson.JSONObject;
import com.qk.commonservice.annotation.SysLogger;
import com.qk.commonservice.dto.RespDTO;
import com.qk.commonservice.utils.UserUtils;
import com.qk.userservice.entity.JWT;
import com.qk.userservice.entity.User;
import com.qk.userservice.service.UserService;
import com.qk.userservice.utils.BPwdEncoderUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangyu
 * @data 2018/7/14
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @ApiOperation(value = "注册", notes = "username和password为必选项")
    @PostMapping("/registry")
    @SysLogger("registry")
    public User createUser( String username, String password){
        //参数判读省略,判读该用户在数据库是否已经存在省略
        User user = new User();
        String entryPassword= BPwdEncoderUtils.BCryptPassword(password);
        user.setUsername(username);
        user.setPassword(entryPassword);
        userService.createUser(user);
        return user;
    }

    @ApiOperation(value = "登录", notes = "username和password为必选项")
    @RequestMapping("/login")
//    @SysLogger("login")
    public RespDTO login(HttpServletRequest request, HttpServletResponse response, @RequestParam String username , @RequestParam String password){
        //参数判读省略
        return userService.login(request,response,username,password) ;
    }

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    @ApiOperation(value = "根据用户名获取用户", notes = "根据用户名获取用户")
    @RequestMapping("/{username}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @SysLogger("getUserInfo")
    public RespDTO getUserInfo(@PathVariable("username") String username){
        //参数判读省略
        User user=  userService.getUserInfo(username);
        return RespDTO.onSuc(user);
    }

    @RequestMapping("user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Authentication getUser(Authentication user){
        return user;
    }

    @GetMapping("test")
    public String getUserPrincipal(Authentication user){
        return UserUtils.getCurrentPrinciple();
    }

}

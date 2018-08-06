package com.qk.ginkgoservice.modules.sys.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qk.commonservice.annotation.SysLogger;
import com.qk.ginkgoservice.common.constant.Constant;
import com.qk.ginkgoservice.common.exception.MessageCode;
import com.qk.ginkgoservice.modules.sys.dto.LoginDTO;
import com.qk.ginkgoservice.modules.sys.dto.RespDTO;
import com.qk.ginkgoservice.modules.sys.entity.User;
import com.qk.ginkgoservice.modules.sys.service.UserService;
import com.qk.ginkgoservice.modules.sys.utils.BPwdEncoderUtils;
import com.qk.ginkgoservice.modules.sys.utils.UserUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.server.reactive.ServerHttpRequest;

import javax.servlet.http.HttpServletRequest;


/**
 * @author fuxuelong
 */
@RestController
@RequestMapping("/user")
@CacheConfig(cacheNames = Constant.GINKGO_USER_annotation_PREFIX)
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @ApiOperation(value = "根据用户名获取用户", notes = "userName为必选项,返回user的json串")
    @PostMapping(value = "/getUserByUserName")
    public String getUserByUsername(String userName){
        User user = userService.getUserByUserName(userName);
        return JSONObject.toJSONString(user);
    }

    /**
     * 根据用户登录名更新用户,调用前先从redis中将用户删除
     * */
    @PostMapping(value = "/save")
    public RespDTO<Object> save(User user,String userName){
        User user1 = userService.getUserByUserName(userName);
        user1.setRemarks(user.getRemarks());
        userService.saveUser(user1);
        return new RespDTO<Object>(MessageCode.SAVE_SUCCESS);
    }


    @ApiOperation(value = "注册", notes = "userName和password为必选项")
    @PostMapping("/registry")
    @SysLogger("registry")
    public User createUser(String userName, String password){
        //参数判读省略,判读该用户在数据库是否已经存在省略
        User user = new User();
        String entryPassword= BPwdEncoderUtils.BCryptPassword(password);
        user.setUserName(userName);
        user.setPassword(entryPassword);
        userService.save(user);
        return user;
    }

    @ApiOperation(value = "登录", notes = "userName和password为必选项")
    @PostMapping("/login")
    @SysLogger("login")
    public LoginDTO login(@RequestParam String userName , @RequestParam String password){
        //参数判读省略
        return   userService.login(userName,password);
    }
    @ApiOperation(value = "刷新token", notes = "")
    @PostMapping("/refreshToken")
    @SysLogger("refreshToken")
    public LoginDTO refreshToken(@RequestParam String userName , @RequestParam String refresh_token){
        //参数判读省略
        return   userService.refreshToken(userName,refresh_token);
    }



    @ApiOperation(value = "根据用户名获取用户", notes = "根据用户名获取用户")
    @PostMapping("/{userName}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @SysLogger("getUserInfo")
    // @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public RespDTO getUserInfo(@PathVariable("userName") String userName){
        //参数判读省略
        User user=  userService.getUserInfo(userName);
        return RespDTO.onSuc(user);
    }

}

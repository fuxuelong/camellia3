package com.qk.ginkgoservice.modules.sys.service;


import com.qk.ginkgoservice.common.exception.CommonException;
import com.qk.ginkgoservice.common.exception.ErrorCode;
import com.qk.ginkgoservice.common.exception.MessageCode;
import com.qk.ginkgoservice.common.persistence.CrudService;
import com.qk.ginkgoservice.common.constant.Constant;
import com.qk.ginkgoservice.modules.sys.dao.RoleDao;
import com.qk.ginkgoservice.modules.sys.dao.UserDao;
import com.qk.ginkgoservice.modules.sys.dto.LoginDTO;
import com.qk.ginkgoservice.modules.sys.entity.JWT;
import com.qk.ginkgoservice.modules.sys.entity.Role;
import com.qk.ginkgoservice.modules.sys.entity.User;
import com.qk.ginkgoservice.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author fuxuelong
 * @date 2017/7/10
 */
@Service
@CacheConfig(cacheNames = Constant.GINKGO_USER_annotation_PREFIX)
@Transactional(readOnly = true)
public class UserService extends CrudService<UserDao,User> {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    AuthServiceClient authServiceClient;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate ;
    private String GINKGO_JWT_PREFIX = "ginkgo_";
    /**
     *根据用户名获取用户，并将用户信息缓存到redis中,key为用户登录名。
     *返回值为空时，不进行缓存
     * */
    @Cacheable(unless = "#result==null")
    public User getUserByUserName(String userName){
        System.out.println("从数据库获取user");
        User user = userDao.findUserByUserName(userName);
        if (user==null){
            return null;
        }
        user.setRoleList(roleDao.findList(new Role(user)));
        return  user;
    }

    /**
     * 保存用户，用户信息变化将缓存清除
     * @param user
     * */
    @Transactional(readOnly = false)
    @CacheEvict(key = "#user.userName")
    public void saveUser(User user){
        super.save(user);
    }

    public User getUserInfo(String username){
        return userDao.findUserByUserName(username);
    }

    public LoginDTO login(String username , String password){
        User user= userDao.findUserByUserName(username);
        if(null==user){
            throw new CommonException(ErrorCode.USER_NOT_FOUND);
        }

        if(!UserUtils.validatePassword(password,user.getPassword())){
            throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
        }

        JWT jwt = authServiceClient.getToken("Basic Z2lua2dvLXNlcnZpY2U6cWt4c0A2NDY5", "password", username, password);
        // 获得用户菜单
        if(null==jwt){
            throw new CommonException(ErrorCode.GET_TOKEN_FAIL);
        }
        LoginDTO loginDTO=new LoginDTO(MessageCode.LOGIN_SUCCESS);
        loginDTO.setUsername(user.getUserName());
        loginDTO.setToken(jwt.getAccess_token());
        long validMillis = System.currentTimeMillis()
                + (Integer.toUnsignedLong(jwt.getExpires_in())*1000);
        Date date = new Date();
        date.setTime(validMillis);
        System.out.println(date);

        redisTemplate.opsForValue().set(Constant.GINKGO_JWT_REDISTEMP_PREFIX + username , jwt,Constant.JWT_CACHE_LIVE_TIME,TimeUnit.SECONDS);
        return loginDTO;
    }
}

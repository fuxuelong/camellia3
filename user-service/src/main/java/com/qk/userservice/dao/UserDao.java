package com.qk.userservice.dao;


import com.qk.userservice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhangyu
 * @data 2018/7/14
 */
@Component
@Mapper
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     */
    void save(User user);
}

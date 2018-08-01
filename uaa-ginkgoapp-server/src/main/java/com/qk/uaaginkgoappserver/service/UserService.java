package com.qk.uaaginkgoappserver.service;

import com.qk.uaaginkgoappserver.dao.UserDao;
import com.qk.uaaginkgoappserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }
}

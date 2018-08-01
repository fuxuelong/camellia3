package com.qk.uaaserver.service;


import com.qk.commonservice.service.CrudService;
import com.qk.uaaserver.dao.UserDao;
import com.qk.uaaserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Service
public class UserService extends CrudService<UserDao, User> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username){
        return dao.findByUsername(username);
    }
}

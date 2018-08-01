package com.qk.uaaserver.dao;

import com.qk.commonservice.dao.CrudDao;
import com.qk.uaaserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Component
@Mapper
public interface UserDao extends CrudDao<User> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);
}

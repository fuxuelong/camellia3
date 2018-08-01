package com.qk.uaaginkgoappserver.dao;

import com.qk.commonservice.dao.CrudDao;
import com.qk.uaaginkgoappserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Component
@Mapper
public interface UserDao {

    User findByUsername(String username);
}

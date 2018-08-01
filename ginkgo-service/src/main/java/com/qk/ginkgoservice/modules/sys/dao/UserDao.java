package com.qk.ginkgoservice.modules.sys.dao;


import com.qk.ginkgoservice.common.persistence.CrudDao;
import com.qk.ginkgoservice.modules.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author fuxuelong
 */
@Component
@Mapper
public interface UserDao extends CrudDao<User> {
    /**
     * 根据用户名获取user
     * @param  userName
     * @return User
     * */
    User findUserByUserName(@Param("userName") String userName);

    void save(User user);
}

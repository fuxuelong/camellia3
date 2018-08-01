package com.qk.uaaserver.dao;

import com.qk.commonservice.dao.CrudDao;
import com.qk.uaaserver.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Mapper
@Component
public interface RoleDao extends CrudDao<Role> {

    /**
     * 查询用户的权限信息
     * @param userId
     * @return
     */
    List<Role> findAuthoritiesByUser(String userId);
}

package com.qk.uaaginkgoappserver.dao;

import com.qk.commonservice.dao.CrudDao;
import com.qk.uaaginkgoappserver.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Mapper
@Component
public interface RoleDao {

    List<Role> findAuthoritiesByUser(String userId);
}

package com.qk.uaaserver.service;

import com.qk.commonservice.service.CrudService;
import com.qk.uaaserver.dao.RoleDao;
import com.qk.uaaserver.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Service
public class RoleService extends CrudService<RoleDao, Role> {
    /**
     * 查询用户的权限信息
     * @param userId
     * @return
     */
    public List<Role> findAuthoritiesByUser(String userId) {
        return dao.findAuthoritiesByUser(userId);
    }
}

package com.qk.uaaginkgoappserver.service;

import com.qk.uaaginkgoappserver.dao.RoleDao;
import com.qk.uaaginkgoappserver.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> findAuthoritiesByUser(String userId) {
        return roleDao.findAuthoritiesByUser(userId);
    }
}

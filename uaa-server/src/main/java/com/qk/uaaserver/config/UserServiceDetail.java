package com.qk.uaaserver.config;



import com.qk.uaaserver.entity.Role;
import com.qk.uaaserver.entity.User;
import com.qk.uaaserver.service.RoleService;
import com.qk.uaaserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Service
public class UserServiceDetail implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user != null) {
            //获取该用户对应的所有权限
            List<Role> authorities = roleService.findAuthoritiesByUser(user.getId() + "");
            //保存当前登录用户的所有的权限名称
            List<Role> grantedAuthorities = new ArrayList<>();
            if (authorities != null && authorities.size() > 0) {
                for (Role r : authorities) {
                    if (r.getName() != null && r.getName() != "") {
                        Role role = new Role(r.getName());
                        grantedAuthorities.add(role);
                    }
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }else {
            throw new UsernameNotFoundException("user: " + username + " do not exist!");
        }
    }
}

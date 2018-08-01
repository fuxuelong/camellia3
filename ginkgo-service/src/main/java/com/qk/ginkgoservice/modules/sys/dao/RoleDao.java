package com.qk.ginkgoservice.modules.sys.dao; /**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */

import java.util.List;

import com.qk.ginkgoservice.common.persistence.CrudDao;
import com.qk.ginkgoservice.modules.sys.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


/**
 * @author fuxuelong
 */
@Component
@Mapper
public interface RoleDao extends CrudDao<Role> {

    /**
     * @param role
     * @return
     */
    @Override
    List<Role> findList(Role role);

    /**
     * @param role
     * @return
     */
    Role getByName(Role role);

    /**
     * @param role
     * @return
     */
    Role getByEnname(Role role);

    /**
     * 维护角色与菜单权限关系
     * 
     * @param role
     * @return
     */
    public int deleteRoleMenu(Role role);

    public int insertRoleMenu(Role role);

    /**
     * 维护角色与公司部门关系
     * 
     * @param role
     * @return
     */
    public int deleteRoleOffice(Role role);

    public int insertRoleOffice(Role role);

    public List<Role> findAllListForNormalUser(Role role);// 普通用户查看角色权限时用

}

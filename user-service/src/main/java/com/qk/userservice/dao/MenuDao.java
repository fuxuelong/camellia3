package com.qk.userservice.dao;

import com.qk.commonservice.dao.CrudDao;
import com.qk.userservice.entity.Menu;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 菜单
 * @author zhangyu
 * @data 2018/7/19
 */
@Component
@Mapper
public interface MenuDao extends CrudDao<Menu> {

    /**
     * 根据用户名查询用户权限
     * @param username
     * @return
     */
    List<Menu> findByUsername(String username);
}

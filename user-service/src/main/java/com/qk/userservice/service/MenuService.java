package com.qk.userservice.service;

import com.qk.commonservice.service.CrudService;
import com.qk.userservice.dao.MenuDao;
import com.qk.userservice.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyu
 * @data 2018/7/19
 */
@Service
public class MenuService extends CrudService<MenuDao, Menu> {

    @Autowired
    private MenuDao menuDao;

    public List<Menu> findByUsername(String username){
        return menuDao.findByUsername(username);
    }
}

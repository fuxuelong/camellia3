package com.qk.userservice.web;

import com.qk.userservice.entity.Menu;
import com.qk.userservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Zhy
 * @data 2018/7/24
 * @description 
 */
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/getMenus")
    public List<Menu> getMenus(String username){
        return menuService.findByUsername(username);
    }
}

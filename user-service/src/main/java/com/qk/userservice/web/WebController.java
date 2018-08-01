package com.qk.userservice.web;

import com.qk.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zhy
 * @date 2018/7/24
 * @description 
 */
@RequestMapping("/web")
@Controller
public class WebController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        System.out.println("--2222--"+request.getHeader("set-cookie"));
        return "index";
    }

}

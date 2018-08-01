package com.qk.blogservice.web;

import com.qk.blogservice.service.BlogService;
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
    BlogService blogService;

    @GetMapping("/list")
    public String list(){
        return "list";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        System.out.println("--2222--"+request.getHeader("set-cookie"));
        return "list";
    }

}

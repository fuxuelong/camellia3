package com.qk.blogservice.web;



import com.qk.blogservice.entity.Blog;
import com.qk.blogservice.service.BlogService;
import com.qk.commonservice.annotation.SysLogger;
import com.qk.commonservice.dto.RespDTO;
import com.qk.commonservice.exception.CommonException;
import com.qk.commonservice.exception.ErrorCode;
import com.qk.commonservice.utils.UserUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Zhy
 * @date 2018/7/24
 * @description 
 */
@RestController
@RequestMapping("/blog")
@RefreshScope
public class BlogController {

    @Autowired
    BlogService blogService;

    @ApiOperation(value = "发布博客", notes = "发布博客")
    @PostMapping("/save")
    @SysLogger("postBlog")
    public RespDTO postBlog(String username, String title, String subject){
        //字段判读省略
        Blog blog = new Blog();
        blog.setUsername(username);
        blog.setSubject(subject);
        blog.setTitle(title);
        blogService.postBlog(blog);
       return RespDTO.onSuc(blog);
    }

    @ApiOperation(value = "根据用户id获取所有的blog", notes = "根据用户id获取所有的blog")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{username}")
    @SysLogger("getBlogs")
    public RespDTO getBlogs(@PathVariable String  username){
        //字段判读省略
        if(UserUtils.isMyself(username)) {
            List<Blog> blogs = blogService.findBlogs(username);
            return RespDTO.onSuc(blogs);
        }else {
            throw new CommonException(ErrorCode.TOKEN_IS_NOT_MATCH_USER);
        }
    }

    @ApiOperation(value = "获取博文的详细信息", notes = "获取博文的详细信息")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{id}/detail")
    @SysLogger("getBlogDetail")
    public RespDTO getBlogDetail(@PathVariable Long id){
        return RespDTO.onSuc(blogService.findBlogDetail(id));
    }

   }

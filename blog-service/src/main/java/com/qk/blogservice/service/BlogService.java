package com.qk.blogservice.service;



import com.qk.blogservice.client.UserServiceClient;
import com.qk.blogservice.dao.BlogDao;
import com.qk.blogservice.dto.BlogDetailDTO;
import com.qk.blogservice.entity.Blog;
import com.qk.blogservice.entity.User;
import com.qk.commonservice.dto.RespDTO;
import com.qk.commonservice.exception.CommonException;
import com.qk.commonservice.exception.ErrorCode;
import com.qk.commonservice.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zhy
 * @date 2018/7/24
 * @description
 */
@Service
public class BlogService {

    @Autowired
    BlogDao blogDao;

    @Autowired
    UserServiceClient userServiceClient;

    public void postBlog(Blog blog) {
        blogDao.save(blog);
    }

    public List<Blog> findBlogs(String username) {
        return blogDao.findByUsername(username);
    }


    public BlogDetailDTO findBlogDetail(Long id) {
        Blog blog = blogDao.get(id);
        if (null == blog) {
            throw new CommonException(ErrorCode.BLOG_IS_NOT_EXIST);
        }
        RespDTO<User> respDTO = userServiceClient.getUser(UserUtils.getCurrentToken(), blog.getUsername());
        if (respDTO==null) {
            throw new CommonException(ErrorCode.RPC_ERROR);
        }
        BlogDetailDTO blogDetailDTO = new BlogDetailDTO();
        blogDetailDTO.setBlog(blog);
        blogDetailDTO.setUser(respDTO.data);
        return blogDetailDTO;
    }

}

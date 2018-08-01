package com.qk.blogservice.dao;


import com.qk.blogservice.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Zhy
 * @date 2018/7/24
 * @description 
 */
@Component
@Mapper
public interface BlogDao {

    /**
     * 查找Blog
     * @param username
     * @return
     */
    List<Blog> findByUsername(String username);

    /**
     * 保存博客
     * @param blog
     */
    void save(Blog blog);

    /**
     * 获取博客
     * @param id
     * @return
     */
    Blog get(Long id);

}

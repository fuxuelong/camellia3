package com.qk.blogservice.dto;


import com.qk.blogservice.entity.Blog;
import com.qk.blogservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zhy
 * @date 2018/7/24
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDetailDTO {
    private Blog blog;
    private User user;
}

package com.qk.blogservice.dto;


import com.qk.blogservice.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private Blog blog;
    private String token;
}

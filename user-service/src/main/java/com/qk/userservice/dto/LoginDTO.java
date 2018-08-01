package com.qk.userservice.dto;


import com.qk.userservice.entity.User;
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
    private User user;
    private String token;
}

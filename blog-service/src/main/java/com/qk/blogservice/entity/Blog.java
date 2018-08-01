package com.qk.blogservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author Zhy
 * @date 2018/7/24
 * @description 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {

    private Long id;

    private String username;

    private String title;

    private String subject;

}

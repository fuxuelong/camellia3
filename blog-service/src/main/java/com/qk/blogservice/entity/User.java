package com.qk.blogservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private Long id;

	private String username;

	private String password;

}

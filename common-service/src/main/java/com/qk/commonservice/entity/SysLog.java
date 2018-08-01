package com.qk.commonservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhangyu
 * @data 2018/7/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysLog {

    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户操作
     */
    private String operation;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求参数
     */
    private String params;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 创建时间
     */
    private Date createDate;
}

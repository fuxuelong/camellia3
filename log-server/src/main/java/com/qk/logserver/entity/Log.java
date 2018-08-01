package com.qk.logserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志entity
 * @author zhangyu
 * @data 2018/7/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log implements Serializable {
    private Long id;
    private String username;
    private String operation;
    private String method;
    private String params;

    private String ip;

    private Date createDate;
}

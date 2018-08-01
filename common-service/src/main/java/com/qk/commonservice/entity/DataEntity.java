package com.qk.commonservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangyu
 * @data 2018/7/16
 */
@Data
@NoArgsConstructor
public abstract class DataEntity<T> implements Serializable {

    private Long id;

    private String updateBy;

    private Date updateDate;

    private String createBy;

    private Date createDate;
}

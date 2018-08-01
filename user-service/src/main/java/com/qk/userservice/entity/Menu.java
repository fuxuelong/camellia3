package com.qk.userservice.entity;

import com.qk.commonservice.entity.DataEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyu
 * @data 2018/7/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends DataEntity<Menu> {

    private String parentId;
    private String parentIds;
    private String name;
    private String sort;
    private String href;
    private String target;
    private String icon;
    private String isshow;
    private String permission;



}

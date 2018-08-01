package com.qk.ginkgoservice.modules.basic.information.entity; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import com.qk.ginkgoservice.common.persistence.DataEntity;
import com.qk.ginkgoservice.common.persistence.TreeEntity;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotNull;

/**
 * 品牌信息Entity
 * 
 * @author qk
 * @version 2016-12-28
 */
public class QkBasicPp extends DataEntity<QkBasicPp> {

    private static final long serialVersionUID = 1L;
    private String name; // 名称
    private Integer sort; // 排序
    private QkBasicPp parent; // 父级编号
    private String parentIds; // 所有父级编号
    private String manufacture; // 制造商
    private String active; // 有效状态

    public QkBasicPp() {
        super();
        this.manufacture = "中国重汽";
        this.active = "1";
    }

    public QkBasicPp(String id) {
        super(id);
    }

    @JsonIgnore
    public static String getRootId() {
        return "1";
    }

    @Length(min = 1, max = 100, message = "名称长度必须介于 1 和 100 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @JsonBackReference
    @JsonIgnore
    @NotNull(message = "父级编号不能为空")
    public QkBasicPp getParent() {
        return parent;
    }

    public void setParent(QkBasicPp parent) {
        this.parent = parent;
    }

    @Length(min = 1, max = 2000, message = "所有父级编号长度必须介于 1 和 2000 之间")
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Length(min = 1, max = 20, message = "制造商长度必须介于 1 和 20 之间")
    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Length(min = 1, max = 11, message = "有效状态长度必须介于 1 和 11 之间")
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getParentId() {
        return parent != null && parent.getId() != null ? parent.getId() : "0";
    }
}

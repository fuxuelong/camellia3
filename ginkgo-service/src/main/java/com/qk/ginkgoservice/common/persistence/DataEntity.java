/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.qk.ginkgoservice.common.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qk.ginkgoservice.common.utils.IdGen;
import com.qk.ginkgoservice.common.utils.StringUtils;
import com.qk.ginkgoservice.modules.sys.entity.User;
import com.qk.ginkgoservice.modules.sys.utils.UserUtils;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 数据Entity类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

    private static final long serialVersionUID = 1L;
    /** 备注 */
    protected String remarks;
    /** 创建日期 */
    protected Date createDate;
    /** 更新日期 */
    protected Date updateDate;
    /** 删除标记（0：正常；1：删除；2：审核）*/
    protected String delFlag;
    /** 创建者 */
    protected User createBy;
    /** 更新者 */
    protected User updateBy;

    public DataEntity() {
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public DataEntity(String id) {
        super(id);
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert() {
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
//        if (!this.isNewRecord) {
//            setId(IdGen.uuid());
//        }
//        /**一线通是从缓存中取出*/
//        User user = UserUtils.getCurrentPrinciple();
//        if (StringUtils.isNotBlank(user.getId())) {
//            this.updateBy = user;
//            this.createBy = user;
//        }
//        this.updateDate = new Date();
//        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate() {
        /**一线通是从缓存中取出*/
//        User user = UserUtils.getUser();
//        if (StringUtils.isNotBlank(user.getId())) {
//            this.updateBy = user;
//        }
//        this.updateDate = new Date();
    }

    @Length(min = 0, max = 255)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

//    @JsonIgnore
    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }
//    @JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

//    @JsonIgnore
    public User getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonIgnore
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

//    @JsonIgnore
    @Length(min = 1, max = 1)
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}

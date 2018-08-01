package com.qk.ginkgoservice.modules.basic.crm.entity; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import java.util.Date;
import java.util.List;
import com.google.common.collect.Lists;
import com.qk.ginkgoservice.common.persistence.DataEntity;
import com.qk.ginkgoservice.modules.basic.information.entity.QkBasicPp;
import org.apache.commons.lang3.StringUtils;

/**
 * 经销商品牌维护Entity
 * 
 * @author qk
 * @version 2016-12-27
 */
public class QkBasicJxsPp extends DataEntity<QkBasicJxsPp> {

    private static final long serialVersionUID = 1L;
    private QkBasicJxsinfo qkBasicJxsinfo; // 经销商ID
    private QkBasicPp pp; // 品牌
    private QkBasicPp px; // 品系
    private QkBasicPp category; // 分类
    private Date startdate; // 开始日期
    private Date enddate; // 结束日期
    private String isShowNet;
    private String sqlStr;
    private List<QkBasicPp> qkBasicPpList = Lists.newArrayList(); // 拥有品牌列表

    public QkBasicJxsPp() {
        super();
        this.isShowNet = "1";
    }

    public QkBasicJxsPp(String id) {
        super(id);
    }

    public QkBasicJxsPp(QkBasicJxsinfo qkBasicJxsinfo) {
        super();
        this.qkBasicJxsinfo = qkBasicJxsinfo;
    }

    public QkBasicJxsPp(String id, QkBasicJxsinfo qkBasicJxsinfo, QkBasicPp category) {
        super(id);
        this.qkBasicJxsinfo = qkBasicJxsinfo;
        this.category = category;
    }



    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }


    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public QkBasicJxsinfo getQkBasicJxsinfo() {
        return qkBasicJxsinfo;
    }

    public void setQkBasicJxsinfo(QkBasicJxsinfo qkBasicJxsinfo) {
        this.qkBasicJxsinfo = qkBasicJxsinfo;
    }

    public QkBasicPp getCategory() {
        return category;
    }

    public void setCategory(QkBasicPp category) {
        this.category = category;
    }

    // @ExcelField(title="拥有品牌", align=1, sort=800, fieldType=QkBasicPpListType.class)
    public List<QkBasicPp> getQkBasicPpList() {
        return qkBasicPpList;
    }

    public void setQkBasicPpList(List<QkBasicPp> qkBasicPpList) {
        this.qkBasicPpList = qkBasicPpList;
    }

    public List<String> getQkBasicPpIdList() {
        List<String> qkBasicPpIdList = Lists.newArrayList();
        for (QkBasicPp qkBasicPp : qkBasicPpList) {
            qkBasicPpIdList.add(qkBasicPp.getId());
        }
        return qkBasicPpIdList;
    }

    public void setQkBasicPpIdList(List<String> qkBasicPpIdList) {
        qkBasicPpList = Lists.newArrayList();
        for (String qkBasicPpId : qkBasicPpIdList) {
            QkBasicPp qkBasicPp = new QkBasicPp();
            qkBasicPp.setId(qkBasicPpId);
            qkBasicPpList.add(qkBasicPp);
        }
    }

    public String getQkBasicPpIds() {
        return StringUtils.join(getQkBasicPpIdList(), ",");

    }

    public void setQkBasicPpIds(String qkBasicPpIds) {
        qkBasicPpList = Lists.newArrayList();
        if (qkBasicPpIds != null) {
            String[] ids = StringUtils.split(qkBasicPpIds, ",");
            setQkBasicPpIdList(Lists.newArrayList(ids));
        }
    }

    public QkBasicPp getPp() {
        return pp;
    }

    public void setPp(QkBasicPp pp) {
        this.pp = pp;
    }

    public QkBasicPp getPx() {
        return px;
    }

    public void setPx(QkBasicPp px) {
        this.px = px;
    }

    public String getIsShowNet() {
        return isShowNet;
    }

    public void setIsShowNet(String isShowNet) {
        this.isShowNet = isShowNet;
    }

    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = sqlStr;
    }


}

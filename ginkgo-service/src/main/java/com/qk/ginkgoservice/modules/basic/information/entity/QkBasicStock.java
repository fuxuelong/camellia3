package com.qk.ginkgoservice.modules.basic.information.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qk.ginkgoservice.common.persistence.DataEntity;
import com.qk.ginkgoservice.modules.sys.entity.Office;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * @author fuxuelong
 */
public class QkBasicStock extends DataEntity<QkBasicStock> {
    private static final long serialVersionUID = 1L;
    private String stockcode; // 仓库编码
    private String stockname; // 仓库名称
    private String stocktype; // 仓库类别
    private Office office; // 经销商ID
    private String stockaddress; // 仓库地址
    private String areaid; // 所在城市
    private String dj; // 东经
    private String bw; // 北纬
    private String fzrid; // 负责人
    private Date sldate; // 设立日期
    private String active; // 有效状态
    private String canjc; // 是否可接车
    private String jcrsqs; // 接车人授权书
    private String jczbab; // 接车章备案表
    private Date sqsdqdate; // 授权书到期日期
    private String lxr; // 联系人
    private String lxrdh; // 联系人电话
    private String lxrcz; // 联系人传真
    private String lxremail; // 联系人邮箱
    private String website; // 网站
    private String address; // 联系人地址
    private String yb; // 邮编
    private String idcard; // 身份证号
    private Date beginSldate; // 开始 设立日期
    private Date endSldate; // 结束 设立日期
    private String jxspxid; // 经销商品系的id
    private String jxspxnaem; // 经销商品系的id
    private String sqlStr;

    public QkBasicStock() {
        super();
    }

    public QkBasicStock(String id) {
        super(id);
    }

    public QkBasicStock(String id, Office office) {
        super(id);
        this.office = office;
    }

    public QkBasicStock(String id, Office office, String active) {
        super(id);
        this.office = office;
        this.active = active;
    }

    public QkBasicStock(String id, String stockcode) {
        super(id);
        this.stockcode = stockcode;
    }

    @Length(min = 1, max = 50, message = "仓库编码长度必须介于 1 和 50 之间")
    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode;
    }

    @Length(min = 1, max = 256, message = "仓库名称长度必须介于 1 和 256 之间")
    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    @Length(min = 1, max = 11, message = "仓库类别长度必须介于 1 和 11 之间")
    public String getStocktype() {
        return stocktype;
    }

    public void setStocktype(String stocktype) {
        this.stocktype = stocktype;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Length(min = 1, max = 256, message = "仓库地址长度必须介于 1 和 256 之间")
    public String getStockaddress() {
        return stockaddress;
    }

    public void setStockaddress(String stockaddress) {
        this.stockaddress = stockaddress;
    }

    @Length(min = 1, max = 11, message = "所在城市长度必须介于 1 和 11 之间")
    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getDj() {
        return dj;
    }

    public void setDj(String dj) {
        this.dj = dj;
    }

    public String getBw() {
        return bw;
    }

    public void setBw(String bw) {
        this.bw = bw;
    }

    @Length(min = 0, max = 64, message = "负责人长度必须介于 1 和 11 之间")
    public String getFzrid() {
        return fzrid;
    }

    public void setFzrid(String fzrid) {
        this.fzrid = fzrid;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getSldate() {
        return sldate;
    }

    public void setSldate(Date sldate) {
        this.sldate = sldate;
    }

    @Length(min = 1, max = 11, message = "有效状态长度必须介于 1 和 11 之间")
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Length(min = 1, max = 11, message = "是否可接车长度必须介于 1 和 11 之间")
    public String getCanjc() {
        return canjc;
    }

    public void setCanjc(String canjc) {
        this.canjc = canjc;
    }

    @Length(min = 1, max = 11, message = "接车人授权书长度必须介于 1 和 11 之间")
    public String getJcrsqs() {
        return jcrsqs;
    }

    public void setJcrsqs(String jcrsqs) {
        this.jcrsqs = jcrsqs;
    }

    @Length(min = 1, max = 11, message = "接车章备案表长度必须介于 1 和 11 之间")
    public String getJczbab() {
        return jczbab;
    }

    public void setJczbab(String jczbab) {
        this.jczbab = jczbab;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getSqsdqdate() {
        return sqsdqdate;
    }

    public void setSqsdqdate(Date sqsdqdate) {
        this.sqsdqdate = sqsdqdate;
    }

    @Length(min = 0, max = 20, message = "联系人长度必须介于 1 和 20 之间")
    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    @Length(min = 0, max = 20, message = "联系人电话长度必须介于 1 和 20 之间")
    public String getLxrdh() {
        return lxrdh;
    }

    public void setLxrdh(String lxrdh) {
        this.lxrdh = lxrdh;
    }

    @Length(min = 0, max = 20, message = "联系人传真长度必须介于 0 和 20 之间")
    public String getLxrcz() {
        return lxrcz;
    }

    public void setLxrcz(String lxrcz) {
        this.lxrcz = lxrcz;
    }

    @Length(min = 0, max = 128, message = "联系人邮箱长度必须介于 0 和 128 之间")
    public String getLxremail() {
        return lxremail;
    }

    public void setLxremail(String lxremail) {
        this.lxremail = lxremail;
    }

    @Length(min = 0, max = 128, message = "网站长度必须介于 0 和 128 之间")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Length(min = 0, max = 128, message = "联系人地址长度必须介于 0 和 128 之间")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Length(min = 0, max = 10, message = "邮编长度必须介于 0 和 10 之间")
    public String getYb() {
        return yb;
    }

    public void setYb(String yb) {
        this.yb = yb;
    }

    @Length(min = 0, max = 18, message = "身份证号长度必须介于 1 和 18 之间")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getBeginSldate() {
        return beginSldate;
    }

    public void setBeginSldate(Date beginSldate) {
        this.beginSldate = beginSldate;
    }

    public Date getEndSldate() {
        return endSldate;
    }

    public void setEndSldate(Date endSldate) {
        this.endSldate = endSldate;
    }

    public String getJxspxid() {
        return jxspxid;
    }

    public void setJxspxid(String jxspxid) {
        this.jxspxid = jxspxid;
    }

    public String getJxspxnaem() {
        return jxspxnaem;
    }

    public void setJxspxnaem(String jxspxnaem) {
        this.jxspxnaem = jxspxnaem;
    }

    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = sqlStr;
    }
}

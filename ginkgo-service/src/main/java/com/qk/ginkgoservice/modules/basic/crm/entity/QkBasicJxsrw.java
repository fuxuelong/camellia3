package com.qk.ginkgoservice.modules.basic.crm.entity; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import com.qk.ginkgoservice.common.persistence.DataEntity;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsinfo;
import com.qk.ginkgoservice.modules.basic.information.entity.QkBasicPp;
import com.qk.ginkgoservice.modules.sys.entity.Office;
import com.qk.ginkgoservice.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 经销商入网管理Entity
 * 
 * @author qk
 * @version 2017-05-23
 */
public class QkBasicJxsrw extends DataEntity<QkBasicJxsrw> {

    private static final long serialVersionUID = 1L;
    private String jxscode; // 经销商编码
    private Office jxs; // 经销商组织结构
    private Office bsc; // 所属办事处
    private String name; // 经销商名称
    private String jxsjc; // 经销商简称
    private String address; // 公司地址
    private String pid; // 上级经销商
    private String grade; // 经销商级别
    private String zzjgdm; // 组织机构代码
    private String khyh; // 开户银行
    private String yhzh; // 银行账号
    private String yyzzdjh; // 营业执照登记号
    private String gssh; // 公司税号
    private String shdjzh; // 税务登记证号
    private String gsxz; // 公司性质（有限责任、股份有限）
    private String frdb; // 法人代表
    private String frdh; // 法人电话
    private String frcz; // 法人传真
    private String zczj; // 注册资金
    private Date regdate; // 注册时间
    private String lxrid; // 联系人
    private String lxrdh; // 联系人电话
    private String lxrcz; // 联系人传真
    private String yb; // 邮编
    private String jycsxz; // 经营场所性质:自有 租赁
    private String jycsmj; // 经营场所面积
    private String email; // 电子邮箱
    private String gsrs; // 公司人数
    private String ywrys; // 业务人员总数
    private String qtjypp; // 其他经营品牌
    private String zyys; // 主要优势
    private String ywfzr; // 业务负责人
    private String ywrdh; // 业务负责人电话
    private String ywcz; // 业务负责人传真
    private String dwxz; // 单位性质
    private String jxqy; // 经销区域
    private String cxl; // 承销量
    private String isxfyt; // 是否销服一体
    private String fwzname; // 服务站名称
    private String last1styearqkxl; // 上一年轻卡销量
    private String last2ndyearqkxl; // 上两年轻卡销量
    private String last3rdyearqkxl; // 上三年轻卡销量 记录每一年销量
    private String last1styearxl; // 上一年其他产品销量
    private String last2ndyearxl; // 上两年其他产品销量
    private String last3rdyearxl; // 上三年其他产品销量
    private String spzt; // 审批状态（1：待审批，2：审批通过，3：审批驳回）
    private String scbFlag; // 市场部审批意见
    private String scbText; // 市场部审批备注
    private Date scbDate; // scb_date
    private String fsbFlag; // 法审部审批意见
    private String fsbText; // fsb_text
    private Date fsbDate; // fsb_date
    private String cwbFlag; // cwb_flag
    private String cwbText; // cwb_text
    private Date cwbDate; // cwb_date
    private String jsbFlag; // 技术部审批意见
    private String jsbText; // jsb_text
    private Date jsbDate; // jsb_date
    private String xgbFlag; // 销管部审批意见
    private String xgbText; // xgb_text
    private Date xgbDate; // xgb_date
    private String fwbFlag; // 服务部审批意见
    private String fwbText; // fwb_text
    private Date fwbDate; // fwb_date
    private String leadFlag; // 领导审批意见
    private String leadText; // lead_text
    private Date leadDate; // lead_date
    private String active; // active
    private String file; // file
    private User bgBy; // 变更操作人
    private Date bgDate; // 变更时间
    private String bgRemarks; // 变更备注
    private QkBasicPp category; // category
    private QkBasicPp px; // px
    private QkBasicJxsinfo parent; // 父经销商Id
    private Date rwdate; // 入网时间

    private Date beginRwdate;
    private Date endRwdate;

    private String bscFlag; // 办事处经理审批意见
    private String bscText;
    private Date bscDate;

    private String flag; // 判断点击的是通过还是驳回
    private String sqlStr;
    private String ppString;


    private String province;

    private String city; // 网络所在城市
    private String provinceName; // 网络所在省份

    private String cityName; // 网络所在城市


    private String fileCxxys; // 年度承销协议
    private String fileHzxys; // 中国重汽轻卡经销网络合作协议书
    private String fileFdqgzjh; // 新入网单位辅导期工作计划
    private String fileCwbb;// 入网确认函
    private String fileGszc;// 企业名称及基础信息变更申请函
    private String fileJcxxb;// 经销单位基本信息表
    private String fileRlzyzkb;// 公司人力资源状况表


    private String fileWydwcnh; // 年度承销协议
    private String fileYyzh; // 中国重汽轻卡经销网络合作协议书
    private String fileYhkhxkz; // 新入网单位辅导期工作计划
    private String fileSfzfyj;// 入网确认函
    private String fileZp;// 企业名称及基础信息变更申请函
    private String fileXfytzmh;// 经销单位基本信息表
    private String fileGzzmh;// 公司人力资源状况表
    private String fileWlspb;// 网络审批表
    
    private String orderbj; //排序标记
    


    public QkBasicJxsrw() {
        super();
    }

    public QkBasicJxsrw(String id) {
        super(id);
    }

    public QkBasicJxsrw(String id, String jxscode) {
        super(id);
        this.jxscode = jxscode;
    }

    public QkBasicJxsrw(String id, QkBasicJxsinfo parent, QkBasicPp px) {
        super(id);
        this.parent = parent;
        this.px = px;
    }

    public QkBasicJxsrw(String id, String jxscode, String spzt) {
        super(id);
        this.jxscode = jxscode;
        this.spzt = spzt;
    }


    @Length(min = 1, max = 50, message = "经销商编码长度必须介于 1 和 50 之间")
    public String getJxscode() {
        return jxscode;
    }

    public void setJxscode(String jxscode) {
        this.jxscode = jxscode;
    }


    @Length(min = 0, max = 255, message = "经销商名称长度必须介于 0 和 255 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 0, max = 255, message = "经销商简称长度必须介于 0 和 255 之间")
    public String getJxsjc() {
        return jxsjc;
    }

    public void setJxsjc(String jxsjc) {
        this.jxsjc = jxsjc;
    }

    @Length(min = 0, max = 255, message = "公司地址长度必须介于 0 和 255 之间")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Length(min = 0, max = 64, message = "上级经销商长度必须介于 0 和 64 之间")
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Length(min = 0, max = 64, message = "经销商级别长度必须介于 0 和 64 之间")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Length(min = 0, max = 50, message = "组织机构代码长度必须介于 0 和 50 之间")
    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }

    @Length(min = 0, max = 255, message = "开户银行长度必须介于 0 和 255 之间")
    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }

    @Length(min = 0, max = 255, message = "银行账号长度必须介于 0 和 255 之间")
    public String getYhzh() {
        return yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh;
    }

    @Length(min = 0, max = 255, message = "营业执照登记号长度必须介于 0 和 255 之间")
    public String getYyzzdjh() {
        return yyzzdjh;
    }

    public void setYyzzdjh(String yyzzdjh) {
        this.yyzzdjh = yyzzdjh;
    }

    @Length(min = 0, max = 255, message = "公司税号长度必须介于 0 和 255 之间")
    public String getGssh() {
        return gssh;
    }

    public void setGssh(String gssh) {
        this.gssh = gssh;
    }

    @Length(min = 0, max = 255, message = "税务登记证号长度必须介于 0 和 255 之间")
    public String getShdjzh() {
        return shdjzh;
    }

    public void setShdjzh(String shdjzh) {
        this.shdjzh = shdjzh;
    }

    @Length(min = 0, max = 64, message = "公司性质（有限责任、股份有限）长度必须介于 0 和 64 之间")
    public String getGsxz() {
        return gsxz;
    }

    public void setGsxz(String gsxz) {
        this.gsxz = gsxz;
    }

    @Length(min = 0, max = 20, message = "法人代表长度必须介于 0 和 20 之间")
    public String getFrdb() {
        return frdb;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }

    @Length(min = 0, max = 20, message = "法人电话长度必须介于 0 和 20 之间")
    public String getFrdh() {
        return frdh;
    }

    public void setFrdh(String frdh) {
        this.frdh = frdh;
    }

    @Length(min = 0, max = 20, message = "法人传真长度必须介于 0 和 20 之间")
    public String getFrcz() {
        return frcz;
    }

    public void setFrcz(String frcz) {
        this.frcz = frcz;
    }

    @Length(min = 0, max = 11, message = "注册资金长度必须介于 0 和 11 之间")
    public String getZczj() {
        return zczj;
    }

    public void setZczj(String zczj) {
        this.zczj = zczj;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Length(min = 0, max = 20, message = "联系人长度必须介于 0 和 20 之间")
    public String getLxrid() {
        return lxrid;
    }

    public void setLxrid(String lxrid) {
        this.lxrid = lxrid;
    }

    @Length(min = 0, max = 20, message = "联系人电话长度必须介于 0 和 20 之间")
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

    @Length(min = 0, max = 10, message = "邮编长度必须介于 0 和 10 之间")
    public String getYb() {
        return yb;
    }

    public void setYb(String yb) {
        this.yb = yb;
    }

    @Length(min = 0, max = 64, message = "经营场所性质:自有 租赁长度必须介于 0 和 64 之间")
    public String getJycsxz() {
        return jycsxz;
    }

    public void setJycsxz(String jycsxz) {
        this.jycsxz = jycsxz;
    }

    public String getJycsmj() {
        return jycsmj;
    }

    public void setJycsmj(String jycsmj) {
        this.jycsmj = jycsmj;
    }

    @Length(min = 0, max = 50, message = "电子邮箱长度必须介于 0 和 50 之间")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(min = 0, max = 11, message = "公司人数长度必须介于 0 和 11 之间")
    public String getGsrs() {
        return gsrs;
    }

    public void setGsrs(String gsrs) {
        this.gsrs = gsrs;
    }

    @Length(min = 0, max = 11, message = "业务人员总数长度必须介于 0 和 11 之间")
    public String getYwrys() {
        return ywrys;
    }

    public void setYwrys(String ywrys) {
        this.ywrys = ywrys;
    }

    @Length(min = 0, max = 50, message = "其他经营品牌长度必须介于 0 和 50 之间")
    public String getQtjypp() {
        return qtjypp;
    }

    public void setQtjypp(String qtjypp) {
        this.qtjypp = qtjypp;
    }

    @Length(min = 0, max = 2000, message = "主要优势长度必须介于 0 和 2000 之间")
    public String getZyys() {
        return zyys;
    }

    public void setZyys(String zyys) {
        this.zyys = zyys;
    }

    @Length(min = 0, max = 20, message = "业务负责人长度必须介于 0 和 20 之间")
    public String getYwfzr() {
        return ywfzr;
    }

    public void setYwfzr(String ywfzr) {
        this.ywfzr = ywfzr;
    }

    @Length(min = 0, max = 20, message = "业务负责人电话长度必须介于 0 和 20 之间")
    public String getYwrdh() {
        return ywrdh;
    }

    public void setYwrdh(String ywrdh) {
        this.ywrdh = ywrdh;
    }

    @Length(min = 0, max = 20, message = "业务负责人传真长度必须介于 0 和 20 之间")
    public String getYwcz() {
        return ywcz;
    }

    public void setYwcz(String ywcz) {
        this.ywcz = ywcz;
    }

    @Length(min = 0, max = 256, message = "单位性质长度必须介于 0 和 256 之间")
    public String getDwxz() {
        return dwxz;
    }

    public void setDwxz(String dwxz) {
        this.dwxz = dwxz;
    }

    @Length(min = 0, max = 128, message = "经销区域长度必须介于 0 和 128 之间")
    public String getJxqy() {
        return jxqy;
    }

    public void setJxqy(String jxqy) {
        this.jxqy = jxqy;
    }

    @Length(min = 0, max = 11, message = "承销量长度必须介于 0 和 11 之间")
    public String getCxl() {
        return cxl;
    }

    public void setCxl(String cxl) {
        this.cxl = cxl;
    }

    @Length(min = 0, max = 1, message = "是否销服一体长度必须介于 0 和 1 之间")
    public String getIsxfyt() {
        return isxfyt;
    }

    public void setIsxfyt(String isxfyt) {
        this.isxfyt = isxfyt;
    }

    @Length(min = 0, max = 128, message = "服务站名称长度必须介于 0 和 128 之间")
    public String getFwzname() {
        return fwzname;
    }

    public void setFwzname(String fwzname) {
        this.fwzname = fwzname;
    }

    @Length(min = 0, max = 11, message = "上一年轻卡销量长度必须介于 0 和 11 之间")
    public String getLast1styearqkxl() {
        return last1styearqkxl;
    }

    public void setLast1styearqkxl(String last1styearqkxl) {
        this.last1styearqkxl = last1styearqkxl;
    }

    @Length(min = 0, max = 11, message = "上两年轻卡销量长度必须介于 0 和 11 之间")
    public String getLast2ndyearqkxl() {
        return last2ndyearqkxl;
    }

    public void setLast2ndyearqkxl(String last2ndyearqkxl) {
        this.last2ndyearqkxl = last2ndyearqkxl;
    }

    @Length(min = 0, max = 11, message = "上三年轻卡销量 记录每一年销量长度必须介于 0 和 11 之间")
    public String getLast3rdyearqkxl() {
        return last3rdyearqkxl;
    }

    public void setLast3rdyearqkxl(String last3rdyearqkxl) {
        this.last3rdyearqkxl = last3rdyearqkxl;
    }

    @Length(min = 0, max = 11, message = "上一年其他产品销量长度必须介于 0 和 11 之间")
    public String getLast1styearxl() {
        return last1styearxl;
    }

    public void setLast1styearxl(String last1styearxl) {
        this.last1styearxl = last1styearxl;
    }

    @Length(min = 0, max = 11, message = "上两年其他产品销量长度必须介于 0 和 11 之间")
    public String getLast2ndyearxl() {
        return last2ndyearxl;
    }

    public void setLast2ndyearxl(String last2ndyearxl) {
        this.last2ndyearxl = last2ndyearxl;
    }

    @Length(min = 0, max = 11, message = "上三年其他产品销量长度必须介于 0 和 11 之间")
    public String getLast3rdyearxl() {
        return last3rdyearxl;
    }

    public void setLast3rdyearxl(String last3rdyearxl) {
        this.last3rdyearxl = last3rdyearxl;
    }

    @Length(min = 0, max = 64, message = "审批状态长度必须介于 0 和 64 之间")
    public String getSpzt() {
        return spzt;
    }

    public void setSpzt(String spzt) {
        this.spzt = spzt;
    }

    @Length(min = 0, max = 64, message = "市场部审批意见长度必须介于 0 和 64 之间")
    public String getScbFlag() {
        return scbFlag;
    }

    public void setScbFlag(String scbFlag) {
        this.scbFlag = scbFlag;
    }

    @Length(min = 0, max = 255, message = "市场部审批备注长度必须介于 0 和 255 之间")
    public String getScbText() {
        return scbText;
    }

    public void setScbText(String scbText) {
        this.scbText = scbText;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getScbDate() {
        return scbDate;
    }

    public void setScbDate(Date scbDate) {
        this.scbDate = scbDate;
    }

    @Length(min = 0, max = 64, message = "法审部审批意见长度必须介于 0 和 64 之间")
    public String getFsbFlag() {
        return fsbFlag;
    }

    public void setFsbFlag(String fsbFlag) {
        this.fsbFlag = fsbFlag;
    }

    @Length(min = 0, max = 255, message = "fsb_text长度必须介于 0 和 255 之间")
    public String getFsbText() {
        return fsbText;
    }

    public void setFsbText(String fsbText) {
        this.fsbText = fsbText;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getFsbDate() {
        return fsbDate;
    }

    public void setFsbDate(Date fsbDate) {
        this.fsbDate = fsbDate;
    }

    @Length(min = 0, max = 64, message = "cwb_flag长度必须介于 0 和 64 之间")
    public String getCwbFlag() {
        return cwbFlag;
    }

    public void setCwbFlag(String cwbFlag) {
        this.cwbFlag = cwbFlag;
    }

    @Length(min = 0, max = 255, message = "cwb_text长度必须介于 0 和 255 之间")
    public String getCwbText() {
        return cwbText;
    }

    public void setCwbText(String cwbText) {
        this.cwbText = cwbText;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCwbDate() {
        return cwbDate;
    }

    public void setCwbDate(Date cwbDate) {
        this.cwbDate = cwbDate;
    }

    @Length(min = 0, max = 64, message = "技术部审批意见长度必须介于 0 和 64 之间")
    public String getJsbFlag() {
        return jsbFlag;
    }

    public void setJsbFlag(String jsbFlag) {
        this.jsbFlag = jsbFlag;
    }

    @Length(min = 0, max = 255, message = "jsb_text长度必须介于 0 和 255 之间")
    public String getJsbText() {
        return jsbText;
    }

    public void setJsbText(String jsbText) {
        this.jsbText = jsbText;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getJsbDate() {
        return jsbDate;
    }

    public void setJsbDate(Date jsbDate) {
        this.jsbDate = jsbDate;
    }

    @Length(min = 0, max = 64, message = "销管部审批意见长度必须介于 0 和 64 之间")
    public String getXgbFlag() {
        return xgbFlag;
    }

    public void setXgbFlag(String xgbFlag) {
        this.xgbFlag = xgbFlag;
    }

    @Length(min = 0, max = 255, message = "xgb_text长度必须介于 0 和 255 之间")
    public String getXgbText() {
        return xgbText;
    }

    public void setXgbText(String xgbText) {
        this.xgbText = xgbText;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getXgbDate() {
        return xgbDate;
    }

    public void setXgbDate(Date xgbDate) {
        this.xgbDate = xgbDate;
    }

    @Length(min = 0, max = 64, message = "服务部审批意见长度必须介于 0 和 64 之间")
    public String getFwbFlag() {
        return fwbFlag;
    }

    public void setFwbFlag(String fwbFlag) {
        this.fwbFlag = fwbFlag;
    }

    @Length(min = 0, max = 255, message = "fwb_text长度必须介于 0 和 255 之间")
    public String getFwbText() {
        return fwbText;
    }

    public void setFwbText(String fwbText) {
        this.fwbText = fwbText;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getFwbDate() {
        return fwbDate;
    }

    public void setFwbDate(Date fwbDate) {
        this.fwbDate = fwbDate;
    }

    @Length(min = 0, max = 64, message = "领导审批意见长度必须介于 0 和 64 之间")
    public String getLeadFlag() {
        return leadFlag;
    }

    public void setLeadFlag(String leadFlag) {
        this.leadFlag = leadFlag;
    }

    @Length(min = 0, max = 255, message = "lead_text长度必须介于 0 和 255 之间")
    public String getLeadText() {
        return leadText;
    }

    public void setLeadText(String leadText) {
        this.leadText = leadText;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getLeadDate() {
        return leadDate;
    }

    public void setLeadDate(Date leadDate) {
        this.leadDate = leadDate;
    }

    @Length(min = 0, max = 1, message = "有效状态长度必须介于 0 和 1 之间")
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


    public User getBgBy() {
        return bgBy;
    }

    public void setBgBy(User bgBy) {
        this.bgBy = bgBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getBgDate() {
        return bgDate;
    }

    public void setBgDate(Date bgDate) {
        this.bgDate = bgDate;
    }

    @Length(min = 0, max = 255, message = "变更备注长度必须介于 0 和 255 之间")
    public String getBgRemarks() {
        return bgRemarks;
    }

    public void setBgRemarks(String bgRemarks) {
        this.bgRemarks = bgRemarks;
    }

    public QkBasicPp getCategory() {
        return category;
    }

    public void setCategory(QkBasicPp category) {
        this.category = category;
    }

    public QkBasicPp getPx() {
        return px;
    }

    public void setPx(QkBasicPp px) {
        this.px = px;
    }

    public QkBasicJxsinfo getParent() {
        return parent;
    }

    public void setParent(QkBasicJxsinfo parent) {
        this.parent = parent;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getRwdate() {
        return rwdate;
    }

    public void setRwdate(Date rwdate) {
        this.rwdate = rwdate;
    }

    public Office getJxs() {
        return jxs;
    }

    public void setJxs(Office jxs) {
        this.jxs = jxs;
    }

    public Office getBsc() {
        return bsc;
    }

    public void setBsc(Office bsc) {
        this.bsc = bsc;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = sqlStr;
    }

    public String getBscFlag() {
        return bscFlag;
    }

    public void setBscFlag(String bscFlag) {
        this.bscFlag = bscFlag;
    }

    public String getBscText() {
        return bscText;
    }

    public void setBscText(String bscText) {
        this.bscText = bscText;
    }

    public Date getBscDate() {
        return bscDate;
    }

    public void setBscDate(Date bscDate) {
        this.bscDate = bscDate;
    }

    public String getPpString() {
        return ppString;
    }

    public void setPpString(String ppString) {
        this.ppString = ppString;
    }

    public Date getBeginRwdate() {
        return beginRwdate;
    }

    public void setBeginRwdate(Date beginRwdate) {
        this.beginRwdate = beginRwdate;
    }

    public Date getEndRwdate() {
        return endRwdate;
    }

    public void setEndRwdate(Date endRwdate) {
        this.endRwdate = endRwdate;
    }

    public String getFileCxxys() {
        return fileCxxys;
    }

    public void setFileCxxys(String fileCxxys) {
        this.fileCxxys = fileCxxys;
    }

    public String getFileHzxys() {
        return fileHzxys;
    }

    public void setFileHzxys(String fileHzxys) {
        this.fileHzxys = fileHzxys;
    }

    public String getFileFdqgzjh() {
        return fileFdqgzjh;
    }

    public void setFileFdqgzjh(String fileFdqgzjh) {
        this.fileFdqgzjh = fileFdqgzjh;
    }

    public String getFileCwbb() {
        return fileCwbb;
    }

    public void setFileCwbb(String fileCwbb) {
        this.fileCwbb = fileCwbb;
    }

    public String getFileGszc() {
        return fileGszc;
    }

    public void setFileGszc(String fileGszc) {
        this.fileGszc = fileGszc;
    }

    public String getFileJcxxb() {
        return fileJcxxb;
    }

    public void setFileJcxxb(String fileJcxxb) {
        this.fileJcxxb = fileJcxxb;
    }

    public String getFileRlzyzkb() {
        return fileRlzyzkb;
    }

    public void setFileRlzyzkb(String fileRlzyzkb) {
        this.fileRlzyzkb = fileRlzyzkb;
    }

    public String getFileWydwcnh() {
        return fileWydwcnh;
    }

    public void setFileWydwcnh(String fileWydwcnh) {
        this.fileWydwcnh = fileWydwcnh;
    }

    public String getFileYyzh() {
        return fileYyzh;
    }

    public void setFileYyzh(String fileYyzh) {
        this.fileYyzh = fileYyzh;
    }

    public String getFileYhkhxkz() {
        return fileYhkhxkz;
    }

    public void setFileYhkhxkz(String fileYhkhxkz) {
        this.fileYhkhxkz = fileYhkhxkz;
    }

    public String getFileSfzfyj() {
        return fileSfzfyj;
    }

    public void setFileSfzfyj(String fileSfzfyj) {
        this.fileSfzfyj = fileSfzfyj;
    }

    public String getFileZp() {
        return fileZp;
    }

    public void setFileZp(String fileZp) {
        this.fileZp = fileZp;
    }

    public String getFileXfytzmh() {
        return fileXfytzmh;
    }

    public void setFileXfytzmh(String fileXfytzmh) {
        this.fileXfytzmh = fileXfytzmh;
    }

    public String getFileGzzmh() {
        return fileGzzmh;
    }

    public void setFileGzzmh(String fileGzzmh) {
        this.fileGzzmh = fileGzzmh;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getFileWlspb() {
        return fileWlspb;
    }

    public void setFileWlspb(String fileWlspb) {
        this.fileWlspb = fileWlspb;
    }

    public String getOrderbj() {
        return orderbj;
    }

    public void setOrderbj(String orderbj) {
        this.orderbj = orderbj;
    }


}

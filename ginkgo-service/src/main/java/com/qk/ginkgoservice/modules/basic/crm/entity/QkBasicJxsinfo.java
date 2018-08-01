package com.qk.ginkgoservice.modules.basic.crm.entity; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qk.ginkgoservice.common.persistence.DataEntity;
import com.qk.ginkgoservice.modules.basic.information.entity.QkBasicPp;
import com.qk.ginkgoservice.modules.sys.entity.Office;
import com.qk.ginkgoservice.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 经销商入网信息Entity
 * 
 * @author qk
 * @version 2016-12-14
 */
public class QkBasicJxsinfo extends DataEntity<QkBasicJxsinfo> {

    private static final long serialVersionUID = 1L;
    private String jxscode; // 经销商编码
    private Office officejxs; // 经销商组织结构
    private Office office; // 所属办事处
    private String name; // 经销商名称
    private String jxsjc; // 经销商简称
    private String address; // 公司地址
    private String pid; // 上级经销商
    private String grade; // 经销商级别
    private String zzjgdm; // 组织机构代码
    private String khyh; // 开户银行
    private String yhzh; // 银行账户
    private String yyzzdjh; // 营业执照登记号
    private String gssh; // 公司税号
    private String shdjzh; // 税务登记证号
    private String gsxz; // 公司性质
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
    private String dwxz; // 单位性质（1：一级特约经销商；2：出口经销商；3：改装单位）
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
    private String spzt; // 审批状态
    private String scbFlag; // 市场部审批意见
    private String scbText; // 市场部审批备注
    private String fsbFlag; // 法审部审批意见
    private String fsbText; // 法审部审批备注
    private String cwbFlag; // 财务部审批意见
    private String cwbText; // 财务部审批备注
    private String jsbFlag; // 技术部审批意见
    private String jsbText; // 技术部审批备注
    private String xgbFlag; // 销管部审批意见
    private String xgbText; // 销管部审批备注
    private String fwbFlag; // 服务部审批意见
    private String fwbText; // 服务部审批备注
    private String leadFlag; // 领导审批意见
    private String leadText; // 领导审批备注
    private Date scbDate; // 市场部意见
    private Date fsbDate; // 法审部意见
    private Date cwbDate; // 财务部意见
    private Date jsbDate; // 技术部意见
    private Date xgbDate; // 销管部意见
    private Date fwbDate; // 服务部意见
    private Date leadDate; // 领导意见
    private String active; // 有效状态（1有效，0无效）
    private String file;
    private String bgRemarks; // 信息变更备注
    private User bgBy; // 信息变更操作者
    private Date bgDate; // 信息变更日期
    private QkBasicPp px; // 品系
    private QkBasicPp category; // 分类
    private QkBasicJxsinfo parent; // 父经销商
    private Date rwdate; // 入网时间

    private String bscFlag; // 办事处经理审批意见
    private String bscText;
    private Date bscDate;

    private QkBasicJxsgl qkBasicJxsgl;
    private QkBasicJxsPp qkBasicJxsPp;

    private String sqlStr;

    private Date beginRwdate; // 开始 创建时间
    private Date endRwdate; // 结束 创建时间

    private String pxsl;// 品系数量

    private String spSize;// 审批过程中的数量

    private String province; // 经销商所在省份

    private String city; // 经销商所在城市
    private String provinceName; // 经销商所在省份

    private String cityName; // 经销商所在城市
    
    private String jxstype; // 经销商类型：特约 AAA4s店
    private String areatype; // 区域类型：成长区域、非成长区域
    private Date workeddate; // 类型执行时间
    private String citygrade; // 城市级别：省会城市 地级市 县级市
    

    public QkBasicJxsinfo() {
        super();
    }

    public QkBasicJxsinfo(String id) {
        super(id);
    }

    public QkBasicJxsinfo(String id, String jxscode) {
        super(id);
        this.jxscode = jxscode;
    }


    public QkBasicJxsinfo(String id, String jxscode, String spzt) {
        super(id);
        this.jxscode = jxscode;
        this.spzt = spzt;
        // this.active="1";
    }

    public QkBasicJxsinfo(String id, String jxscode, Office officejxs, String spzt) {
        super(id);
        this.officejxs = officejxs;
        this.jxscode = jxscode;
        this.spzt = spzt;
        // this.active="1";
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


    public String getJxscode() {
        return jxscode;
    }

    public void setJxscode(String jxscode) {
        this.jxscode = jxscode;
    }

 
    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Length(min = 1, max = 256, message = "经销商名称长度必须介于 1 和 256 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }


    public String getFrdb() {
        return frdb;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }


    public String getFrdh() {
        return frdh;
    }

    public void setFrdh(String frdh) {
        this.frdh = frdh;
    }


    public String getFrcz() {
        return frcz;
    }

    public void setFrcz(String frcz) {
        this.frcz = frcz;
    }

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


    public String getLxrid() {
        return lxrid;
    }

    public void setLxrid(String lxrid) {
        this.lxrid = lxrid;
    }

    public String getLxrdh() {
        return lxrdh;
    }

    public void setLxrdh(String lxrdh) {
        this.lxrdh = lxrdh;
    }

    public String getLxrcz() {
        return lxrcz;
    }

    public void setLxrcz(String lxrcz) {
        this.lxrcz = lxrcz;
    }

    public String getYb() {
        return yb;
    }

    public void setYb(String yb) {
        this.yb = yb;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsrs() {
        return gsrs;
    }

    public void setGsrs(String gsrs) {
        this.gsrs = gsrs;
    }

    public String getYwrys() {
        return ywrys;
    }

    public void setYwrys(String ywrys) {
        this.ywrys = ywrys;
    }

    public String getQtjypp() {
        return qtjypp;
    }

    public void setQtjypp(String qtjypp) {
        this.qtjypp = qtjypp;
    }

    public String getZyys() {
        return zyys;
    }

    public void setZyys(String zyys) {
        this.zyys = zyys;
    }

    public String getYwfzr() {
        return ywfzr;
    }

    public void setYwfzr(String ywfzr) {
        this.ywfzr = ywfzr;
    }

    public String getYwrdh() {
        return ywrdh;
    }

    public void setYwrdh(String ywrdh) {
        this.ywrdh = ywrdh;
    }

    public String getYwcz() {
        return ywcz;
    }

    public void setYwcz(String ywcz) {
        this.ywcz = ywcz;
    }

    public String getDwxz() {
        return dwxz;
    }

    public void setDwxz(String dwxz) {
        this.dwxz = dwxz;
    }

    public String getJxqy() {
        return jxqy;
    }

    public void setJxqy(String jxqy) {
        this.jxqy = jxqy;
    }

    public String getCxl() {
        return cxl;
    }

    public void setCxl(String cxl) {
        this.cxl = cxl;
    }

    public String getIsxfyt() {
        return isxfyt;
    }

    public void setIsxfyt(String isxfyt) {
        this.isxfyt = isxfyt;
    }

    public String getFwzname() {
        return fwzname;
    }

    public void setFwzname(String fwzname) {
        this.fwzname = fwzname;
    }

    public String getLast1styearqkxl() {
        return last1styearqkxl;
    }

    public void setLast1styearqkxl(String last1styearqkxl) {
        this.last1styearqkxl = last1styearqkxl;
    }

    public String getLast2ndyearqkxl() {
        return last2ndyearqkxl;
    }

    public void setLast2ndyearqkxl(String last2ndyearqkxl) {
        this.last2ndyearqkxl = last2ndyearqkxl;
    }

    public String getLast3rdyearqkxl() {
        return last3rdyearqkxl;
    }

    public void setLast3rdyearqkxl(String last3rdyearqkxl) {
        this.last3rdyearqkxl = last3rdyearqkxl;
    }

    public String getLast1styearxl() {
        return last1styearxl;
    }

    public void setLast1styearxl(String last1styearxl) {
        this.last1styearxl = last1styearxl;
    }

    public String getLast2ndyearxl() {
        return last2ndyearxl;
    }

    public void setLast2ndyearxl(String last2ndyearxl) {
        this.last2ndyearxl = last2ndyearxl;
    }

    public String getLast3rdyearxl() {
        return last3rdyearxl;
    }

    public void setLast3rdyearxl(String last3rdyearxl) {
        this.last3rdyearxl = last3rdyearxl;
    }

    public String getSpzt() {
        return spzt;
    }

    public void setSpzt(String spzt) {
        this.spzt = spzt;
    }

    public String getScbText() {
        return scbText;
    }

    public void setScbText(String scbText) {
        this.scbText = scbText;
    }

    public String getLeadText() {
        return leadText;
    }

    public void setLeadText(String leadText) {
        this.leadText = leadText;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Office getOfficejxs() {
        return officejxs;
    }

    public void setOfficejxs(Office officejxs) {
        this.officejxs = officejxs;
    }


    public String getFsbText() {
        return fsbText;
    }

    public void setFsbText(String fsbText) {
        this.fsbText = fsbText;
    }

    public String getCwbText() {
        return cwbText;
    }

    public void setCwbText(String cwbText) {
        this.cwbText = cwbText;
    }

    public String getJsbText() {
        return jsbText;
    }

    public void setJsbText(String jsbText) {
        this.jsbText = jsbText;
    }

    public String getXgbText() {
        return xgbText;
    }

    public void setXgbText(String xgbText) {
        this.xgbText = xgbText;
    }

    public String getFwbText() {
        return fwbText;
    }

    public void setFwbText(String fwbText) {
        this.fwbText = fwbText;
    }

    public Date getXgbDate() {
        return xgbDate;
    }

    public void setXgbDate(Date xgbDate) {
        this.xgbDate = xgbDate;
    }

    public Date getScbDate() {
        return scbDate;
    }

    public void setScbDate(Date scbDate) {
        this.scbDate = scbDate;
    }

    public Date getFsbDate() {
        return fsbDate;
    }

    public void setFsbDate(Date fsbDate) {
        this.fsbDate = fsbDate;
    }

    public Date getCwbDate() {
        return cwbDate;
    }

    public void setCwbDate(Date cwbDate) {
        this.cwbDate = cwbDate;
    }

    public Date getJsbDate() {
        return jsbDate;
    }

    public void setJsbDate(Date jsbDate) {
        this.jsbDate = jsbDate;
    }

    public Date getFwbDate() {
        return fwbDate;
    }

    public void setFwbDate(Date fwbDate) {
        this.fwbDate = fwbDate;
    }

    public Date getLeadDate() {
        return leadDate;
    }

    public void setLeadDate(Date leadDate) {
        this.leadDate = leadDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public QkBasicJxsgl getQkBasicJxsgl() {
        return qkBasicJxsgl;
    }

    public void setQkBasicJxsgl(QkBasicJxsgl qkBasicJxsgl) {
        this.qkBasicJxsgl = qkBasicJxsgl;
    }

    public QkBasicJxsPp getQkBasicJxsPp() {
        return qkBasicJxsPp;
    }

    public void setQkBasicJxsPp(QkBasicJxsPp qkBasicJxsPp) {
        this.qkBasicJxsPp = qkBasicJxsPp;
    }


    public User getBgBy() {
        return bgBy;
    }

    public void setBgBy(User bgBy) {
        this.bgBy = bgBy;
    }

    public Date getBgDate() {
        return bgDate;
    }

    public void setBgDate(Date bgDate) {
        this.bgDate = bgDate;
    }

    public String getBgRemarks() {
        return bgRemarks;
    }

    public void setBgRemarks(String bgRemarks) {
        this.bgRemarks = bgRemarks;
    }


    public String getPxsl() {
        return pxsl;
    }

    public void setPxsl(String pxsl) {
        this.pxsl = pxsl;
    }


    public String getScbFlag() {
        return scbFlag;
    }

    public void setScbFlag(String scbFlag) {
        this.scbFlag = scbFlag;
    }

    public String getFsbFlag() {
        return fsbFlag;
    }

    public void setFsbFlag(String fsbFlag) {
        this.fsbFlag = fsbFlag;
    }

    public String getCwbFlag() {
        return cwbFlag;
    }

    public void setCwbFlag(String cwbFlag) {
        this.cwbFlag = cwbFlag;
    }

    public String getJsbFlag() {
        return jsbFlag;
    }

    public void setJsbFlag(String jsbFlag) {
        this.jsbFlag = jsbFlag;
    }

    public String getXgbFlag() {
        return xgbFlag;
    }

    public void setXgbFlag(String xgbFlag) {
        this.xgbFlag = xgbFlag;
    }

    public String getFwbFlag() {
        return fwbFlag;
    }

    public void setFwbFlag(String fwbFlag) {
        this.fwbFlag = fwbFlag;
    }

    public String getLeadFlag() {
        return leadFlag;
    }

    public void setLeadFlag(String leadFlag) {
        this.leadFlag = leadFlag;
    }

    @JsonIgnore
    public QkBasicPp getPx() {
        return px;
    }

    public void setPx(QkBasicPp px) {
        this.px = px;
    }

    @JsonIgnore
    public QkBasicPp getCategory() {
        return category;
    }

    public void setCategory(QkBasicPp category) {
        this.category = category;
    }

    public QkBasicJxsinfo getParent() {
        return parent;
    }

    public void setParent(QkBasicJxsinfo parent) {
        this.parent = parent;
    }

    public Date getRwdate() {
        return rwdate;
    }

    public void setRwdate(Date rwdate) {
        this.rwdate = rwdate;
    }

    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }

    public String getYhzh() {
        return yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh;
    }

    public String getYyzzdjh() {
        return yyzzdjh;
    }

    public void setYyzzdjh(String yyzzdjh) {
        this.yyzzdjh = yyzzdjh;
    }

    public String getGssh() {
        return gssh;
    }

    public void setGssh(String gssh) {
        this.gssh = gssh;
    }

    public String getShdjzh() {
        return shdjzh;
    }

    public void setShdjzh(String shdjzh) {
        this.shdjzh = shdjzh;
    }

    public String getGsxz() {
        return gsxz;
    }

    public void setGsxz(String gsxz) {
        this.gsxz = gsxz;
    }

    public String getJxsjc() {
        return jxsjc;
    }

    public void setJxsjc(String jxsjc) {
        this.jxsjc = jxsjc;
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

 
    public String getSpSize() {
        return spSize;
    }

    public void setSpSize(String spSize) {
        this.spSize = spSize;
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

    public String getJxstype() {
        return jxstype;
    }

    public void setJxstype(String jxstype) {
        this.jxstype = jxstype;
    }

    public String getAreatype() {
        return areatype;
    }

    public void setAreatype(String areatype) {
        this.areatype = areatype;
    }

    public Date getWorkeddate() {
        return workeddate;
    }

    public void setWorkeddate(Date workeddate) {
        this.workeddate = workeddate;
    }

    public String getCitygrade() {
        return citygrade;
    }

    public void setCitygrade(String citygrade) {
        this.citygrade = citygrade;
    }


}

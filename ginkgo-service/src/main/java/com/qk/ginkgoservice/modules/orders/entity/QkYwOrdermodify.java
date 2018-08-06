package com.qk.ginkgoservice.modules.orders.entity; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */


import com.qk.ginkgoservice.common.persistence.DataEntity;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsinfo;
import com.qk.ginkgoservice.modules.orders.entity.QkYwOrders;
import com.qk.ginkgoservice.modules.sys.entity.Office;
import com.qk.ginkgoservice.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单修改Entity
 * 
 * @author fuxuelong
 */
public class QkYwOrdermodify extends DataEntity<QkYwOrdermodify> {
	
	private static final long serialVersionUID = 1L;
	private QkYwOrders dd;		// 订单号
	private Office bsc;		// 办事处
	private QkBasicJxsinfo jxs;		// 经销商
	private String diffms;		// 差异描述
	private String xgcs;		// 修改次数
	private String djzt;		// 单据状态
	private User shuser;		// 审核人
	private Date shdate;		// 审核日期
	private String shremark;		// 审核备注
	private User spuser;		// 审批人
	private Date spdate;		// 审批日期
	private String spremark;		// 审批备注
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	private String flag;	//0：驳回；1：通过
	private String beginDjzt;		// 开始单据状态值
	private String endDjzt;		// 结束 单据状态值
	private String xpcj;
	private String gzcj;
	
	private String area;//片区
	private String area_temp;//存放区域的parent_id;
	
	//20170913与生产系统对接
	private String PZMS_OLD;
	private String PZMS_NEW;
	private String XRSM;
	private String xg_nr;
	private String hxzt;
	
	private String sqlStr;
	public QkYwOrdermodify() {
		super();
	}

	public QkYwOrdermodify(String id){
		super(id);
	}
	
	public QkYwOrdermodify(String id,String id1){
		super(id);
	}

	public QkYwOrders getDd() {
		return dd;
	}

	public void setDd(QkYwOrders dd) {
		this.dd = dd;
	}	
	
	public String getDiffms() {
		return diffms;
	}

	public void setDiffms(String diffms) {
		this.diffms = diffms;
	}
	
	@Length(min=1, max=11, message="修改次数长度必须介于 1 和 11 之间")
	public String getXgcs() {
		return xgcs;
	}

	public void setXgcs(String xgcs) {
		this.xgcs = xgcs;
	}
	
	@Length(min=1, max=11, message="单据状态长度必须介于 1 和 11 之间")
	public String getDjzt() {
		return djzt;
	}

	public void setDjzt(String djzt) {
		this.djzt = djzt;
	}
		
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getShdate() {
		return shdate;
	}

	public void setShdate(Date shdate) {
		this.shdate = shdate;
	}
	
	@Length(min=0, max=2000, message="审核备注长度必须介于 0 和 2000 之间")
	public String getShremark() {
		return shremark;
	}

	public void setShremark(String shremark) {
		this.shremark = shremark;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSpdate() {
		return spdate;
	}

	public void setSpdate(Date spdate) {
		this.spdate = spdate;
	}
	
	@Length(min=0, max=2000, message="审批备注长度必须介于 0 和 2000 之间")
	public String getSpremark() {
		return spremark;
	}

	public void setSpremark(String spremark) {
		this.spremark = spremark;
	}
	
	public Date getBeginUpdateDate() {
		return beginUpdateDate;
	}

	public void setBeginUpdateDate(Date beginUpdateDate) {
		this.beginUpdateDate = beginUpdateDate;
	}
	
	public Date getEndUpdateDate() {
		return endUpdateDate;
	}

	public void setEndUpdateDate(Date endUpdateDate) {
		this.endUpdateDate = endUpdateDate;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getBeginDjzt() {
		return beginDjzt;
	}

	public void setBeginDjzt(String beginDjzt) {
		this.beginDjzt = beginDjzt;
	}

	public String getEndDjzt() {
		return endDjzt;
	}

	public void setEndDjzt(String endDjzt) {
		this.endDjzt = endDjzt;
	}

	public Office getBsc() {
		return bsc;
	}

	public void setBsc(Office bsc) {
		this.bsc = bsc;
	}

	public QkBasicJxsinfo getJxs() {
		return jxs;
	}

	public void setJxs(QkBasicJxsinfo jxs) {
		this.jxs = jxs;
	}

	public User getShuser() {
		return shuser;
	}

	public void setShuser(User shuser) {
		this.shuser = shuser;
	}

	public User getSpuser() {
		return spuser;
	}

	public void setSpuser(User spuser) {
		this.spuser = spuser;
	}

	public String getXpcj() {
		return xpcj;
	}

	public void setXpcj(String xpcj) {
		this.xpcj = xpcj;
	}

	public String getGzcj() {
		return gzcj;
	}

	public void setGzcj(String gzcj) {
		this.gzcj = gzcj;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea_temp() {
		return area_temp;
	}

	public void setArea_temp(String area_temp) {
		this.area_temp = area_temp;
	}

	public String getPZMS_OLD() {
		return PZMS_OLD;
	}

	public void setPZMS_OLD(String pZMS_OLD) {
		PZMS_OLD = pZMS_OLD;
	}

	public String getPZMS_NEW() {
		return PZMS_NEW;
	}

	public void setPZMS_NEW(String pZMS_NEW) {
		PZMS_NEW = pZMS_NEW;
	}

	public String getXRSM() {
		return XRSM;
	}

	public void setXRSM(String xRSM) {
		XRSM = xRSM;
	}

	public String getXg_nr() {
		return xg_nr;
	}

	public void setXg_nr(String xg_nr) {
		this.xg_nr = xg_nr;
	}

	public String getHxzt() {
		return hxzt;
	}

	public void setHxzt(String hxzt) {
		this.hxzt = hxzt;
	}

    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = sqlStr;
    }
	
	
		
}

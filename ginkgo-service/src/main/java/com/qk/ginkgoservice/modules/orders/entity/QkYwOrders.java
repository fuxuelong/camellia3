/**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights reserved.
 */
package com.qk.ginkgoservice.modules.orders.entity;

import com.qk.ginkgoservice.common.persistence.DataEntity;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsinfo;
import com.qk.ginkgoservice.modules.basic.information.entity.QkBasicStock;
import com.qk.ginkgoservice.modules.sys.entity.Office;
import com.qk.ginkgoservice.modules.sys.entity.User;
import com.qk.ginkgoservice.modules.sys.utils.DictUtils;
import org.hibernate.validator.constraints.Length;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 经销商订单提报Entity
 * @author QkEip
 * @version 2016-12-23
 */
public class QkYwOrders extends DataEntity<QkYwOrders> {
	
	private static final long serialVersionUID = 1L;
	private String ddh;		// 订单号，订单表中的订单IDyi是订单号，不再需要另外一个唯一ID，调拨时需要产生新号，办事处拆分或者合并时，需要考虑的是办事处的ID，而不是订单的ID
	private String ywms;		// 业务模式
	private String isjj;		// 是否加急：默认0不加急，1为加急订单
	private String category;		// 订单类别：匹配现货，新订单，储备订单，试制订单等
	private Office bsc;		// 办事处ID
	private QkBasicJxsinfo jxs;		// 经销商ID：下订单的单位
	private String cccxh;		//成车车型号
	private String cltype;		// 车辆类型：底盘，货车，仓栅，厢式，冷藏车等
	private String cl_Type;		//车辆类型名称
	private String sl;		// 数量
	private String dpcost;		// 底盘结算价
	private String dpprice;		// 底盘经销价
	private String cccost;		// 成车结算价
	private String ccprice;		// 成车经销价
	private String hgzcxh;		// 合格证车型号
	private String isgz;		// 是否改装：默认0不改装；1进行改装
	private String gzfs;		// 改装方式
	private String dyyzx;		// 打印一致性证书：默认1打印，0不打印
	private QkBasicStock sdck;		// 送达仓库
	private Date yqsddate;		// 要求送达日期：由经销商下订单时填入，但不能写太近的日期，设置参数最少增加多少天。
	private String qtscyq;		// qtscyq
	private String fplb;		// 发票类别
	private String xgcs;		// 修改次数
	private String djzt;		// 单据状态
	private String bb;		// 版本
	private String hth;		// 合同号
	private User shuser;		// 审核人
	private Date shdate;		// 审核日期
	private String shremark;		// 审核备注
	private User spuser;		// 审批人
	private Date spdate;		// 审批日期
	private String spremark;		// 审批备注
	private String hgzcxms; 		//合格证车型描述
	private String flag;
	private String xjzpzms;		//选加装配置描述
	private String gzms;		//改装描述
	private String isPass;		//审核是否通过
	private String isggfdj;		//是否更改发动机
	private String ocSize;		//判断是否正在撤消，大于0表明此订单存在撤单表里且正在撤单，等于0表示未撤单或已撤单完毕
	private String omSize;		//判断是否正在修改，大于0表明此订单存在修改订单表里且正在修改，等于0表示未修改或已修改完毕
	private String rkSize;		//判断是否有入库车辆，大于0表明此订单存在已入库的车辆，等于0表示没有已入库车辆
	private String xsdSize;		//判断是否生成销售单，大于0表明此订单生成销售单，等于0表示没有生成销售单
	private String xpcost;		// 选配结算价
	private String xpprice;		// 选配经销价
	private String gzcost;		// 改装结算价
	private String gzprice;		// 改装经销价
	private String beginDjzt;		// 开始单据状态值
	private String endDjzt;		// 结束 单据状态值
	private String sqlStr;
	private String isAllOrders;
	private QkYwOrders cbdd;
	private String isgzh;	//是否改制
	private String gzhremark;	//改制说明
	private String dcNum;
	private QkYwOrders newOrder;
	private QkBasicJxsinfo rwjxs;		// 经销商网络
	private String cancelNum;
	private String gzCltype;	//改装车类别
	
	private String area;//片区
	private String area_temp;//存放片区的parent_ids+id
	
	private String hgzqtsm;//合格证其他说明
	//20170913与生产系统对接
	private String hxzt;//生产订单表回写状态
	private String dpcxms;//底盘车型描述 
	
	//20170927增加按时间段查询
	private Date beginCreateDate;		// 开始 更新时间
	private Date endCreateDate;		// 结束 更新时间
	
	//增加销管审批时间查询
	private Date beginSpdate;
	private Date endSpdate;
	private String ywmsxgSize; //该销售单号正在修改业务模式的单据数量
	
	//20172101增加排产size
	private String pcSize;
	
	//20180305增加
	private String dyyzxejd;//打印一致性二阶段
	
	//20180308增加
	private int cbppCount;
	
	public QkYwOrders() {
		super();
		this.isPass="1";
	}

	public QkYwOrders(String id){
		super(id);
		this.isPass="1";
		//this.isgz="0";
		//this.dyyzx="0";
	}
	public QkYwOrders(String id,String ddh){
		super(id);
		this.isPass="1";
		this.ddh=ddh;
		//this.isgz="0";
		//this.dyyzx="0";
	}

//	@Length(min=1, max=50, message="订单号，订单表中的订单IDyi是订单号，不再需要另外一个唯一ID，调拨时需要产生新号，办事处拆分或者合并时，需要考虑的是办事处的ID，而不是订单的ID长度必须介于 1 和 50 之间")
	public String getDdh() {
		return ddh;
	}

	public void setDdh(String ddh) {

		this.ddh = ddh;
	}
	
	@Length(min=1, max=11, message="业务模式长度必须介于 1 和 11 之间")
	public String getYwms() {
		return ywms;
	}

	public void setYwms(String ywms) {
		this.ywms = ywms;
	}
	
	@Length(min=1, max=11, message="是否加急：默认0不加急，1为加急订单长度必须介于 1 和 11 之间")
	public String getIsjj() {
		return isjj;
	}

	public void setIsjj(String isjj) {
		this.isjj = isjj;
	}
	
	@Length(min=1, max=11, message="订单类别：匹配现货，新订单，储备订单，试制订单等长度必须介于 1 和 11 之间")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
	
	@Length(min=1, max=11, message="车辆类型：底盘，货车，仓栅，厢式，冷藏车等长度必须介于 1 和 11 之间")
	public String getCltype() {
		return cltype;
	}

	public void setCltype(String cltype) {
		this.cltype = cltype;
	}	
	

//	public String getCl_Type() {
//		return DictUtils.getDictLabel(cltype, "cltype", "");
//	}

	@Length(min=1, max=11, message="数量长度必须介于 1 和 11 之间")
	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}
	
	public String getDpcost() {
		return dpcost;
	}

	public void setDpcost(String dpcost) {
		this.dpcost = dpcost;
	}
	
	public String getDpprice() {
		return dpprice;
	}

	public void setDpprice(String dpprice) {
		this.dpprice = dpprice;
	}
	
	public String getCccost() {
		return cccost;
	}

	public void setCccost(String cccost) {
		this.cccost = cccost;
	}
	
	public String getCcprice() {
		return ccprice;
	}

	public void setCcprice(String ccprice) {
		this.ccprice = ccprice;
	}		

	public String getHgzcxh() {
		return hgzcxh;
	}

	public void setHgzcxh(String hgzcxh) {
		this.hgzcxh = hgzcxh;
	}

	@Length(min=0, max=11, message="是否改装：默认0不改装；1进行改装长度必须介于 0 和 11 之间")
	public String getIsgz() {
		return isgz;
	}

	
	public void setIsgz(String isgz) {
		this.isgz = isgz;
	}
	
	@Length(min=0, max=11, message="改装方式长度必须介于 0 和 11 之间")
	public String getGzfs() {
		return gzfs;
	}

	public void setGzfs(String gzfs) {
		this.gzfs = gzfs;
	}
	
	@Length(min=1, max=11, message="打印一致性证书：默认1打印，0不打印长度必须介于 1 和 11 之间")
	public String getDyyzx() {
		return dyyzx;
	}

	public void setDyyzx(String dyyzx) {
		this.dyyzx = dyyzx;
	}	
	
	public QkBasicStock getSdck() {
		return sdck;
	}

	public void setSdck(QkBasicStock sdck) {
		this.sdck = sdck;
	}	
	


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYqsddate() {
		return yqsddate;
	}

	public void setYqsddate(Date yqsddate) {
		this.yqsddate = yqsddate;
	}
	
	@Length(min=0, max=2000, message="qtscyq长度必须介于 0 和 2000 之间")
	public String getQtscyq() {
		return qtscyq;
	}

	public void setQtscyq(String qtscyq) {
		this.qtscyq = qtscyq;
	}
	
	@Length(min=0, max=11, message="发票类别长度必须介于 0 和 11 之间")
	public String getFplb() {
		return fplb;
	}

	public void setFplb(String fplb) {
		this.fplb = fplb;
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
	
	@Length(min=1, max=11, message="版本长度必须介于 1 和 11 之间")
	public String getBb() {
		return bb;
	}

	public void setBb(String bb) {
		this.bb = bb;
	}
	
	@Length(min=0, max=50, message="合同号长度必须介于 0 和 50 之间")
	public String getHth() {
		return hth;
	}

	public void setHth(String hth) {
		this.hth = hth;
	}	
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getShdate() {
		return shdate;
	}

	public void setShdate(Date shdate) {
		this.shdate = shdate;
	}
	
	@Length(min=0, max=512, message="审核备注长度必须介于 0 和 512 之间")
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
	
	@Length(min=0, max=512, message="审批备注长度必须介于 0 和 512 之间")
	public String getSpremark() {
		return spremark;
	}

	public void setSpremark(String spremark) {
		this.spremark = spremark;
	}	



	public String getHgzcxms() {
		return hgzcxms;
	}

	public void setHgzcxms(String hgzcxms) {
		if(hgzcxms != null && hgzcxms.indexOf("&times;")>-1){
			this.hgzcxms=hgzcxms.replace("&times;", "×");
		}else{
			this.hgzcxms = hgzcxms;
		}
	}

	
	public String getCccxh() {
		return cccxh;
	}

	public void setCccxh(String cccxh) {
		this.cccxh = cccxh;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getXjzpzms() {
		return xjzpzms;
	}

	public void setXjzpzms(String xjzpzms) {
		this.xjzpzms = xjzpzms;
	}

	public String getGzms() {
		return gzms;
	}

	public void setGzms(String gzms) {
		this.gzms = gzms;
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

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	public String getIsggfdj() {
		return isggfdj;
	}

	public void setIsggfdj(String isggfdj) {
		this.isggfdj = isggfdj;
	}

	public String getOcSize() {
		return ocSize;
	}

	public void setOcSize(String ocSize) {
		this.ocSize = ocSize;
	}

	public String getOmSize() {
		return omSize;
	}

	public void setOmSize(String omSize) {
		this.omSize = omSize;
	}

	public String getXpcost() {
		return xpcost;
	}

	public void setXpcost(String xpcost) {
		this.xpcost = xpcost;
	}

	public String getXpprice() {
		return xpprice;
	}

	public void setXpprice(String xpprice) {
		this.xpprice = xpprice;
	}

	public String getGzcost() {
		return gzcost;
	}

	public void setGzcost(String gzcost) {
		this.gzcost = gzcost;
	}

	public String getGzprice() {
		return gzprice;
	}

	public void setGzprice(String gzprice) {
		this.gzprice = gzprice;
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



	public String getSqlStr() {
		return sqlStr;
	}

	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}



	public String getIsAllOrders() {
		return isAllOrders;
	}

	public void setIsAllOrders(String isAllOrders) {
		this.isAllOrders = isAllOrders;
	}

	public String getRkSize() {
		return rkSize;
	}

	public void setRkSize(String rkSize) {
		this.rkSize = rkSize;
	}

	public String getXsdSize() {
		return xsdSize;
	}

	public void setXsdSize(String xsdSize) {
		this.xsdSize = xsdSize;
	}

	public QkYwOrders getCbdd() {
		return cbdd;
	}

	public void setCbdd(QkYwOrders cbdd) {
		this.cbdd = cbdd;
	}

	public String getIsgzh() {
		return isgzh;
	}

	public void setIsgzh(String isgzh) {
		this.isgzh = isgzh;
	}

	public String getGzhremark() {
		return gzhremark;
	}

	public void setGzhremark(String gzhremark) {
		if(gzhremark != null && gzhremark.indexOf("&times;")>-1){
			this.gzhremark=gzhremark.replace("&times;", "×");
		}else{
			this.gzhremark = gzhremark;
		}
	}

	public String getDcNum() {
		return dcNum;
	}

	public void setDcNum(String dcNum) {
		this.dcNum = dcNum;
	}

	public QkYwOrders getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(QkYwOrders newOrder) {
		this.newOrder = newOrder;
	}

	public QkBasicJxsinfo getRwjxs() {
		return rwjxs;
	}

	public void setRwjxs(QkBasicJxsinfo rwjxs) {
		this.rwjxs = rwjxs;
	}

	public String getCancelNum() {
		return cancelNum;
	}

	public void setCancelNum(String cancelNum) {
		this.cancelNum = cancelNum;
	}

	public String getGzCltype() {
		return gzCltype;
	}

	public void setGzCltype(String gzCltype) {
		this.gzCltype = gzCltype;
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

	public String getHgzqtsm() {
		return hgzqtsm;
	}

	public void setHgzqtsm(String hgzqtsm) {
		this.hgzqtsm = hgzqtsm;
	}

	public String getHxzt() {
		return hxzt;
	}

	public void setHxzt(String hxzt) {
		this.hxzt = hxzt;
	}

	public String getDpcxms() {
		return dpcxms;
	}

	public void setDpcxms(String dpcxms) {
		this.dpcxms = dpcxms;
	}

	public Date getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(Date beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}

	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}

	public Date getBeginSpdate() {
		return beginSpdate;
	}

	public void setBeginSpdate(Date beginSpdate) {
		this.beginSpdate = beginSpdate;
	}

	public Date getEndSpdate() {
		return endSpdate;
	}

	public void setEndSpdate(Date endSpdate) {
		this.endSpdate = endSpdate;
	}

	public String getYwmsxgSize() {
		return ywmsxgSize;
	}

	public void setYwmsxgSize(String ywmsxgSize) {
		this.ywmsxgSize = ywmsxgSize;
	}

	public String getPcSize() {
		return pcSize;
	}

	public void setPcSize(String pcSize) {
		this.pcSize = pcSize;
	}

    public String getDyyzxejd() {
        return dyyzxejd;
    }

    public void setDyyzxejd(String dyyzxejd) {
        this.dyyzxejd = dyyzxejd;
    }

    public int getCbppCount() {
        return cbppCount;
    }

    public void setCbppCount(int cbppCount) {
        this.cbppCount = cbppCount;
    }
}
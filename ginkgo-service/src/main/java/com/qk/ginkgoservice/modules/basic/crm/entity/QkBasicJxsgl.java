package com.qk.ginkgoservice.modules.basic.crm.entity; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import com.qk.ginkgoservice.common.persistence.DataEntity;
import com.qk.ginkgoservice.modules.sys.entity.Dict;
import org.apache.commons.lang3.StringUtils;
import java.util.Date;
import java.util.List;
import com.google.common.collect.Lists;

/**
 * 经销商管理Entity
 * 
 * @author qk
 * @version 2016-12-23
 */
public class QkBasicJxsgl extends DataEntity<QkBasicJxsgl> {

    private static final long serialVersionUID = 1L;
    private QkBasicJxsrw rwjxs; // 经销商ID
    private String yxwddts; // 允许无订单天数
    private String yxzdkcts; // 允许最大库存天数
    private String canorder; // 可否提报订单
    private String bzjbl; // 保证金比例
    private String bzjje; // 保证金金额
    private String bzjtpje; // 保证金特批金额
    private String bzjsyed; // 保证金使用额度
    private String canfc; // 可否发车：默认1，可以
    private String dqdj; // 大区独家：0，否 （目前无用，福泺时设置）
    private String qyzc; // 区域政策 （运费的增加）
    private String ywms;
    private String minye; // 提报订单业务模式额度限制
    private Date cwtbddjzsj;// 超五提报订单截止时间
    private String rwjxscode;
    private String jxsname;
    private String bscname;
    private String wlsx;
    private String citygrade;
    private String dwxz;
    private String areatype;
    
    private String sqlstr;
    private String jxsid;//父级经销商id
    private String userid;
    

    private List<Dict> ywmsList = Lists.newArrayList();

    public QkBasicJxsgl() {
        super();
    }

    public QkBasicJxsgl(String id) {
        super(id);
    }


    public QkBasicJxsgl(String id,QkBasicJxsrw rwjxs) {
        super(id);
        this.setRwjxs(rwjxs);
    }


    public String getYxwddts() {
        return yxwddts;
    }

    public void setYxwddts(String yxwddts) {
        this.yxwddts = yxwddts;
    }

 
    public String getYxzdkcts() {
        return yxzdkcts;
    }

    public void setYxzdkcts(String yxzdkcts) {
        this.yxzdkcts = yxzdkcts;
    }

  
    public String getCanorder() {
        return canorder;
    }

    public void setCanorder(String canorder) {
        this.canorder = canorder;
    }

    public String getBzjbl() {
        return bzjbl;
    }

    public void setBzjbl(String bzjbl) {
        this.bzjbl = bzjbl;
    }

    public String getBzjje() {
        return bzjje;
    }

    public void setBzjje(String bzjje) {
        this.bzjje = bzjje;
    }

    
    public String getBzjtpje() {
        return bzjtpje;
    }

    public void setBzjtpje(String bzjtpje) {
        this.bzjtpje = bzjtpje;
    }

    public String getBzjsyed() {
        return bzjsyed;
    }

    public void setBzjsyed(String bzjsyed) {
        this.bzjsyed = bzjsyed;
    }


    public String getCanfc() {
        return canfc;
    }

    public void setCanfc(String canfc) {
        this.canfc = canfc;
    }
  
    public String getDqdj() {
        return dqdj;
    }

    public void setDqdj(String dqdj) {
        this.dqdj = dqdj;
    }

    public String getQyzc() {
        return qyzc;
    }

    public void setQyzc(String qyzc) {
        this.qyzc = qyzc;
    }

    public List<Dict> getYwmsList() {
        return ywmsList;
    }

    public void setYwmsList(List<Dict> ywmsList) {
        this.ywmsList = ywmsList;
    }


    public String getYwms() {
        return ywms;
    }

    public void setYwms(String ywms) {
        this.ywms = ywms;
    }

    public List<String> getYwmsValueList() {
        List<String> ywmsValueList = Lists.newArrayList();
        for (Dict ywms : ywmsList) {
            ywmsValueList.add(ywms.getValue());
        }
        return ywmsValueList;
    }

    public void setYwmsValueList(List<String> ywmsValueList) {
        ywmsList = Lists.newArrayList();
        for (String ywmsValue : ywmsValueList) {
            Dict ywms = new Dict();
            ywms.setValue(ywmsValue);
            ywmsList.add(ywms);
        }
    }

    public String getYwmsValues() {
        return StringUtils.join(getYwmsValueList(), ",");

    }

    public void setYwmsValues(String ywmsValues) {
        ywmsList = Lists.newArrayList();
        if (ywmsValues != null) {
            String[] values = StringUtils.split(ywmsValues, ",");
            setYwmsValueList(Lists.newArrayList(values));
        }
    }

    public String getMinye() {
        return minye;
    }

    public void setMinye(String minye) {
        this.minye = minye;
    }

    public Date getCwtbddjzsj() {
        return cwtbddjzsj;
    }

    public void setCwtbddjzsj(Date cwtbddjzsj) {
        this.cwtbddjzsj = cwtbddjzsj;
    }

    public String getRwjxscode() {
        return rwjxscode;
    }

    public void setRwjxscode(String rwjxscode) {
        this.rwjxscode = rwjxscode;
    }

    public QkBasicJxsrw getRwjxs() {
        return rwjxs;
    }

    public void setRwjxs(QkBasicJxsrw rwjxs) {
        this.rwjxs = rwjxs;
    }

    public String getJxsname() {
        return jxsname;
    }

    public void setJxsname(String jxsname) {
        this.jxsname = jxsname;
    }

    public String getBscname() {
        return bscname;
    }

    public void setBscname(String bscname) {
        this.bscname = bscname;
    }

    public String getWlsx() {
        return wlsx;
    }

    public void setWlsx(String wlsx) {
        this.wlsx = wlsx;
    }

    public String getCitygrade() {
        return citygrade;
    }

    public void setCitygrade(String citygrade) {
        this.citygrade = citygrade;
    }

    public String getDwxz() {
        return dwxz;
    }

    public void setDwxz(String dwxz) {
        this.dwxz = dwxz;
    }

    public String getSqlstr() {
        return sqlstr;
    }

    public void setSqlstr(String sqlstr) {
        this.sqlstr = sqlstr;
    }

    public String getJxsid() {
        return jxsid;
    }

    public void setJxsid(String jxsid) {
        this.jxsid = jxsid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAreatype() {
        return areatype;
    }

    public void setAreatype(String areatype) {
        this.areatype = areatype;
    }


}

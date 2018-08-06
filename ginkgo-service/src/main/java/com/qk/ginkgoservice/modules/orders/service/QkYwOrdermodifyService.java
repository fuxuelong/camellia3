package com.qk.ginkgoservice.modules.orders.service; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.qk.ginkgoservice.common.persistence.CrudService;
import com.qk.ginkgoservice.modules.orders.dao.QkYwOrdermodifyDao;
import com.qk.ginkgoservice.modules.orders.entity.QkYwOrdermodify;
import com.qk.ginkgoservice.modules.sys.entity.User;
import com.qk.ginkgoservice.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 订单修改Service
 * 
 * @author zoneo
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class QkYwOrdermodifyService extends CrudService<QkYwOrdermodifyDao, QkYwOrdermodify> {

    @Autowired
    private QkYwOrdermodifyDao qkYwOrdermodifyDao;
//    @Autowired
//    private QkYwDdpzmxDao qkYwDdpzmxDao;
//    @Autowired
//    private QkYwOrdersTempDao qkYwOrdersTempDao;
//    @Autowired
//    private QkYwOrdersDao qkYwOrdersDao;
//    @Autowired
//    private QkYwTrucksDao qkYwTrucksDao;
//    @Autowired
//    private QkYwOrdersService qkYwOrdersService;
//    @Autowired
//    private QkYwDdpzmxzjbDao qkYwDdpzmxzjbDao;
//    @Autowired
//    private QkYwDdgzpzmxDao qkYwDdgzpzmxDao;
//    @Autowired
//    private QkYwDdgzxpDao qkYwDdgzxpDao;
//    @Autowired
//    private QkYwDdbpDao qkYwDdbpDao;


//    public List<QkYwOrdermodify> findList(QkYwOrdermodify qkYwOrdermodify) {
//        qkYwOrdermodify.getSqlMap().put("dsf", dataScopeFilter(UserUtils.getUser(), "o", "u"));
//        return super.findList(qkYwOrdermodify);
//    }

    /**
     * 查询待审核订单修改
     * */
    public List<Map<String,String>> findOrdermodifyList(QkYwOrdermodify qkYwOrdermodify){
        qkYwOrdermodify.getSqlMap().put("dsf", dataScopeFilter(UserUtils.getUser(), "o", "u"));
        return qkYwOrdermodifyDao.findOrdermodifyList(qkYwOrdermodify);
    }


    @Override
    @Transactional(readOnly = false)
    public void save(QkYwOrdermodify qkYwOrdermodify) {
        super.save(qkYwOrdermodify);
    }

    @Transactional(readOnly = false)
    public void insert(QkYwOrdermodify qkYwOrdermodify) {
        User user = UserUtils.getUser();
        if (StringUtils.isNotBlank(user.getId())) {
            qkYwOrdermodify.setUpdateBy(user);
            qkYwOrdermodify.setCreateBy(user);
        }
        qkYwOrdermodify.setUpdateDate(new Date());
        qkYwOrdermodify.setCreateDate(new Date());
        qkYwOrdermodifyDao.insert(qkYwOrdermodify);
    }




//    /**
//     * 订单修改审核通过
//     *
//     * @param qkYwOrdermodify
//     * @param dd
//     */
//    @Transactional(readOnly = false)
//    public void SHaccept(QkYwOrdermodify qkYwOrdermodify, QkYwOrders dd) {
//        int sl = Integer.parseInt(dd.getSl());
//        Date date = new Date();
//
//        //将订单标配表里该订单对应修改次数-1的标配记录删除
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("ddh",dd.getDdh());
//        map.put("xgcs",Integer.parseInt(dd.getXgcs()) - 1);
//        List<String> bpList = qkYwDdbpDao.findBpList(map);
//        if(bpList != null && bpList.size() > 0){
//            qkYwDdbpDao.deleteBpList(map);
//        }
//
//        // 转让、储备匹配订单修改时生成改制单 改制单审批通过修改记录的状态不变
//        qkYwOrdermodify.setDjzt("35");// 修改审批通过
//        dd.setDjzt("35");// 订单已修改
//        QkYwDdpzmx pzmx = new QkYwDdpzmx();
//        pzmx.setDd(dd);
//        pzmx.setXgcs(dd.getXgcs());
//        qkYwDdpzmxDao.deleteDdPz(pzmx);// 在正式配置表中删除原发送生产的配置
//        qkYwDdpzmxDao.insertToZsPzMx(pzmx);// 将发送到生产的新配置插入表中
//        QkYwOrders ddTemp = new QkYwOrders();
//        ddTemp.setNewOrder(dd);
//        qkYwOrdersTempDao.delete(qkYwOrdersTempDao.get(ddTemp));// 删除修改前的订单信息
//        qkYwOrdersDao.updateDdDjzt(dd);// 订单状态修改为修改订单
//
//        QkYwTrucks trucks = new QkYwTrucks();
//        trucks.setDd(dd);
//        trucks.setCxms(dd.getXjzpzms());
//        trucks.setGzms(dd.getGzms());
//        trucks.setUpdateBy(dd.getUpdateBy());
//        trucks.setUpdateDate(date);
//        String ccPrice = String.valueOf(Double.parseDouble(dd.getCcprice()) / sl);
//        trucks.setCcprice(ccPrice);
//        String hgzinfo = qkYwOrdersService.getHgzcxhAndHgzcllx(dd.getHgzcxh(), dd.getHgzcxms());
//        if (hgzinfo != null) {
//            trucks.setHgzinfo(hgzinfo);
//        }
//        qkYwTrucksDao.updateCxms(trucks);
//    }
//
//    /**
//     * 订单修改审核驳回
//     *
//     * @param qkYwOrdermodify
//     * @param dd
//     */
//    @Transactional(readOnly = false)
//    public void SHreject(QkYwOrdermodify qkYwOrdermodify, QkYwOrders dd, String flag) {
//            QkYwTrucks t = new QkYwTrucks(null, dd);
//            List<QkYwTrucks> trucksList = qkYwTrucksDao.findList(t);
//
//            int sl = Integer.parseInt(dd.getSl());
//
//            String bgreason = "";
//
//            if (flag.equals("-35")) {
//                qkYwOrdermodify.setDjzt("-35");// 修改审批驳回
//                bgreason = "修改申请审批驳回";
//            } else if (flag.equals("-15")) {
//                qkYwOrdermodify.setDjzt("-15");// 修改审核驳回
//                bgreason = "修改申请审核驳回";
//            } else if (flag.equals("-100")) {
//                qkYwOrdermodify.setDjzt("-100");// 修改审核驳回
//                bgreason = "修改申请取消";
//            }
//
//        //将订单标配表里该订单对应修改次数的标配记录删除
//        HashMap<String, Object> map = new HashMap<String, Object>();
//            map.put("ddh",dd.getDdh());
//            map.put("xgcs",dd.getXgcs());
//        List<String> bpList = qkYwDdbpDao.findBpList(map);
//        if(bpList != null && bpList.size() > 0){
//            qkYwDdbpDao.deleteBpList(map);
//        }
//
//        QkYwOrders ddTemp = new QkYwOrders();
//            ddTemp.setNewOrder(dd);
//            ddTemp = qkYwOrdersTempDao.get(ddTemp);// 取回修改前的订单信息
//            dd.setYs(ddTemp.getYs());
//            dd.setHgzcxh(ddTemp.getHgzcxh());
//            dd.setHgzcxms(ddTemp.getHgzcxms());
//            dd.setHgzqtsm(ddTemp.getHgzqtsm());
//            dd.setGzc(ddTemp.getGzc());
//            dd.setGzfs(ddTemp.getGzfs());
//            dd.setGzms(ddTemp.getGzms());
//            dd.setGzCltype(ddTemp.getGzCltype());
//            dd.setGzcost(ddTemp.getGzcost());
//            dd.setGzprice(ddTemp.getGzprice());
//            dd.setXgcs(ddTemp.getXgcs());
//            dd.setDjzt(ddTemp.getDjzt());
//            dd.setDpcost(ddTemp.getDpcost());
//            dd.setDpprice(ddTemp.getDpprice());
//            dd.setCccost(ddTemp.getCccost());
//            dd.setCcprice(ddTemp.getCcprice());
//            dd.setXpcost(ddTemp.getXpcost());
//            dd.setXpprice(ddTemp.getXpprice());
//            dd.setXjzpzms(ddTemp.getXjzpzms());
//            dd.setGzms(ddTemp.getGzms());
//            dd.setShdate(ddTemp.getShdate());
//            dd.setShuser(ddTemp.getShuser());
//            dd.setShremark(ddTemp.getShremark());
//            dd.setSpdate(ddTemp.getSpdate());
//            dd.setSpuser(ddTemp.getSpuser());
//            dd.setSpremark(ddTemp.getSpremark());
//            dd.setDpcxms(ddTemp.getDpcxms());
//            dd.setIsgz(ddTemp.getIsgz());
//            qkYwOrdersDao.update(dd);// 将修改后的订单信息更新成原订单信息
//            qkYwOrdersTempDao.delete(ddTemp);// 删除临时表中所存的原订单信息
//            qkYwDdpzmxzjbDao
//                    .deleteDdPz(new QkYwDdpzmxzjb(null, dd, null, null, qkYwOrdermodify.getXgcs()));// 删除
//            qkYwDdgzpzmxDao.deleteDdGzPz(new QkYwDdgzpzmx(null, dd, qkYwOrdermodify.getXgcs()));
//            qkYwDdgzxpDao.deleteDdGzXp(new QkYwDdgzxp(null, dd, qkYwOrdermodify.getXgcs()));
//            double cj = Double.parseDouble(qkYwOrdermodify.getXpcj())
//                    + Double.parseDouble(qkYwOrdermodify.getGzcj());
//
//            // 20171221循环trucks 修改经销商的额度
//            for (QkYwTrucks t1 : trucksList) {
//                JxstUtils.updateJxsUsedLine(dd.getRwjxs(), t1.getYwms(),
//                        "-" + String.valueOf(cj / sl), dd.getDdh() + bgreason);
//            }
//
//            qkYwOrdermodifyDao.updateDdDjzt(qkYwOrdermodify);
//
//    }
}

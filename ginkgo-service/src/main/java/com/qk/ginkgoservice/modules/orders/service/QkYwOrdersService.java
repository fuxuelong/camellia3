/**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */
package com.qk.ginkgoservice.modules.orders.service;


import com.qk.ginkgoservice.common.persistence.CrudService;
import com.qk.ginkgoservice.modules.orders.dao.QkYwOrdersDao;
import com.qk.ginkgoservice.modules.orders.entity.QkYwOrders;
import com.qk.ginkgoservice.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 经销商订单提报Service
 * 
 * @author QkEip
 * @version 2016-12-23
 */
@Service
@Transactional(readOnly = true)
public class QkYwOrdersService extends CrudService<QkYwOrdersDao, QkYwOrders> {
    @Autowired
    private QkYwOrdersDao qkYwOrdersDao;

    /**
     * 查询订单信息
     * */
    public List<Map<String,String>> findOrdersSimpleInfoList(QkYwOrders qkYwOrders){
        qkYwOrders.getSqlMap().put("dsf", dataScopeFilter(UserUtils.getUser(), "o", "u"));
        return qkYwOrdersDao.findOrdersSimpleInfoList(qkYwOrders);
    }
}

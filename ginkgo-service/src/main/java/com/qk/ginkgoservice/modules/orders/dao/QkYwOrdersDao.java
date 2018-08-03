/**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */
package com.qk.ginkgoservice.modules.orders.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qk.ginkgoservice.common.persistence.CrudDao;
import com.qk.ginkgoservice.modules.orders.entity.QkYwOrders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 经销商订单提报DAO接口
 * 
 * @author QkEip
 * @version 2016-12-23
 */
@Mapper
@Component
public interface QkYwOrdersDao extends CrudDao<QkYwOrders> {

    /**
     * @param qkYwOrders
     * 查询订单简略信息
     * */
    List<Map<String,String>> findOrdersSimpleInfoList(QkYwOrders qkYwOrders);
}

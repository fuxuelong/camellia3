 /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */
 package com.qk.ginkgoservice.modules.orders.dao;
import com.qk.ginkgoservice.common.persistence.CrudDao;
import com.qk.ginkgoservice.modules.orders.entity.QkYwOrdermodify;
import com.qk.ginkgoservice.modules.orders.entity.QkYwOrders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

 /**
 * 订单修改DAO接口
 * @author fuxuelong
 */
@Mapper
@Component
public interface QkYwOrdermodifyDao extends CrudDao<QkYwOrdermodify> {
    /**
     * 查询订单修改列表
     * @param qkYwOrdermodify
     * @return
     * */
    List<Map<String,String>> findOrdermodifyList(QkYwOrdermodify qkYwOrdermodify);
}

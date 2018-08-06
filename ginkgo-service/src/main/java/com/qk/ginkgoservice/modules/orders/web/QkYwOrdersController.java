/**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */
package com.qk.ginkgoservice.modules.orders.web;

import com.qk.ginkgoservice.common.web.BaseController;
import com.qk.ginkgoservice.modules.orders.dao.QkYwOrdersDao;
import com.qk.ginkgoservice.modules.orders.entity.QkYwOrders;
import com.qk.ginkgoservice.modules.orders.service.QkYwOrdersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 订单Controller
 * 
 * @author QkEip
 * @version 2016-12-23
 */
@RestController
@RequestMapping(value = "/orders")
public class QkYwOrdersController {

    @Autowired
    QkYwOrdersService qkYwOrdersService;

    @PostMapping(value = "/findOrdersSimpleInfoList")
    @ApiOperation(value = "获取订单简单信息",notes = "查询订单的简单信息列表，用于APP订单列表显示")
    public List<Map<String,String>> findOrdersSimpleInfoList(QkYwOrders qkYwOrders){
        return  qkYwOrdersService.findOrdersSimpleInfoList(qkYwOrders);
    }
}

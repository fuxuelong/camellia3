package com.qk.ginkgoservice.modules.orders.web;

import com.qk.ginkgoservice.modules.orders.entity.QkYwOrdermodify;
import com.qk.ginkgoservice.modules.orders.service.QkYwOrdermodifyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 订单修改Controller
 * @author fuxuelong
 */
@RestController
@RequestMapping(value = "ordermodify")
public class QkYwOrdermodifyController {
    @Autowired
    private QkYwOrdermodifyService qkYwOrdermodifyService;


    @PostMapping(value = "findOrdermodifyShList")
    @ApiOperation(value = "获取办事处待审核订单信息",notes = "查询状态为办事处待审核的订单信息")
    public List<Map<String,String>> findOrdermodifyShList(){
        QkYwOrdermodify qkYwOrdermodify = new QkYwOrdermodify();
        /** 只查询单据状态为“经销商提报”的信息*/
        qkYwOrdermodify.setDjzt("5");
        return qkYwOrdermodifyService.findOrdermodifyList(qkYwOrdermodify);
    }

    @PostMapping(value = "findOrdermodifySpList")
    @ApiOperation(value = "获取办事处待审核订单信息",notes = "查询状态为办事处待审核的订单信息")
    public List<Map<String,String>> findOrdermodifySpList(){
        QkYwOrdermodify qkYwOrdermodify = new QkYwOrdermodify();
        /** 查询单据状态为“分公司审核通过”、“已提交生产”的信息*/
        qkYwOrdermodify.setBeginDjzt("15");
        qkYwOrdermodify.setEndDjzt("25");
        return qkYwOrdermodifyService.findOrdermodifyList(qkYwOrdermodify);
    }
 }

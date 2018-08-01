package com.qk.ginkgoservice.modules.basic.crm.web;

import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsinfo;
import com.qk.ginkgoservice.modules.basic.crm.service.QkBasicJxsinfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fuxuelong
 */
@RestController
@RequestMapping(value = "qkBasicJxsinfo")
public class QkBasicJxsinfoController {
    @Autowired
    QkBasicJxsinfoService qkBasicJxsinfoService;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @ApiOperation(value = "获取经销商", notes = "根据经销商编码获取单个经销商实体，")
    @PostMapping(value = "/getJxsByCode")
    public QkBasicJxsinfo getJxsByCode(String code){
        QkBasicJxsinfo qkBasicJxsinfo = qkBasicJxsinfoService.getJxsByCode(code);
        return qkBasicJxsinfo;
    }
    @PostMapping(value = "/testFindList")
    public List<QkBasicJxsinfo> testFindList(){
        return qkBasicJxsinfoService.findList(new QkBasicJxsinfo());
    }
}

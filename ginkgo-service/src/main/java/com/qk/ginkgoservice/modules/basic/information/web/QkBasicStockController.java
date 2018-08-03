package com.qk.ginkgoservice.modules.basic.information.web;

import com.alibaba.fastjson.JSON;
import com.qk.ginkgoservice.common.exception.MessageCode;
import com.qk.ginkgoservice.modules.basic.information.dao.QkBasicStockDao;
import com.qk.ginkgoservice.modules.basic.information.entity.QkBasicStock;
import com.qk.ginkgoservice.modules.basic.information.service.QkBasicStockService;
import com.qk.ginkgoservice.modules.sys.dto.RespDTO;
import com.qk.ginkgoservice.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fuxuelong
 */
@RestController
@RequestMapping(value = "/stock")
public class QkBasicStockController {
    @Autowired
    QkBasicStockService qkBasicStockService;
    @Autowired
    QkBasicStockDao qkBasicStockDao;
    @PostMapping(value = "/getByStockCode")
    public String getByStockCode(String stockcode){
        return  qkBasicStockService.getByStockCode(stockcode).get(0).getStockname();
    }
    @PostMapping(value = "findStockList")
    public RespDTO<List<QkBasicStock>> findStockList(QkBasicStock qkBasicStock){
        RespDTO<List<QkBasicStock>> respDTO = new RespDTO<List<QkBasicStock>>();
        respDTO.data = qkBasicStockService.findStockList(qkBasicStock);
        respDTO.setMessageCode(MessageCode.SEARCH_SUCCESS);
        return respDTO;
    }
    @GetMapping(value = "findStockListGet")
    public List<QkBasicStock> findStockListget(QkBasicStock qkBasicStock){
        return qkBasicStockService.findStockList(qkBasicStock);
    }
    @PostMapping(value = "save")
    public String save(QkBasicStock qkBasicStock){
        qkBasicStock = qkBasicStockService.findStockList(qkBasicStock).get(0);
        qkBasicStock.setRemarks("测试保存");
        qkBasicStockService.save(qkBasicStock);
        return "save";
    }
    @PostMapping(value = "test")
    public String test(){

        return "success";
    }
}

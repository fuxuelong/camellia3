package com.qk.ginkgoservice.modules.basic.information.service; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.qk.ginkgoservice.modules.basic.information.dao.QkBasicStockDao;
import com.qk.ginkgoservice.modules.basic.information.entity.QkBasicStock;
import com.qk.ginkgoservice.common.persistence.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 仓库信息Service
 * 
 * @author qk
 * @version 2016-12-23
 */
@Service
@Transactional(readOnly = true)
public class QkBasicStockService extends CrudService<QkBasicStockDao, QkBasicStock> {

    @Autowired
    private QkBasicStockDao qkBasicStockDao;

    public List<QkBasicStock> getByStockCode(String stockcode){
        return  qkBasicStockDao.getByStockCode(stockcode);
    }

    public  List<QkBasicStock>  findStockList(QkBasicStock qkBasicStock){
        return  qkBasicStockDao.findStockList(qkBasicStock);
    }


}

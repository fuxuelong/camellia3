package com.qk.ginkgoservice.modules.basic.information.dao; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.qk.ginkgoservice.modules.basic.information.entity.QkBasicStock;
import com.qk.ginkgoservice.common.persistence.CrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 仓库信息DAO接口
 * 
 * @author qk
 * @version 2016-12-23
 */
@Mapper
@Component
public interface QkBasicStockDao extends CrudDao<QkBasicStock> {

    public List<QkBasicStock> getByStockCode(@Param("stockcode") String stockcode);

    public List<QkBasicStock> findMax(@Param("officeID") String officeID);
    
    public List<Map<String, String>> getPkStockList(QkBasicStock qkBasicStock);

    public List<QkBasicStock> findStockList(QkBasicStock qkBasicStock);

}

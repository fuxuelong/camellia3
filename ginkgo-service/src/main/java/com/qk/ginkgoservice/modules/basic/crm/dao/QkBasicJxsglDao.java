package com.qk.ginkgoservice.modules.basic.crm.dao; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import com.qk.ginkgoservice.common.persistence.CrudDao;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsgl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 经销商管理DAO接口
 * 
 * @author qk
 * @version 2016-12-23
 */
@Mapper
@Component
public interface QkBasicJxsglDao extends CrudDao<QkBasicJxsgl> {

    public QkBasicJxsgl getByJxsId(QkBasicJxsgl qkBasicJxsgl);

    public void updateUsedLines(QkBasicJxsgl qkBasicJxsgl);
    
    public void updateBzjbl();
    
    public void updateWlsx(QkBasicJxsgl qkBasicJxsgl);
    
    public void updateBzjje(QkBasicJxsgl qkBasicJxsgl);
    
    public int invoke_wlsxCalculate(String userid);

}

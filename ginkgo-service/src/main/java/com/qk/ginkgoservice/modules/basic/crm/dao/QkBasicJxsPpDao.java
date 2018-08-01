package com.qk.ginkgoservice.modules.basic.crm.dao; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */


import com.qk.ginkgoservice.common.persistence.CrudDao;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsPp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 经销商品牌维护DAO接口
 * 
 * @author qk
 * @version 2016-12-27
 */
@Mapper
@Component
public interface QkBasicJxsPpDao extends CrudDao<QkBasicJxsPp> {

    public List<QkBasicJxsPp> getJxsPp(QkBasicJxsPp qkBasicJxsPp);
    
    public List<QkBasicJxsPp> findCategoryByJxs(QkBasicJxsPp qkBasicJxsPp);

}

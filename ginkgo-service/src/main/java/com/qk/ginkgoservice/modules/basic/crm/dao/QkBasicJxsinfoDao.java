package com.qk.ginkgoservice.modules.basic.crm.dao; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import com.qk.ginkgoservice.common.persistence.CrudDao;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 经销商入网信息DAO接口
 * 
 * @author qk
 * @version 2016-12-14
 */
@Mapper
@Component
public interface QkBasicJxsinfoDao extends CrudDao<QkBasicJxsinfo> {

    /**
     * 根据经销商编码获取经销商
     * @param code
     * @return QkBasicJxsinfo
     * */
    QkBasicJxsinfo getJxsByCode(String code);



    /**
     * 根据父经销商查询经销商网络
     * @param jxsid
     * @return
     */
    List<QkBasicJxsinfo> findRwjxsByParentID(String jxsid);
}



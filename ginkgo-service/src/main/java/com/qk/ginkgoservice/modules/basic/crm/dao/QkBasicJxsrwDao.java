package com.qk.ginkgoservice.modules.basic.crm.dao; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import com.qk.ginkgoservice.common.persistence.CrudDao;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsrw;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 经销商入网管理DAO接口
 * 
 * @author qk
 * @version 2017-05-23
 */
@Mapper
@Component
public interface QkBasicJxsrwDao extends CrudDao<QkBasicJxsrw> {
    public List<QkBasicJxsrw> getByQkBasicJxsrwInfo(QkBasicJxsrw qkBasicJxsrw);

    public void updateJxsSpzt(QkBasicJxsrw qkBasicJxsrw);

    public String getJxscodeRW(String parentId);

    public void updateBG(QkBasicJxsrw qkBasicJxsrw);
    
    public int deleteJxsCategory(QkBasicJxsrw qkBasicJxsrw);

    // 20170720
    public List<QkBasicJxsrw> findListSH(QkBasicJxsrw qkBasicJxsrw);

    void insertIntoTemp(QkBasicJxsrw qkBasicJxsrw);

}

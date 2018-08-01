package com.qk.ginkgoservice.modules.basic.crm.service; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import java.util.List;

import com.qk.ginkgoservice.common.persistence.CrudService;
import com.qk.ginkgoservice.modules.basic.crm.dao.QkBasicJxsglDao;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsgl;
import com.qk.ginkgoservice.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 经销商管理Service
 * 
 * @author qk
 * @version 2016-12-23
 */
@Service
@Transactional(readOnly = true)
public class QkBasicJxsglService extends CrudService<QkBasicJxsglDao, QkBasicJxsgl> {
    @Autowired
    private QkBasicJxsglDao qkBasicJxsglDao;


    @Override
    public QkBasicJxsgl get(String id) {
        return super.get(id);
    }

    @Override
    public List<QkBasicJxsgl> findList(QkBasicJxsgl qkBasicJxsgl) {
        qkBasicJxsgl.getSqlMap().put("dsf", dataScopeFilter(UserUtils.getUser(), "o1", "u"));
        return super.findList(qkBasicJxsgl);
    }

    public List<QkBasicJxsgl> findParentJxsList(QkBasicJxsgl qkBasicJxsgl) {
        return super.findList(qkBasicJxsgl);
    }


   
    @Override
    @Transactional(readOnly = false)
    public void save(QkBasicJxsgl qkBasicJxsgl) {
       super.save(qkBasicJxsgl);
    }

    @Transactional(readOnly = false)
    public void updateUsedLines(QkBasicJxsgl qkBasicJxsgl) {
        qkBasicJxsglDao.updateUsedLines(qkBasicJxsgl);
    }


    @Override
    @Transactional(readOnly = false)
    public void delete(QkBasicJxsgl qkBasicJxsgl) {
        super.delete(qkBasicJxsgl);
    }

    /**
     * 通过经销商入网信息id查询经销商管理信息
     * 
     * @param qkBasicJxsgl
     * @return
     */
    public QkBasicJxsgl getByJxsId(QkBasicJxsgl qkBasicJxsgl) {
        return qkBasicJxsglDao.getByJxsId(qkBasicJxsgl);
    }
}

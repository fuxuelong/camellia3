package com.qk.ginkgoservice.modules.basic.crm.service; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import java.util.List;
import java.util.Map;

import com.qk.ginkgoservice.common.constant.Constant;
import com.qk.ginkgoservice.common.persistence.CrudService;
import com.qk.ginkgoservice.modules.basic.crm.dao.QkBasicJxsinfoDao;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsinfo;
import com.qk.ginkgoservice.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 经销商入网信息Service
 * 
 * @author qk
 * @version 2016-12-14
 */
@Service
@Transactional(readOnly = true)
@CacheConfig(cacheNames = Constant.GINKGO_JXS_annotation_PREFIX)
public class QkBasicJxsinfoService extends CrudService<QkBasicJxsinfoDao, QkBasicJxsinfo> {
    @Autowired
    private QkBasicJxsinfoDao qkBasicJxsinfoDao;

    @Override
    public QkBasicJxsinfo get(String id) {
        return super.get(id);
    }

    @Override
    public List<QkBasicJxsinfo> findList(QkBasicJxsinfo qkBasicJxsinfo) {
        qkBasicJxsinfo.getSqlMap().put("dsf", dataScopeFilter(UserUtils.getUser(), "o1,o", "u"));
        return super.findList(qkBasicJxsinfo);
    }



    @Override
    @Transactional(readOnly = false)
    public void save(QkBasicJxsinfo qkBasicJxsinfo) {
        super.save(qkBasicJxsinfo);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(QkBasicJxsinfo qkBasicJxsinfo) {
        super.delete(qkBasicJxsinfo);
    }


    /**
     * 根据经销商编码获取经销商,并进行缓存
     * @param jxscode
     * @return 取不到返回null
     */
    @Cacheable(unless = "#result==null")
    public QkBasicJxsinfo getJxsByCode(String jxscode) {
        QkBasicJxsinfo qkBasicJxsinfo =
                qkBasicJxsinfoDao.getJxsByCode(jxscode);
        return qkBasicJxsinfo;
    }
    /**
     * 获取经销商列表
     * @param qkBasicJxsinfo
     * @return  List<QkBasicJxsinfo>
     * */
    public List<QkBasicJxsinfo> findJxsList(QkBasicJxsinfo qkBasicJxsinfo){
        return null;
    }


    
    /**
     * 根据父经销商查询经销商网络
     * @param jxsid
     * @return
     */
    public List<QkBasicJxsinfo> findRwjxsByParentID(String jxsid){
        return qkBasicJxsinfoDao.findRwjxsByParentID(jxsid);
    }

}

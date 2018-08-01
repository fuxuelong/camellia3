package com.qk.ginkgoservice.modules.basic.crm.service; /**
 * Copyright &copy; 2016-2017 <a href="https://www.cnhtcqk.com">中国重汽（香港）有限公司轻卡销售部</a> All rights
 * reserved.
 */

import com.qk.ginkgoservice.common.persistence.CrudService;
import com.qk.ginkgoservice.modules.basic.crm.dao.QkBasicJxsPpDao;
import com.qk.ginkgoservice.modules.basic.crm.dao.QkBasicJxsglDao;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsPp;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsgl;
import com.qk.ginkgoservice.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 经销商管理Service
 * 
 * @author qk
 * @version 2016-12-23
 */
@Service
@Transactional(readOnly = true)
public class QkBasicJxsPpService extends CrudService<QkBasicJxsglDao, QkBasicJxsgl> {
    @Autowired
    QkBasicJxsPpDao qkBasicJxsPpDao;

}

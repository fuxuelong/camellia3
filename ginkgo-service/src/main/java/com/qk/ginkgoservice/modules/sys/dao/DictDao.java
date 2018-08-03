/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.qk.ginkgoservice.modules.sys.dao;

import java.util.List;
import com.qk.ginkgoservice.common.persistence.CrudDao;
import com.qk.ginkgoservice.modules.sys.entity.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 字典DAO接口
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
@Component
@Mapper
public interface DictDao extends CrudDao<Dict> {
}

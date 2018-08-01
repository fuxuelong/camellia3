package com.qk.commonservice.service;

import com.qk.commonservice.dao.CrudDao;
import com.qk.commonservice.entity.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhangyu
 * @data 2018/7/16
 */
public abstract class CrudService <D extends CrudDao<T>, T extends DataEntity<T>>{

    @Autowired
    protected D dao;

    /**
     * 获取所有的记录
     * @param t
     * @return
     */
    public List<T> findList(T t){
        return dao.findList(t);
    }

    /**
     * 根据ID获取对象
     * @param id
     * @return
     */
    public T get(String id){
        return dao.get(id);
    }

    /**
     * 添加一条记录
     * @param t
     */
    public int save(T t){
        return dao.save(t);
    }

    /**
     * 更新记录
     * @param t
     */
    public int update(T t){
        return dao.update(t);
    }

    /**
     * 删除一条记录
     * @param id
     * @return
     */
    public int delete(String id){
        return dao.delete(id);
    }


}

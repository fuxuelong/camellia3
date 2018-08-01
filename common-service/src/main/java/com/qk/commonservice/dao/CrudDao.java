package com.qk.commonservice.dao;

import java.util.List;

/**
 * 公共dao
 * @author zhangyu
 * @data 2018/7/16
 */
public interface CrudDao<T> {

    /**
     * 获取所有的记录
     * @param t
     * @return
     */
    List<T> findList(T t);

    /**
     * 根据ID获取指定的对象
     * @param id
     * @return
     */
    T get(String id);

    /**
     * 插入一条记录
     * @param t
     * @return
     */
    int save(T t);

    /**
     * 更新记录
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 删除数据
     * @param id
     * @return
     */
    int delete(String id);
}

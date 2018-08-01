package com.qk.logserver.dao;

import com.qk.logserver.entity.Log;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhangyu
 * @data 2018/7/14
 */
@Component("logDao")
@Mapper
public interface LogDao {

    /**
     * 保存日志信息
     * @param log
     */
    void save(Log log);
}

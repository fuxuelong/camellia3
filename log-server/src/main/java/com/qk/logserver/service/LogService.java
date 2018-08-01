package com.qk.logserver.service;

import com.qk.logserver.dao.LogDao;
import com.qk.logserver.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangyu
 * @data 2018/7/15
 */
@Service
public class LogService {

    @Autowired
    private LogDao logDao;

    /**
     * 保存日志
     * @param log
     */
    public void saveLogger(Log log){
        logDao.save(log);
    }

}

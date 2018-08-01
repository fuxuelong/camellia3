package com.qk.commonservice.service;


import com.alibaba.fastjson.JSON;
import com.qk.commonservice.config.RabbitConfig;
import com.qk.commonservice.entity.SysLog;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangyu
 * @data 2018/7/15
 */
@Service
public class LoggerService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void log(SysLog sysLog){
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUENAME, JSON.toJSONString(sysLog));
    }
}

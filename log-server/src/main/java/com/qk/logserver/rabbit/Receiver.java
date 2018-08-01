package com.qk.logserver.rabbit;

import com.alibaba.fastjson.JSON;
import com.qk.logserver.entity.Log;
import com.qk.logserver.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author Zhy
 * @data 2018/7/24
 * @description 
 */
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    LogService sysLogService;
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        Log sysLog=  JSON.parseObject(message,Log.class);
        sysLogService.saveLogger(sysLog);
        latch.countDown();
    }


}
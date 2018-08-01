package com.qk.logserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 日志服务启动类
 * @author zhangyu
 * @data 2018/7/15
 */
@SpringBootApplication
@MapperScan("com.qk.logserver.dao")
public class LogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogServerApplication.class, args);
    }
}

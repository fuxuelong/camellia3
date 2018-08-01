package com.qk.uaaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author zhangyu
 * @data 2018/7/15
 */
@SpringBootApplication
@RefreshScope
public class UaaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaaServerApplication.class, args);
    }
}

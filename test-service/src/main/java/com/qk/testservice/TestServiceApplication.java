package com.qk.testservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resources;

/**
 * 测试
 * @author zhangyu
 * @data 2018/7/14
 */
@SpringBootApplication
@RestController
@RefreshScope
public class TestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @Value("${foo}")
    private String foo;

    @RequestMapping("/config")
    public String getConfig()
    {
        String str = "applicationName: " + applicationName +  "\t port: " + port;
        System.out.println("******str: " + str + foo + foo);
        return "applicationName: " + applicationName +  "\t port: " + port + foo;
    }
}

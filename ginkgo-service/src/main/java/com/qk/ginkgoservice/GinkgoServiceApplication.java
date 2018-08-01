package com.qk.ginkgoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author fuxuelong
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@RefreshScope
@EnableCaching
public class GinkgoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GinkgoServiceApplication.class, args);
    }
}

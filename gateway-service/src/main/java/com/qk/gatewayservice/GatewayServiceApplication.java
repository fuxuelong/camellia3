package com.qk.gatewayservice;

import com.qk.gatewayservice.filter.ElapsedGatewayFilterFactory;
import com.qk.gatewayservice.filter.GinkgoGatewayFilterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author zhangyu
 * @data 2018/7/15
 */
@EnableCaching
@Controller
@SpringBootApplication
public class GatewayServiceApplication {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public static void main(String[] args) {

        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    public ElapsedGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new ElapsedGatewayFilterFactory();
    }

    @Bean
    public GinkgoGatewayFilterFactory ginkgoGatewayFilterFactory() {
        return new GinkgoGatewayFilterFactory();
    }

    @RequestMapping(value = "test1")
    @ResponseBody
    public String getUser(String userId) {
        redisTemplate.opsForValue().set("test",userId);
        System.out.println("---"+redisTemplate.opsForValue().get("miya11"));
        return userId;
    }
}

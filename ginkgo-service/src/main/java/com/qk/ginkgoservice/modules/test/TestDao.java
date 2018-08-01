package com.qk.ginkgoservice.modules.test;

import com.qk.ginkgoservice.common.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient(value = "eureka-producer",configuration = FeignConfig.class)
public interface TestDao {
//    @GetMapping(value = "/hello")
//    String aaa();
}

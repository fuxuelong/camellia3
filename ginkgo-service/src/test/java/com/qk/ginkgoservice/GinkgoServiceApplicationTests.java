package com.qk.ginkgoservice;

import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsinfo;
import com.qk.ginkgoservice.modules.basic.crm.service.QkBasicJxsinfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GinkgoServiceApplicationTests {

//    @Autowired
//    RedisTemplate<Object,Object> redisTemplate;
//    @Autowired
//    QkBasicJxsinfoService qkBasicJxsinfoService;
    @Test
    public void contextLoads() {
//        QkBasicJxsinfo qkBasicJxsinfo = new QkBasicJxsinfo();
//        qkBasicJxsinfo.setJxscode("HB002202");
//        qkBasicJxsinfo=qkBasicJxsinfoService.findList(qkBasicJxsinfo).get(0);
//        redisTemplate.opsForValue().set(qkBasicJxsinfo.getJxscode(),qkBasicJxsinfo);
    }

}

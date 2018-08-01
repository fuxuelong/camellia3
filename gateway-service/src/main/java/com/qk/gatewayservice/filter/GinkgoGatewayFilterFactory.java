package com.qk.gatewayservice.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.setResponseStatus;

public class GinkgoGatewayFilterFactory extends AbstractGatewayFilterFactory<GinkgoGatewayFilterFactory.Config> {

    private static final Log log = LogFactory.getLog(GatewayFilter.class);
    private static final String ELAPSED_TIME_BEGIN = "elapsedTimeBegin";
    private static final String KEY = "withParams";
    private static final String GINKGO_JWT_PREFIX = "ginkgo_jwt:";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(KEY);
    }

    public GinkgoGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {


        return (exchange, chain) ->
                chain.filter(exchange).then(Mono.defer(() -> {
                    ServerHttpRequest request = exchange.getRequest();
                    /**返回结果用json*/
                    JSON jsonPackage = new JSONObject();
                    if (!exchange.getResponse().isCommitted()) {
                        final ServerHttpResponse response = exchange.getResponse();
                        String login = "/login";
                        if(!StringUtils.endsWith(request.getURI().toString(),login) ){
                            String paramToken;
                            String username;
                            try {
                                paramToken = request.getHeaders().get("Authorization").get(0);
                                username = request.getHeaders().get("username").get(0);
                            }catch (NullPointerException e){
                                ((JSONObject) jsonPackage).put("code",-5);
                                ((JSONObject) jsonPackage).put("message","header中参数Authorization或username缺失");
                                ((JSONObject) jsonPackage).put("data","" );
                                DataBuffer bodyDataBuffer = response.bufferFactory().wrap(jsonPackage.toJSONString().getBytes());
                                return response.writeWith(Mono.just(bodyDataBuffer));
                            }

                            String redisJwt = stringRedisTemplate.opsForValue().get(GINKGO_JWT_PREFIX+username) == null ?
                                    "" : stringRedisTemplate.opsForValue().get(GINKGO_JWT_PREFIX+username);
                            System.out.println("===="+stringRedisTemplate.getExpire(GINKGO_JWT_PREFIX+username,TimeUnit.SECONDS));
                            JSON redisJwtJson = JSON.parseObject(redisJwt);
                            if (redisJwtJson==null){
                                ((JSONObject) jsonPackage).put("code",-4);
                                ((JSONObject) jsonPackage).put("message","未登录或登录超时");
                                ((JSONObject) jsonPackage).put("data","");
                                DataBuffer bodyDataBuffer = response.bufferFactory().wrap(jsonPackage.toJSONString().getBytes());

                                return response.writeWith(Mono.just(bodyDataBuffer));
                            }
                            String redisToken = ((JSONObject) redisJwtJson).getString("access_token");
                            //去掉前面的"Bearer "
                            paramToken=paramToken.substring(7);
                            System.out.println(paramToken);
                            System.out.println(redisToken);

//                            if ( ("").equals(redisToken) || (!redisToken.equals(paramToken))){
//                                ((JSONObject) jsonPackage).put("code",-4);
//                                ((JSONObject) jsonPackage).put("message","未登录或登录超时");
//                                ((JSONObject) jsonPackage).put("data","");
//                                DataBuffer bodyDataBuffer = response.bufferFactory().wrap(jsonPackage.toJSONString().getBytes());
//
//                                return response.writeWith(Mono.just(bodyDataBuffer));
//                            }
                        }
                    }
                    return Mono.empty();
                }));
    }


    public static class Config {

        private boolean withParams;

        public boolean isWithParams() {
            return withParams;
        }

        public void setWithParams(boolean withParams) {
            this.withParams = withParams;
        }

    }
}
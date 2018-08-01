package com.qk.gatewayservice.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.Assert;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.*;

/**
 * @author zhangyu
 * @data 2018/7/15
 */
public class ElapsedGatewayFilterFactory extends AbstractGatewayFilterFactory<ElapsedGatewayFilterFactory.Config> {

    private static final Log log = LogFactory.getLog(GatewayFilter.class);
    /**
     * status 状态码
     */
    public static final String STATUS_KEY = "status";
    public static final String URL_KEY = "url";
    private static final String GINKGO_PREFIX = "ginkgo_";

    private static final Base64.Decoder ENCODER = Base64.getDecoder();

    @Autowired
    private StringRedisTemplate redisTemplate;

    public ElapsedGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(STATUS_KEY, URL_KEY);
    }

    @Value("${status}")
    String status;

    @Value("${url}")
    String url;

    @Override
    public GatewayFilter apply(Config config) {
//        return apply("302", "http://localhost:5000/user/web/login");
        config.setStatus(status);
        config.setUrl(url);
        return apply(config.status,config.url);
    }


    public GatewayFilter apply(String statusString, String urlString) {
        final HttpStatus httpStatus = parse(statusString);
        final URL url;
        try {
            url = URI.create(urlString).toURL();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url " + urlString, e);
        }
        return apply(httpStatus, url);
    }

    public GatewayFilter apply(HttpStatus httpStatus, URL url) {

        return (exchange, chain) ->
                chain.filter(exchange).then(Mono.defer(() -> {
                    ServerHttpRequest request = exchange.getRequest();
                    if (!exchange.getResponse().isCommitted()) {
                        String login = "/login";
                        if(!StringUtils.endsWith(request.getURI().toString(),login)
                                && !StringUtils.endsWith(request.getURI().toString(),".js")
                                && !StringUtils.endsWith(request.getURI().toString(),".css")
                                ){
                            if( request.getCookies().size() > 0
                                    && request.getCookies().get("access_token").size() > 0 ) {

                                String jwtCookie = request.getCookies().get("access_token").size() > 0
                                        ? request.getCookies().get("access_token").get(0).getValue().toString()
                                        : "";
                                if(jwtCookie != ""){
                                    String str1 = StringUtils.substringBetween(jwtCookie,".",".");
                                    JSONObject jsonObject = null;
                                    try {
                                        jsonObject = JSONObject.parseObject(new String(ENCODER.decode(str1), "UTF-8"));
                                        String username = jsonObject.get("user_name").toString();
                                        String jwtRedis = redisTemplate.opsForValue().get(username) == null ? "" : redisTemplate.opsForValue().get(username);
                                        if ( ("").equals(jwtRedis) || (!jwtRedis.equals(jwtCookie))){
                                            setResponseStatus(exchange, httpStatus);
                                            final ServerHttpResponse response = exchange.getResponse();
                                            response.getHeaders().set(HttpHeaders.LOCATION, url.toString());
                                            return response.setComplete();
                                        }
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else{
//                                String auth = "Authorization";
//                                System.out.println("---"+request.getHeaders().get(auth));
////                                String
//                                if(request.getHeaders().get(auth) != null){
//
//                                }else{
//                                }
                                //cookie为空的情况
                                setResponseStatus(exchange, httpStatus);
                                final ServerHttpResponse response = exchange.getResponse();
                                response.getHeaders().set(HttpHeaders.LOCATION, url.toString());
                                return response.setComplete();
                            }
                        }
                    }
                    return Mono.empty();
                }));
    }

    public static class Config {

        String status;

        String url;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
}
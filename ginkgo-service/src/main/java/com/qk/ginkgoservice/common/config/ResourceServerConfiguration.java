package com.qk.ginkgoservice.common.config;

import com.qk.ginkgoservice.common.exception.AuthExceptionEntryPoint;
import com.qk.ginkgoservice.common.handler.CustomAccessDeniedHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Created by fangzhipeng on 2017/5/27.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    Logger log = LoggerFactory.getLogger(ResourceServerConfiguration.class);

    @Autowired
    TokenStore tokenStore;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .regexMatchers(".*swagger.*",".*v2.*",".*webjars.*","/web/*.*","/user/login.*","/user/registry.*","/user/test.*").permitAll()
                .antMatchers("/actuator/**","/hystrix/**","/proxy.stream").permitAll()
                .antMatchers("/js/**", "/css/**","/img/**","/images/**","/fonts/**","/**/favicon.ico").permitAll()
                .antMatchers("/**").authenticated();
//        .antMatchers("/**").permitAll();
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        log.info("==============Configuring ResourceServerSecurityConfigurer ======================");
        resources.resourceId("user-service").tokenStore(tokenStore);
        /**用于配置token失效异常类及异常处理类，配置*/
        resources.authenticationEntryPoint(new AuthExceptionEntryPoint())
                .accessDeniedHandler(new CustomAccessDeniedHandler());
    }
}

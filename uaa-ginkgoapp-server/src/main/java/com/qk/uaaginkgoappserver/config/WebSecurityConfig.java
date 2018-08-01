package com.qk.uaaginkgoappserver.config;


import com.qk.uaaginkgoappserver.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletResponse;


@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserServiceDetail userServiceDetail;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .exceptionHandling()
            .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
            .and()
            .authorizeRequests()
            .antMatchers("/actuator/**").permitAll()
            .antMatchers("/**").authenticated()
            .and()
            .httpBasic();

        /*// 关闭csrf验证
        http.csrf().disable()
                //.addFilterBefore(codeFilter, UsernamePasswordAuthenticationFilter.class )
                .formLogin()
                .loginPage("/signIn.html")
                //设置自定义的处理登陆的post请求
                .loginProcessingUrl("/authentication/form")
                .and().authorizeRequests()
                // 所有 /login 的请求 都放行,如果没有该配置会形成死循环
                .antMatchers( "/signIn.html").permitAll()
                // 所有请求需要身份认证
                .anyRequest().authenticated()
                .and()
                .rememberMe().rememberMeParameter("remember-me")
                .tokenValiditySeconds(3600)
                .userDetailsService(userServiceDetail);*/


    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceDetail)
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence charSequence) {
                        return UserUtils.entryptPassword(charSequence.toString());
                    }
//
                    @Override
                    public boolean matches(CharSequence rawPassword, String encodedPassword) {
                        return UserUtils.validatePassword(rawPassword.toString(),encodedPassword);
                    }
                });
    }
}

package com.lwc.security.browser;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author eddie.lee
 * @ProjectName spring-security
 * @Package com.lwc.security.browser
 * @ClassName BrowserSecurityConfig
 * @description SpringSecurity基本原理
 * @date created in 2018-07-13 10:55
 * @modified by
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

		http.formLogin()
//        http.httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

    }

}

package com.lwc.security.browser;


import com.lwc.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 4-3 自定义用户认证逻辑
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.formLogin()
//                .loginPage("/lwc-signln.html")
//                .loginProcessingUrl("/authentication/form")
////		http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/lwc-signln.html").permitAll()
//                .anyRequest()
//                .authenticated()
//                //登录验证需要的，不然会 404
//                .and()
//                .csrf().disable();

        //任何接口到会跳转到 /authentication/require 接口到， 在BrowserSecurityController里面
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
//		http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();

    }

}

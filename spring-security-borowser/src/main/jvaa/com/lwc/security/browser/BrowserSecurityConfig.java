package com.lwc.security.browser;


import com.lwc.security.core.image.ValidateCodeFilter;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author eddie.lee
 * @ProjectName spring-security
 * @Package com.lwc.security.browser
 * @ClassName BrowserSecurityConfig
 * @description 自定义 SpringSecurity 拦截器
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

    @Autowired
    private DataSource dataSource;

    /**
     * 4-3 自定义用户认证逻辑
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 自动创建“记住我”功能的数据库表
     * 如果不使用下面注释自动创建设置，可以直接点击 JdbcTokenRepositoryImpl() 进入去 会看到创建的SQL
     * 为什么建议不自动创建，第一次会正常创建，第二次如果忘记注释配置，就会启动时候后台报错；
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//		tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //普通用户登录认证跳转
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
//        http.formLogin()
//                .loginPage("/authentication/require")
//                .loginProcessingUrl("/authentication/form")
//                .successHandler(authenticationSuccessHandler)
//                .failureHandler(authenticationFailureHandler)
////		http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/authentication/require",
//                        securityProperties.getBrowser().getLoginPage()).permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable();
//

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        //图形验证码登录
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")
                //提交后由UsernamePasswordAuthenticationFilter处理
                .loginProcessingUrl("/authentication/form")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                //“记住我”功能 --start
                //如果想在“记住我”登录时记录日志，可以注册一个InteractiveAuthenticationSuccessEvent事件的监听器
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService())
                //“记住我”功能 --end
//		http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/image").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();

    }
}

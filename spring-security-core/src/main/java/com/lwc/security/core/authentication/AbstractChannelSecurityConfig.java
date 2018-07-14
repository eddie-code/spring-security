package com.lwc.security.core.authentication;

import com.lwc.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.authentication
 * @ClassName AbstractChannelSecurityConfig
 * @description
 * @date created in 2018-07-14 21:13
 * @modified by
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler lwcAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler lwcAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(lwcAuthenticationSuccessHandler)
                .failureHandler(lwcAuthenticationFailureHandler);
    }

}


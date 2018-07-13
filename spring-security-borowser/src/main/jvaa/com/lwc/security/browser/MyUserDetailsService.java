package com.lwc.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author eddie.lee
 * @ProjectName spring-security
 * @Package com.lwc.security.browser
 * @ClassName MyUserDetailsService
 * @description 4-3 自定义用户认证逻辑
 * @date created in 2018-07-13 11:15
 * @modified by
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 作用： 就是获取到启动时候的认证密码，直接赋值到这里 .encode("password")
     *
     * 如果注入不到 就是 BrowserSecurityConfig 缺少注入Bean
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录用户名:" + username);
        // 根据用户名查找用户信息
        //根据查找到的用户信息判断用户是否被冻结 accountNonLocked: false 就是冻结
        String password = passwordEncoder.encode("123456");
        logger.info("数据库密码是:"+password);
        return new User(username, password,
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

}

package com.lwc.security.core;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core
 * @ClassName ValidateCodeProcessor
 * @description 校验码处理器，封装不同校验码的处理逻辑
 * @date created in 2018-07-14 16:46
 * @modified by
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

}

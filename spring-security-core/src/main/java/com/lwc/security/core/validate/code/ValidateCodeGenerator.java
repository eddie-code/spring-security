package com.lwc.security.core.validate.code;


import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.validate.code.image
 * @ClassName ValidateCodeGenerator
 * @description 验证码生成器
 * @date created in 2018-07-14 0:28
 * @modified by
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);

}

package com.lwc.security.core.image;


import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.image
 * @ClassName ValidateCodeGenerator
 * @description 图片验证码
 * @date created in 2018-07-14 0:28
 * @modified by
 */
public interface ValidateCodeGenerator {

    ImageCode generate(ServletWebRequest request);

}

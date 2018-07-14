package com.lwc.code;

import com.lwc.security.core.image.ImageCode;
import com.lwc.security.core.image.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author eddie.lee
 * @Package com.lwc.code
 * @ClassName DemoImageCodeGenerator
 * @description 为了测试 ValidateCodeBeanConfig.java 的 @ConditionalOnMissingBean 是否生效
 * @date created in 2018-07-14 2:16
 * @modified by
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更厉害的图形验证码生成代码！");
        return null;
    }
}

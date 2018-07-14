package com.lwc.security.core.validate.code.sms;

import com.lwc.security.core.validate.code.ValidateCode;
import com.lwc.security.core.validate.code.ValidateCodeGenerator;
import com.lwc.security.core.properties.SecurityProperties;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.validate.code.image
 * @ClassName ImageCodeGenerator
 * @description 短信验证码 生成
 * @date created in 2018-07-14 1:11
 * @modified by
 */
@Data
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }


}

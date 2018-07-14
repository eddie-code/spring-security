package com.lwc.security.core.properties;

import lombok.Data;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.properties
 * @ClassName ValidateCodeProperties
 * @description 验证码实体 加入到 SecurityProperties 判断值是否存在 不存在就实体获取；
 * @date created in 2018-07-14 1:04
 * @modified by
 */
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

}

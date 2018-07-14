package com.lwc.security.core.properties;

import lombok.Data;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.properties
 * @ClassName SmsCodeProperties
 * @description
 * @date created in 2018-07-14 14:17
 * @modified by
 */
@Data
public class SmsCodeProperties {

    private String url;

    private int length = 6;

    //处理过期时间
    private int expireIn = 60;

}

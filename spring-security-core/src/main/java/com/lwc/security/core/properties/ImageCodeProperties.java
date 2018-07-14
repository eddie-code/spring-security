package com.lwc.security.core.properties;

import lombok.Data;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.properties
 * @ClassName ImageCodeProperties
 * @description 图片验证码基本参数
 * @date created in 2018-07-14 1:01
 * @modified by
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties {


    public ImageCodeProperties() {
        //从父类获取 setLength 设置图形验证码长度为 4
        setLength(4);
    }

    private int width = 67;

    private int height = 23;

}

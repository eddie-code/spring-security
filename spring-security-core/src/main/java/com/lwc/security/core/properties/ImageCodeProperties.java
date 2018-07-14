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
public class ImageCodeProperties {

    private String url;

    private int width = 67;

    private int height = 23;

    private int length = 4;

    private int expireIn = 60;

}

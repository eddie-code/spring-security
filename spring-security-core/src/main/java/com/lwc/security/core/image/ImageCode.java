package com.lwc.security.core.image;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.image
 * @ClassName ImageCode
 * @description 图片验证码 负责图片失效时间
 * @date created in 2018-07-14 0:28
 * @modified by
 */
@Data
public class ImageCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image, String code, int expireIn){
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn); //时间转秒
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime){
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * 比较日期先后
     * 详细用法： https://blog.csdn.net/KingBoyWorld/article/details/75808108
     */
    public boolean isExpried() {
        System.out.println("ImageCode.LocalDateTime.now(): " + expireTime);
        System.out.println("ImageCode.isExpried(): " + expireTime);
        return LocalDateTime.now().isAfter(expireTime);
    }

}

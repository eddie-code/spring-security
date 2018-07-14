package com.lwc.security.core.image;

import com.lwc.security.core.ValidateCode;
import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.image
 * @ClassName ImageCode
 * @description 图片验证码
 * @date created in 2018-07-14 0:28
 * @modified by
 */
@Data
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn){
        //通过 super 调用父类的构造函数
        super(code,expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime){
        //通过 super 调用父类的构造函数
        super(code,expireTime);
        this.image = image;
    }

}

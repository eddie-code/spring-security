package com.lwc.security.core.validate.code;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.validate.code.image
 * @ClassName ImageCode
 * @description 短信验证码
 * @date created in 2018-07-14 0:28
 * @modified by
 */
@Data
public class ValidateCode {

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn); //时间转秒
        System.out.println("ValidateCode1.code: " + code);
        System.out.println("ValidateCode1.expireTime: " + expireTime);
    }

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
        System.out.println("ValidateCode2.code: " + code);
        System.out.println("ValidateCode2.LocalDateTime.expireTime: " + expireTime);
    }

    /**
     * 比较日期先后
     * 详细用法： https://blog.csdn.net/KingBoyWorld/article/details/75808108
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

}

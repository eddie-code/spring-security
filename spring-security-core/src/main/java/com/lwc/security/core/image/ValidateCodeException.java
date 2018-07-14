package com.lwc.security.core.image;

import org.springframework.security.core.AuthenticationException;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.image
 * @ClassName ValidateCodeException
 * @description 图片验证码出去异常信息
 * @date created in 2018-07-14 0:34
 * @modified by
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }

}

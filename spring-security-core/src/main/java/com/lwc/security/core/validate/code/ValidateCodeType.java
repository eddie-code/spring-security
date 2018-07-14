package com.lwc.security.core.validate.code;


import com.lwc.security.core.properties.SecurityConstants;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core
 * @ClassName ValidateCodeType
 * @description
 * @date created in 2018-07-14 21:05
 * @modified by
 */
public enum ValidateCodeType {

    /**
     * 短信验证码
     */
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },
    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取的参数的名字
     * @return
     */
    public abstract String getParamNameOnValidate();

}


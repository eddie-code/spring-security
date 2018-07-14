package com.lwc.security.core.sms;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.sms
 * @ClassName SmSCodeSender
 * @description 模拟短信第三方接口
 * @date created in 2018-07-14 13:48
 * @modified by
 */
public interface SmsCodeSender {

    /**
     *
     * @param mobile 手机号码
     * @param code 短信验证码
     */
    void send(String mobile, String code);

}

package com.lwc.security.core.validate.code.sms;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.validate.code.sms
 * @ClassName DefaultSmsCodeSender
 * @description 模拟已经发送的短信
 * @date created in 2018-07-14 13:49
 * @modified by
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机 " + mobile + " 发送短信验证码 " + code);
    }

}

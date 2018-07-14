package com.lwc.security.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author eddie.lee
 * @Package com.lwc.security.core.image
 * @ClassName ValidateCodeController
 * @description 生成验证码
 * @date created in 2018-07-14 0:35
 * @modified by
 */
@RestController
public class ValidateCodeController {

    /**
     * 依赖搜索 （服务启动的时候就查询存在的Bean）
     */
    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * 创建验证码，根据验证码类型不同，调用不同的 {@link ValidateCodeProcessor}接口实现
     * @param request
     * @param response
     * @param type
     * @throws Exception
     */
    @GetMapping("/code/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {

        //打印获取的Bean
        System.out.println("ValidateCodeController.type: " + type);
        System.out.println("ValidateCodeController.validateCodeProcessors: " + validateCodeProcessors);
        System.out.println("ValidateCodeController.validateCodeProcessors.get(type+\"CodeProcessor\"): " + validateCodeProcessors.get(type+"CodeProcessor"));

        validateCodeProcessors.get(type+"CodeProcessor").create(new ServletWebRequest(request, response));
    }

}

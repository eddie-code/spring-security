package com.lwc.service.impl;

import com.lwc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author eddie.lee
 * @Package com.lwc.service.impl
 * @ClassName HelloServiceImpl
 * @description
 * @date created in 2018-07-12 22:14
 * @modified by
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello "+name;
    }

}


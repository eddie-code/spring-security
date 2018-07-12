package com.lwc.validator;

import com.lwc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author eddie.lee
 * @Package com.lwc.validator
 * @ClassName MyConstraintValidator
 * @description
 * @date created in 2018-07-12 22:21
 * @modified by
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("MyConstraintValidator : my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.greeting("eddie");
        System.out.println(value);
        return false;
    }

}


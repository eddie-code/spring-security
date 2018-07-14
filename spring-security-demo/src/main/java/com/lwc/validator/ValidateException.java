package com.lwc.validator;

import lombok.Data;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author eddie.lee
 * @Package com.lwc.validator
 * @ClassName ValidateException
 * @description
 * @date created in 2018-07-15 0:03
 * @modified by
 */
@Data
public class ValidateException extends RuntimeException {

    private List<ObjectError> errors;

    public ValidateException(List<ObjectError> errors) {
        this.errors = errors;
    }

}

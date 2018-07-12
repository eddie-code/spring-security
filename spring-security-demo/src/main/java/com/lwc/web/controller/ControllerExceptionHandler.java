package com.lwc.web.controller;

import com.lwc.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eddie.lee
 * @Package com.lwc.web.controller
 * @ClassName ControllerExceptionHandler
 * @description
 * @date created in 2018-07-12 22:26
 * @modified by
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistException(UserNotExistException ex) {
        Map<String, Object> result = new HashMap<>(16);
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
        return result;
    }

}

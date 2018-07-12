package com.lwc.exception;

import lombok.Data;

/**
 * @author eddie.lee
 * @Package com.lwc.exception
 * @ClassName UserNotExistException
 * @description
 * @date created in 2018-07-12 22:25
 * @modified by
 */
@Data
public class UserNotExistException extends RuntimeException {

    private String id;

    public UserNotExistException(String id) {
        super("UserNotExistException : user not exist");
        this.id = id;
    }

}

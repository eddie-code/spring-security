package com.lwc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author eddie.lee
 * @Package com.lwc.dto
 * @ClassName UserQueryCondition
 * @description
 * @date created in 2018-07-11 21:11
 * @modified by
 */
@Data
public class UserQueryCondition {

    private String username;

    @ApiModelProperty(value = "用户年龄起值")
    private int age;

    @ApiModelProperty(value = "用户年龄终值")
    private int ageTo;

    private String xxx;

}

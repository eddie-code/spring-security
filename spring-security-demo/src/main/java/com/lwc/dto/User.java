package com.lwc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.lwc.validator.MyConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author eddie.lee
 * @Package com.lwc.dto
 * @ClassName User
 * @description
 * @date created in 2018-07-11 20:59
 * @modified by
 */
@Data
public class User {

    public interface UserSimpleView{
        //[{"username":null},{"username":null},{"username":null}]
    };

    public interface UserDatailView extends UserSimpleView{
        //{"username":"eddie","password":null}
    };


    @JsonView(UserSimpleView.class)
    private String id;

    @MyConstraint(message = "这是一个测试")
    @JsonView(UserSimpleView.class)
    private String username;

    @NotBlank(message = "密码不能为空")
    @JsonView(UserDatailView.class)
    private String password;

    @Past(message = "生日必须是过去的时间")
    private Date birthday;

}

package com.lwc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lwc.dto.User;
import com.lwc.dto.UserQueryCondition;
import com.lwc.exception.UserNotExistException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eddie.lee
 * @Package com.lwc.web.controller
 * @ClassName UserController
 * @description
 * @date created in 2018-07-11 20:58
 * @modified by
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取认证用户信息 （全部）
     */
    @GetMapping("/me")
    public Object getCurrentUser(Authentication authentication) {

        /**
         * 1. http://localhost:8080/index.html
         * 2. 登录 admin/123456
         * 3. 修改地址 http://localhost:8080/user/me
         */

        //登录之后在 请求http://localhost:8080/user/me 浏览器 开发人员模式下 查看的
        //return SecurityContextHolder.getContext().getAuthentication();

        //同样，也是登录后 请求请求http://localhost:8080/user/me  浏览器和后台都会打印 登录的用户信息
        System.out.println("getCurrentUser.authentication: " + authentication);
        return authentication;
    }

    /**
     * 获取认证用户信息 （部分）
     */
    @GetMapping("/me2")
    public Object getCurrentUser2(@AuthenticationPrincipal UserDetails userDetails) {
        System.out.println("getCurrentUser2.userDetails: " + userDetails);
        return userDetails;
    }

    //    @PostMapping
//    public User create(@Valid @RequestBody User user,BindingResult errors) {
//
//        if(errors.hasErrors()){
//            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
//            //会打印 may not be empty 的提示， 尽管已经使用 @NotBlank + @Valid 的方式； 也会进来方法的；
//        }
    @PostMapping
    public User create(@Valid @RequestBody User user) {

        System.out.println("id=" + user.getId());
        System.out.println("username=" + user.getUsername());
        System.out.println("password=" + user.getPassword());
        System.out.println("birthday=" + user.getBirthday());

        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    @ApiOperation(value = "查询服务")
    public User update(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                // FieldError fieldError = (FieldError)error;
                // String message = fieldError.getField() +" "+
                // error.getDefaultMessage();
                System.out.println(error.getDefaultMessage());
            });
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

    //@RequestMapping(value = "/user", method = RequestMethod.GET)
    //public List<User> query(@RequestParam(name = "name", required = false, defaultValue = "lee") String username) {
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 2, size = 17, sort = "username.asc") Pageable pageable) {

        //System.out.println(username);

        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDatailView.class)
    public User getInfo(@ApiParam(value = "用户ID") @PathVariable String id) {
//		throw new RuntimeException("user not exist");
        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("eddie");
        return user;
    }

}

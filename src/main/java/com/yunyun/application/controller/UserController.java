package com.yunyun.application.controller;


import com.yunyun.application.domain.User;
import com.yunyun.application.service.UserService;
import com.yunyun.application.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/pub/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("login")
    public JsonData login(@RequestBody User user){


        System.out.println("user = " + user.toString());

        String token = userService.login(user.getUsername(),user.getPwd());

        return token !=null ? JsonData.buildSuccess(token):JsonData.buildError("账号密码错误");
    }


    @PostMapping("login01")
    public JsonData login01(User user){
        System.out.println("user=" + user.toString());

        return  JsonData.buildSuccess("");
    }

    @PostMapping("login02")
    public JsonData login02(@RequestBody User user){

        System.out.println("user=" + user.toString());
        System.out.println(1111);


        return JsonData.buildSuccess("");

    }


    @GetMapping("list_user")
    public JsonData listUser(){
        return  JsonData.buildSuccess(userService.listUser());
    }




}

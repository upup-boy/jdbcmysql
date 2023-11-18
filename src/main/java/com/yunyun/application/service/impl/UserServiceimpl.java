package com.yunyun.application.service.impl;

import com.yunyun.application.controller.mapper.UserMapper;
import com.yunyun.application.domain.User;
import com.yunyun.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceimpl implements UserService {

    public  static Map<String,User> sessionMap = new HashMap<>();


    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String pwd){

        User user = userMapper.login(username, pwd);

        if(user == null){
            return null;
        }else {
            String token = UUID.randomUUID().toString();
            System.out.println(token);
            sessionMap.put(token, user);

            return token;
        }

    }


   @Autowired
   public List<User> listUser(){
        return userMapper.ListUser();
   }


}

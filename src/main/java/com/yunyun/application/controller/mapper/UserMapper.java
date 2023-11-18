package com.yunyun.application.controller.mapper;

import com.yunyun.application.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {

    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("tiantian",new User(1,"tiantian", "123"));
        userMap.put("yunyun",new User(2,"tiantian", "456"));
        userMap.put("tianyun",new User(3,"tiantian", "789"));
    }


    public User login(String username, String pwd){

        User user = userMap.get(username);

        if(user == null){
            return null;
        }

        if(user.getPwd().equals(pwd)){
            return user;
        }

        return null;

    }

    public List<User> ListUser(){

        List<User> list = new ArrayList<>();
        list.addAll(userMap.values());
        return list;

    }





}

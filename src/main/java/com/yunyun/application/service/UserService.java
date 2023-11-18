package com.yunyun.application.service;

import com.yunyun.application.domain.User;

import java.util.List;

public interface UserService {

    String login(String username, String pwd);

    List<User> listUser();
}

package com.example.springbootvue.service;


import com.example.springbootvue.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();

    void addUser(User user);

    void delUser(String id);

    User getUserById(String id);

    void changeUser(User user);

    List<User> getAllUserByInput(User user);
}
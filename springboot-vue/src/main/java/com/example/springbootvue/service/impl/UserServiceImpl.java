package com.example.springbootvue.service.impl;

import com.example.springbootvue.dao.UsersMapper;
import com.example.springbootvue.model.User;
import com.example.springbootvue.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public List<User> getAllUser() {
       return usersMapper.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        usersMapper.insert(user);
    }

    @Override
    public void delUser(String id) {
        usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getUserById(String id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public void changeUser(User user) {
        usersMapper.updateByPrimaryKey(user);
    }

    @Override
    public List<User> getAllUserByInput(User user) {
        List<User> userList = usersMapper.getAllUsersByInput(user);
        System.out.println(userList);
        return userList;
    }


}
package com.example.springbootvue.controller;

import com.example.springbootvue.model.User;
import com.example.springbootvue.service.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    private ObjectMapper mapper;


    @GetMapping ("/usersInfo")
    public List<User> getUserList(){
        return userService.getAllUser();
    }

    @PostMapping ("/usersInfoByInput")
    public List<User> getUserListByInput(@RequestBody User user){
        return userService.getAllUserByInput(user);
    }

    @RequestMapping("/userAdd")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping("/userDel")
    public void delUser(String id){
        userService.delUser(id);
    }

    @RequestMapping("/userInfo")
    public User getUserById(@RequestBody User user){
        User resultUser = userService.getUserById(user.getStudentNo());
        int i = 0;
        return resultUser;
    }

    @RequestMapping("/userChange")
    public void changeUser(@RequestBody User user){
        userService.changeUser(user);
    }

//    @RequestMapping("/add")
//    public ResponseEntity<String> userAdd() throws JsonProcessingException {
////        if (StringUtils.isEmpty(user.getName()) && StringUtils.isEmpty(user.getPassword())) {
////            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////        }
//        User user = new User();
//        user.setAge("18");
//        user.setName("tom");
//        user.setId(1);
//
//
//        return new ResponseEntity<>(mapper.writeValueAsString(user), HttpStatus.CREATED);
//    }
}

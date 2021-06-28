package com.example.springbootvue.dao;

import com.example.springbootvue.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersMapper {
    int deleteByPrimaryKey(String id);
//
    int insert(User record);
//
//    int insertSelective(User record);
//
    User selectByPrimaryKey(String id);
//
//    int updateByPrimaryKeySelective(User record);
//
    int updateByPrimaryKey(User record);

    List<User> getAllUsers();

    List<User> getAllUsersByInput(User user);
}
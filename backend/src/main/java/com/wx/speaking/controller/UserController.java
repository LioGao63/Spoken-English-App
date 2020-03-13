package com.wx.speaking.controller;

import com.wx.speaking.bean.User;
import com.wx.speaking.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userMapper.getUserById(id);
    }

    @PostMapping("/addUser")
    public void addUser(User user){
        userMapper.addUser(user);
    }

    @PutMapping("/updata")
    public void updateUser(User user){
        userMapper.updateUser(user);
    }


}

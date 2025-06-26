package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.entity.User;
import com.example.backendquanlichitieu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
    @Autowired private UserService userService;
    //dang ki
    @PostMapping("auth/register")
    public String register(@RequestBody User user) {
        userService.add(user);
        return "Đăng ký thành công!";
    }
}

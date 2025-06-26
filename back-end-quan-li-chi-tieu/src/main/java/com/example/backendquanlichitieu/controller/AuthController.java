package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.dto.LoginRequest;
import com.example.backendquanlichitieu.dto.LoginResponse;
import com.example.backendquanlichitieu.entity.User;
import com.example.backendquanlichitieu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
 // hoặc port frontend của bạn
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

        // Tạo token giả – sau này thay bằng JWT nếu muốn
        String fakeToken = "abc123-token-" + user.getId();

        return new LoginResponse(user, fakeToken);
    }
}

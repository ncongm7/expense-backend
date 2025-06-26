package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.dto.LoginRequest;
import com.example.backendquanlichitieu.dto.LoginResponse;
import com.example.backendquanlichitieu.entity.User;
import com.example.backendquanlichitieu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // Log debug để theo dõi
        System.out.println("Login attempt: email=" + loginRequest.getEmail());

        try {
            // Kiểm tra đầu vào
            if (loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
                System.err.println("Login failed: Missing email or password");
                return ResponseEntity.badRequest().body(new LoginResponse(null, "Missing email or password"));
            }

            // Gọi service để kiểm tra đăng nhập
            User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
            if (user == null) {
                System.err.println("Login failed: Invalid credentials for email=" + loginRequest.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(null, "Invalid credentials"));
            }

            // Tạo token giả – thay bằng JWT nếu cần
            String fakeToken = "abc123-token-" + user.getId();

            // Trả về thành công
            LoginResponse response = new LoginResponse(user, fakeToken);
            System.out.println("Login successful: user=" + user.getId() + ", token=" + fakeToken);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.err.println("Login error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new LoginResponse(null, "Server error: " + e.getMessage()));
        }
    }
}
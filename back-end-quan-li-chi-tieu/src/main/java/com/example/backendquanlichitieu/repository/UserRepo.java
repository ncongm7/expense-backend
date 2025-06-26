package com.example.backendquanlichitieu.repository;

import com.example.backendquanlichitieu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    // Tìm kiếm người dùng theo tên đăng nhập
    User findByUsername(String username);

    // Kiểm tra xem tên đăng nhập đã tồn tại hay chưa
    boolean existsByUsername(String username);

    // Kiểm tra xem email đã tồn tại hay chưa
    boolean existsByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

}

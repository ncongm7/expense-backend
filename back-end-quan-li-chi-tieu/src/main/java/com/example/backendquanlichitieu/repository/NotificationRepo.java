package com.example.backendquanlichitieu.repository;

import com.example.backendquanlichitieu.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {
    List<Notification> findAllByUserId(Long userId);
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây
    // Ví dụ: tìm kiếm thông báo theo người dùng, trạng thái, v.v.
    // List<Notification> findByUserId(Long userId);
    // List<Notification> findByStatus(String status);
}

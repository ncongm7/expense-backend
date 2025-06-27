package com.example.backendquanlichitieu.repository;

import com.example.backendquanlichitieu.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepo extends JpaRepository<Goal, Long> {
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây
    // Ví dụ: tìm kiếm mục tiêu theo tên, ngày, v.v.
    // Goal findByName(String name);
    // List<Goal> findByDateBetween(LocalDate startDate, LocalDate endDate);
    //getAllByUserId
     List<Goal> findAllByUserId(Long userId);
}

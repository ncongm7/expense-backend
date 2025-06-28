package com.example.backendquanlichitieu.repository;

import com.example.backendquanlichitieu.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface BudgetRepo  extends JpaRepository<Budget, Long> {
    List<Budget> findByUserId(Long id);
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây
    // Ví dụ: tìm kiếm ngân sách theo tên, ngày, v.v.
    // Budget findByName(String name);
    // List<Budget> findByDateBetween(LocalDate startDate, LocalDate endDate);
}

package com.example.backendquanlichitieu.repository;

import com.example.backendquanlichitieu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây
    // Ví dụ: tìm kiếm theo tên danh mục
    List<Category> findByUserId(Long userId);

}

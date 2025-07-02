package com.example.backendquanlichitieu.repository;

import com.example.backendquanlichitieu.entity.JarTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface JarTransactionRepo extends JpaRepository<JarTransaction, Long> {
    List<JarTransaction> findAllByJarId(Long jarId);
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây
    // Ví dụ: tìm kiếm giao dịch theo hũ tiền, người dùng, v.v.
    // List<JarTransaction> findByMoneyJarId(Long moneyJarId);
    // List<JarTransaction> findByUserId(Long userId);
}

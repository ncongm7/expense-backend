package com.example.backendquanlichitieu.repository;

import com.example.backendquanlichitieu.entity.MoneyJar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Repository
public interface MoneyJarRepo extends JpaRepository<MoneyJar, Long> {
    List<MoneyJar> findAllByUserId(Long userId);
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây
//    -- 1. Tính tổng tiền hiện tại trong tất cả hũ
//    SELECT SUM(current_amount) as totalAmount
//    FROM money_jars
//    WHERE user_id = ?
        @Query("SELECT COALESCE(SUM(m.currentAmount), 0) FROM MoneyJar m WHERE m.user.id = ?1")
         BigDecimal findTotalCurrentAmountByUserId(Long userId);
//
//            -- 2. Tính tổng mục tiêu của tất cả hũ
//    SELECT SUM(target_amount) as totalTarget
//    FROM money_jars
//    WHERE user_id = ?
        @Query("SELECT COALESCE(SUM(m.targetAmount), 0) FROM MoneyJar m WHERE m.user.id = ?1")
         BigDecimal findTotalTargetAmountByUserId(Long userId);
//            -- 3. Tính phần trăm hoàn thành
//            SELECT
//    CASE
//    WHEN SUM(target_amount) > 0
//    THEN (SUM(current_amount) / SUM(target_amount)) * 100
//    ELSE 0
//    END as progressPercentage
//    FROM money_jars
//    WHERE user_id = ?
    @Query("SELECT " +
            "CASE " +
            "WHEN COALESCE(SUM(m.targetAmount), 0) > 0 " +
            "THEN (COALESCE(SUM(m.currentAmount), 0) / COALESCE(SUM(m.targetAmount), 0)) * 100 " +
            "ELSE 0 " +
            "END " +
            "FROM MoneyJar m WHERE m.user.id = ?1")
    BigDecimal findProgressPercentageByUserId(Long userId);

//            -- 4. Tính số tiền còn lại cần đạt mục tiêu
//            SELECT
//    CASE
//    WHEN SUM(target_amount) > SUM(current_amount)
//    THEN SUM(target_amount) - SUM(current_amount)
//    ELSE 0
//    END as remainingAmount
//    FROM money_jars
//    WHERE user_id = ?
    @Query("SELECT " +
            "CASE " +
            "WHEN COALESCE(SUM(m.targetAmount), 0) > COALESCE(SUM(m.currentAmount), 0) " +
            "THEN COALESCE(SUM(m.targetAmount), 0) - COALESCE(SUM(m.currentAmount), 0) " +
            "ELSE 0 " +
            "END " +
            "FROM MoneyJar m WHERE m.user.id = ?1")
    BigDecimal findRemainingAmountByUserId(Long userId);
}

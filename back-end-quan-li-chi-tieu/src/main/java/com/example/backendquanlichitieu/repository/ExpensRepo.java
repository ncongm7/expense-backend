package com.example.backendquanlichitieu.repository;

import com.example.backendquanlichitieu.entity.Expens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.backendquanlichitieu.entity.Expens;

import java.util.List;

@Repository
public interface ExpensRepo extends JpaRepository<Expens, Long> {

    @Query("SELECT e FROM Expens e WHERE e.category IS NULL AND e.user.id = :userId")
    List<Expens> findUncategorizedExpensesByUserId(@Param("userId") Long userId);

}

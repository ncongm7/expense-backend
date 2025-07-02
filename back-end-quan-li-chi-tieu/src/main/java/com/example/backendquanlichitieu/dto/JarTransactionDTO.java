package com.example.backendquanlichitieu.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Data

public class JarTransactionDTO {
    private Long id;
    private String name;
    private String description;
    private Double amount;
    private LocalDateTime createdAt;
    private String transactionType;
    private Long moneyJarId; // ID của MoneyJar liên kết
    private Long userId; // ID của người dùng liên kết

    public JarTransactionDTO() {
    }

    public JarTransactionDTO(Double amount, LocalDateTime createdAt, String transactionType) {
        this.amount = amount;
        this.createdAt = createdAt;
        this.transactionType = transactionType;
    }

    public JarTransactionDTO(BigDecimal amount, String transactionType, Instant createdAt) {
        this.amount = amount.doubleValue();
        this.transactionType = transactionType;
        this.createdAt = createdAt != null ? LocalDateTime.ofInstant(createdAt, java.time.ZoneId.systemDefault()) : LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }



    public Long getMoneyJarId() {
        return moneyJarId;
    }

    public void setMoneyJarId(Long moneyJarId) {
        this.moneyJarId = moneyJarId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

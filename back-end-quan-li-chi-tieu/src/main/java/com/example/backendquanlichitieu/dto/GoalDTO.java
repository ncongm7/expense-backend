package com.example.backendquanlichitieu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
@Data
@AllArgsConstructor

public class GoalDTO {
    private Integer id;
    private Integer userId;
    private String title;
    private BigDecimal targetAmount;
    private BigDecimal currentAmount;
    private LocalDate deadline;
    private String note;
    private LocalDate  createdAt;
    private  String urlImage;

    public GoalDTO() {
    }

    public GoalDTO(Integer userId, String title, BigDecimal targetAmount, BigDecimal currentAmount, LocalDate deadline, String note, LocalDate  createdAt, String urlImage) {
        this.userId = userId;
        this.title = title;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.deadline = deadline;
        this.note = note;
        this.createdAt = createdAt;
        this.urlImage = urlImage;
    }
    // Getters and Setters
}

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
    private Instant createdAt;
    private  String urlImage;

    public GoalDTO() {
    }

    // Getters and Setters
}

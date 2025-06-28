package com.example.backendquanlichitieu.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class BudgetDTO {
    //tao cac thuoc tinh gion entity buget
    private Integer id;
    private String userName;
    private String categoryName;
    private String period;
    private BigDecimal amount;
    private BigDecimal amountSpent;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long userId;
    private Long categoryId;

    public BudgetDTO(String period ,Integer id, String categoryName, BigDecimal amount, BigDecimal amountSpent, LocalDate startDate, LocalDate endDate) {
        this.period = period;
        this.id = id;
        this.categoryName = categoryName;
        this.amount = amount;
        this.amountSpent = amountSpent;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

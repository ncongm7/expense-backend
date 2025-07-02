package com.example.backendquanlichitieu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyJarDTO {
    //tap cac thuoc tinh cua MoneyJar
    private Integer id;
    private Long userId;
    private String jarName;
    private String jarDisplayName;

    private BigDecimal percentage;
    private BigDecimal targetAmount;
    private BigDecimal currentAmount;
    private String icon;
    private String color;
    private String description;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    private String shortcode; // Tên người dùng sở hữu MoneyJar

    public MoneyJarDTO(BigDecimal percentage, BigDecimal targetAmount, BigDecimal currentAmount, BigDecimal remainingAmount) {
        this.percentage = percentage;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.remainingAmount = remainingAmount;
    }

    private BigDecimal remainingAmount; // Số tiền còn lại để đạt mục tiêu

    public MoneyJarDTO(Integer id, String color, String shortcode, String jarDisplayName) {
        this.id = id;
        this.color = color;
        this.shortcode = shortcode;
        this.jarDisplayName = jarDisplayName;
    }
}

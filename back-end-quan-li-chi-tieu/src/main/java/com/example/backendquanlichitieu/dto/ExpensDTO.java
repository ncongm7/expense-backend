package com.example.backendquanlichitieu.dto;

import com.example.backendquanlichitieu.entity.Category;
import com.example.backendquanlichitieu.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
public class ExpensDTO {
    // viet lai cac thuoc tinh tuong ung voi entity Expens
    private Integer id;
    private String userName;
    private String categoryName;
    private String type;
    private BigDecimal amount;
    private String note;
    private LocalDate spentAt;

    public ExpensDTO(Integer id, String userName, String categoryName, String type, BigDecimal amount, String note, LocalDate spentAt) {
        this.id = id;
        this.userName = userName;
        this.categoryName = categoryName;
        this.type = type;
        this.amount = amount;
        this.note = note;
        this.spentAt = spentAt;
    }

    private Integer categoryId;



    public ExpensDTO(Integer id, String userName, String categoryName, String type, BigDecimal amount, String note, LocalDate spentAt,  Integer categoryId) {
        this.id = id;
        this.userName = userName;
        this.categoryName = categoryName;
        this.type = type;
        this.amount = amount;
        this.note = note;
        this.spentAt = spentAt;
        this.categoryId = categoryId;
    }
}

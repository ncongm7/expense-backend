package com.example.backendquanlichitieu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "money_jars")
public class MoneyJar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    private User user;

    @Size(max = 50)
    @NotNull
    @Column(name = "jar_name", nullable = false, length = 50)
    private String jarName;

    @NotNull
    @Column(name = "jar_display_name", nullable = false, length = Integer.MAX_VALUE)
    private String jarDisplayName;

    @NotNull
    @Column(name = "percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal percentage;

    @Column(name = "current_amount", precision = 15, scale = 2)
    private BigDecimal currentAmount;

    @Column(name = "target_amount", precision = 15, scale = 2)
    private BigDecimal targetAmount;

    @Column(name = "icon", length = Integer.MAX_VALUE)
    private String icon;

    @Size(max = 7)
    @Column(name = "color", length = 7)
    private String color;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Size(max = 5)
    @Column(name = "shortcode", length = 5)
    private String shortcode;

}
package com.example.backendquanlichitieu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "linked_accounts")
public class LinkedAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Column(name = "provider", nullable = false, length = Integer.MAX_VALUE)
    private String provider;

    @Column(name = "account_name", length = Integer.MAX_VALUE)
    private String accountName;

    @Column(name = "connected_at")
    private Instant connectedAt;

}
package com.example.backendquanlichitieu.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class NotificationDTO {
    private Integer id;
    private String title;
    private String message;
    private String type;
    private Boolean read;
    private LocalDate createdAt;
    private LocalDate readAt;
    private String relatedEntityType;
    private Integer relatedEntityId;
    private String actionUrl;
    private Long userId; // chỉ trả về ID thay vì cả object User
}

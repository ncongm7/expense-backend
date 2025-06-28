package com.example.backendquanlichitieu.service;

import com.example.backendquanlichitieu.dto.NotificationDTO;
import com.example.backendquanlichitieu.entity.Notification;
import com.example.backendquanlichitieu.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepo notificationRepo;
    //getAllNotifications
    public List<NotificationDTO> getAllNotifications(Long userId) {
        List<Notification> notifications = notificationRepo.findAllByUserId(userId);
        return notifications.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private NotificationDTO convertToDTO(Notification n) {
        NotificationDTO dto = new NotificationDTO();
        dto.setId(n.getId());
        dto.setTitle(n.getTitle());
        dto.setMessage(n.getMessage());
        dto.setType(n.getType());
        dto.setRead(n.getRead());
        dto.setCreatedAt(n.getCreatedAt());
        dto.setReadAt(n.getReadAt());
        dto.setRelatedEntityType(n.getRelatedEntityType());
        dto.setRelatedEntityId(n.getRelatedEntityId());
        dto.setActionUrl(n.getActionUrl());
        dto.setUserId(Long.valueOf(n.getUser() != null ? n.getUser().getId() : null));
        dto.setCreated(n.getCreated());
        return dto;
    }
    //láy số lượng thông báo chưa đọc
    public long countUnreadNotifications(Long userId) {
        return notificationRepo.findAllByUserId(userId).stream()
                .filter(notification -> !notification.getRead())
                .count();
    }
}

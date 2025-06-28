package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.dto.NotificationDTO;
import com.example.backendquanlichitieu.entity.Notification;
import com.example.backendquanlichitieu.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications/")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    //getAllNotifications
    @GetMapping("hien-thi/{userId}")
    public List<NotificationDTO> getAllNotifications(@PathVariable Long userId) {
        return notificationService.getAllNotifications(userId);
    }
}

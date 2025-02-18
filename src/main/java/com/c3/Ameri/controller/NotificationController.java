package com.c3.Ameri.controller;

import com.c3.Ameri.dto.NotificationDTO;
import com.c3.Ameri.entity.User;
import com.c3.Ameri.service.NotificationService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public List<NotificationDTO> getUserNotifications(@AuthenticationPrincipal UserDetails userDetails) {
        User recipient = new User();
        recipient.setUsername(userDetails.getUsername());
        return notificationService.getUserNotifications(recipient);
    }

    @PutMapping("/{id}/read")
    public void markAsRead(@PathVariable Long id) {
        notificationService.markAsRead(id);
    }
}

package com.c3.Ameri.service;

import com.c3.Ameri.dto.NotificationDTO;
import com.c3.Ameri.entity.Notification;
import com.c3.Ameri.entity.User;
import com.c3.Ameri.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<NotificationDTO> getUserNotifications(User recipient) {
        return notificationRepository.findAllByRecipientOrderByCreatedAtDesc(recipient)
                .stream().map(notification -> {
                    NotificationDTO dto = new NotificationDTO();
                    dto.setId(notification.getId());
                    dto.setMessage(notification.getMessage());
                    dto.setType(notification.getType());
                    dto.setIsRead(notification.getIsRead());
                    dto.setCreatedAt(notification.getCreatedAt());
                    return dto;
                }).collect(Collectors.toList());
    }

    public void markAsRead(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setIsRead(true);
        notificationRepository.save(notification);
    }

    public void createNotification(User recipient, String message, String type) {
        Notification notification = new Notification();
        notification.setRecipient(recipient);
        notification.setMessage(message);
        notification.setType(type);
        notificationRepository.save(notification);
    }
}

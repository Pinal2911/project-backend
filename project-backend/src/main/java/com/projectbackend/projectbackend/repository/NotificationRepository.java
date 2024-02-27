package com.projectbackend.projectbackend.repository;

import com.projectbackend.projectbackend.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notifications,Long> {
}

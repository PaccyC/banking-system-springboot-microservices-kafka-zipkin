package com.paccy.banking_system.notification_service.repository;

import com.paccy.banking_system.notification_service.entities.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,String> {
}

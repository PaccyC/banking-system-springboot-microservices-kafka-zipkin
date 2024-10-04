package com.paccy.banking_system.notification_service.kafka;

import com.paccy.banking_system.notification_service.email.EmailService;
import com.paccy.banking_system.notification_service.entities.Notification;
import com.paccy.banking_system.notification_service.kafka.transaction.TransactionSuccessMessage;
import com.paccy.banking_system.notification_service.repository.NotificationRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionConsumer {

private final NotificationRepository notificationRepository;
private final EmailService emailService;

@KafkaListener(topics = "transaction-topic")
public void consumeTransactionSuccessNotification( TransactionSuccessMessage transactionSuccessMessage) throws MessagingException {
    log.info("Consuming transaction success notification");
    log.info("Received transaction: {}", transactionSuccessMessage);

    Notification notification= Notification
            .builder()
            .notificationTime(LocalDateTime.now())
            .transactionConfirmation(transactionSuccessMessage)
            .build();
    log.info("Saving notification for transaction: {}", transactionSuccessMessage.transactionId());
    notificationRepository.save(notification);
    log.info("Notification saved successfully");

//    Sending an email

    emailService.sendTransactionEmail(
            transactionSuccessMessage.amount(),
            transactionSuccessMessage.transactionId()

    );



}


}

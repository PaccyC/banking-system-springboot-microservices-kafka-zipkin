package com.paccy.banking_system.notification_service.entities;


import com.paccy.banking_system.notification_service.kafka.transaction.TransactionSuccessMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document
public class Notification {

    @Id
    private String id;
    private LocalDateTime notificationTime;
    private TransactionSuccessMessage transactionConfirmation;
}

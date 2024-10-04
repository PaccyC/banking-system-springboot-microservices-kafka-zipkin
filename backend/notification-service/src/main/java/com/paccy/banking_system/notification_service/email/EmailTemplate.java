package com.paccy.banking_system.notification_service.email;

import lombok.Getter;

public enum EmailTemplate {


    TRANSACTION_CONFIRMATION("Transaction confirmation","/templates/transactionConfirmation.html");

    @Getter
    private String templateName;
    @Getter
    private String subject;

    EmailTemplate( String templateName, String subject) {
        this.templateName = templateName;
        this.subject = subject;
    }
}

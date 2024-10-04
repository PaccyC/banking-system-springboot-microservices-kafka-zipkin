package com.paccy.notification_service.kafka.transaction;

import com.paccy.banking_system.notification_service.email.EmailService;
import com.paccy.banking_system.notification_service.kafka.TransactionConsumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.mail.MessagingException;

import static org.mockito.Mockito.doNothing;

public class TransactionConsumerTest {

    @Mock
    private EmailService emailService;


    @InjectMocks
    private TransactionConsumer transactionConsumer;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendEmail() throws MessagingException, jakarta.mail.MessagingException {
        // Mock the behavior of sendTransactionEmail if necessary
        doNothing().when(emailService).sendTransactionEmail(100.0,"test-transaction-id" );


    }
}

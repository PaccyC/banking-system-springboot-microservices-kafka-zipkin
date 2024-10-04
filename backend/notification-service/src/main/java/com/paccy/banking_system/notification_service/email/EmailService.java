package com.paccy.banking_system.notification_service.email;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;


    @Async
    public void sendTransactionEmail(
            Double amount,
            String transactionId
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        messageHelper.setTo("paccy@gmail.com");

        final String templateName = EmailTemplate.TRANSACTION_CONFIRMATION.getTemplateName();

        Map<String, Object> variables = new HashMap<>();

        variables.put("amount", amount);

        Context context = new Context();
        context.setVariables(variables);

        messageHelper.setSubject(EmailTemplate.TRANSACTION_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);
            messageHelper.setTo("paccy@gmail.com");
            mailSender.send(mimeMessage);
            log.info(format("Email sent to %s successfully with template %s", "paccy@gmail.com", templateName));

        } catch (MessagingException e) {
            log.error(format("Email sent to %s failed", "paccy@gmail.com"), e);
        }


    }

}

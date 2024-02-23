package com.andersenlab.cognitotest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class SimpleEmail {
    @Autowired
    EmailSenderService emailSenderService;

    @Test
    void sendSimpleEmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("benzol.45@gmail.com");
        simpleMailMessage.setTo("benzol.45@gmail.com"); //SANDBOX !!! mode
        simpleMailMessage.setSubject("test subject");
        simpleMailMessage.setText("test text");

        emailSenderService.sendSimpleMailMessage(simpleMailMessage);
    }
}

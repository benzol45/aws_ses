package com.andersenlab.cognitotest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
class InterestingEmail {
    @Autowired
    EmailSenderService emailSenderService;
    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    void sendInterestingEmail() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,  true, "UTF-8");
        helper.addTo("benzol.45@gmail.com");
        helper.setFrom("benzol.45@gmail.com");

        InputStreamSource data = new ByteArrayResource("HELLO WORLD".getBytes());

        helper.addAttachment("test.txt", data );
        helper.setSubject("test subject with attachment");
        helper.setText("mime <b>body</b>", true);

        emailSenderService.sendInterestingMailMessage(message);
    }
}

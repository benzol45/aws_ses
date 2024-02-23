package com.andersenlab.cognitotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


@Service
public class EmailSenderService {
    @Autowired
    private MailSender mailSender;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.mailSender.send(simpleMailMessage);
    }

    public void sendInterestingMailMessage(MimeMessage message) {
        this.javaMailSender.send(message);
    }
}

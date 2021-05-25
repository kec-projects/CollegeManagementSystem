package com.collegemanagementsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class SendEmailService {
    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(String email, String subject, String messageContext) throws MessagingException, UnsupportedEncodingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        //helper.setFrom("gouravk842@gmail.com","Gourav");
        helper.setTo(email);

        helper.setSubject(subject);

        helper.setText(messageContext, true);

        mailSender.send(message);
    }

}

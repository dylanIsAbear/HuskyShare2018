package com.example.demo.Config;

import org.hibernate.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

@Component
public class EmailFactory {
    private static EmailFactory emailFactory = new EmailFactory();

    @Bean
    public EmailFactory getEmailFactory(){
        return emailFactory;
    }


    public void sendMessage(
            InternetAddress[] addresses,
            String content,
            String subject,
            String[] attachments)
            throws
            MessagingException,
            IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        //Gmail server setup

        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("dylanIsAbear@gmail.com", "20001018lyh1");
            }
        });

        Message msg = new MimeMessage(session);

        ((MimeMessage) msg).setFrom(new InternetAddress("dylanIsAbear@gmail.com",false));

        msg.setRecipients(Message.RecipientType.TO, addresses);
        msg.setSubject(subject);
        msg.setContent(content, "text/html");

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(content, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        if(attachments != null) {
            for (String addr : attachments) {
                MimeBodyPart attatch = new MimeBodyPart();
                attatch.attachFile(addr);
                multipart.addBodyPart(attatch);
            }
        }

        msg.setContent(multipart);
        Transport.send(msg);
    }
}

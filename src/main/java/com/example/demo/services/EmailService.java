package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import sun.jvm.hotspot.debugger.AddressException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

@Service
public class EmailService {

    public void sendMail(Message msg) throws AddressException, MessagingException {
        Transport.send(msg);
    }

    public Message getMessage(Address[] addresses,
                              String content,
                              String subject,
                              String username,
                              String password,
                              String[] attachments)
            throws javax.mail.internet.AddressException,
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
                return new PasswordAuthentication
                        (username, password);
            }
        });

        Message msg = new MimeMessage(session);
        ((MimeMessage) msg).setFrom(new InternetAddress(username,false));

        msg.setRecipients(Message.RecipientType.TO, addresses);
        msg.setSubject(subject);
        msg.setContent(content, "text/html");

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(content, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        for(String addr : attachments){
            MimeBodyPart attatch = new MimeBodyPart();
            attatch.attachFile(addr);
            multipart.addBodyPart(attatch);
        }

        msg.setContent(multipart);
        return msg;
    }
}

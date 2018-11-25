package com.example.demo.controller;

import com.example.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.debugger.AddressException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailServiceController {
    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/email/sendmailto", method = RequestMethod.POST)
    public void sendMail(@RequestBody Message msg) throws AddressException, MessagingException {
        emailService.sendMail(msg);
    }

    @RequestMapping(value = "/email/createmail", method = RequestMethod.POST)
    public Message getMessage(@RequestParam("address") Address[] addresses,
                              @RequestParam("content") String content,
                              @RequestParam("subject") String subject,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("attachments") String[] attachments)
            throws javax.mail.internet.AddressException,
            MessagingException,
            IOException{
        return emailService.getMessage(addresses,content,subject,username,password,attachments);
    }

}

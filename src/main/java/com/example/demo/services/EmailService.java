package com.example.demo.services;

import com.example.demo.Config.EmailFactory;
import com.sun.xml.internal.ws.api.message.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.AddressException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;


@Service
public class EmailService {
    @Autowired
    EmailFactory emailFactory;

    public Message postMessage(InternetAddress[] addresses, String content, String subject, String[] attachments){
        Message message = null;
        try {
            emailFactory.sendMessage(addresses, content, subject, attachments);
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }
}

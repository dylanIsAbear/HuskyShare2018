package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.services.EmailService;
import com.example.demo.services.UserService;
import com.example.demo.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

@RestController
public class RegistrationController {
    @Autowired
    UserService userService;
    @Autowired
    ValidationService validationService;
    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public String registry(@RequestBody User user){
        //Save the uid and validation code
        String result = userService.registry(user);
        if(result.equals("TO_VALIDATION")) {
            int vcode = validationService.generateVCode();
            System.out.println(validationService.saveVCode(user, vcode));
            try {
                InternetAddress[] address = InternetAddress.parse("dylanisabear@gmail.com,joey.jiayi.pan@gmail.com");
                emailService.postMessage(address,
                        "Your validation code is: " + vcode,
                       "Welcome to huskyshare",
                        null);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(@RequestParam("id") int uid){
        return "code is: " + validationService.testVCode(uid);
    }

    @RequestMapping(value = "/registry/validation", method = RequestMethod.POST)
    public String validate(@RequestParam("vcode") int vcode,
                           @RequestParam("id") int uid){
        if(validationService.checkVCode(uid,  vcode)) {
            userService.updateUserStatus(1, uid);
            return "Successfully";
        }
        else{
            return "Failed";
        }
       // return false;
    }

    @RequestMapping(value = "/registry/validation", method = RequestMethod.GET)
    public String validEmail(@RequestParam("email") String email){

        return "EMAIL_SEND";
    }
}

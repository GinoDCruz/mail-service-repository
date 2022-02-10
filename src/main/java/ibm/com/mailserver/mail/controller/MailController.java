package ibm.com.mailserver.mail.controller;

import ibm.com.mailserver.mail.entity.Mail;
import ibm.com.mailserver.mail.entity.User;
import ibm.com.mailserver.mail.service.UserServiceAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ibm.com.mailserver.mail.service.MailService;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
@RequestMapping("/mail")
public class MailController{

    private MailService mailService;
    private UserServiceAPI userServiceAPI;
    Logger logger = LoggerFactory.getLogger(MailController.class);

    @Autowired
    public void setService(MailService mailService, UserServiceAPI userServiceAPI){
        this.mailService = mailService;
        this.userServiceAPI = userServiceAPI;
    }

    @GetMapping ("/get/user/all")
    public Iterable<User> getUsers(){
        return Arrays.asList(userServiceAPI.getAllUsers());
    }

    @GetMapping("/get/user")
    public User getUserByEmail(@RequestParam String emailAddress){
        return userServiceAPI.getUserByEmail(emailAddress);
    }

    @GetMapping("/inbox/sent")
    public Iterable<Mail> getSentMail(@RequestParam String emailAddress){
        return mailService.getMailBySender(emailAddress);
    }

    @GetMapping("/inbox/received")
    public Iterable<Mail> getReceivedMail(@RequestParam String emailAddress){
        return mailService.getMailByRecipient(emailAddress);
    }

    @GetMapping("/inbox/cc")
    public Iterable<Mail> getCCMail(@RequestParam String emailAddress){
        return mailService.getMailbyCC((emailAddress));
    }

    @PostMapping("/create")
    public Mail create(@RequestBody Mail mail){
        return mailService.createMail(mail);
    }

    @PutMapping("/forward")
    public Mail forwardMail(@RequestBody Mail mail){
        return mailService.forwardMail(mail);
    }

    @DeleteMapping("/delete")
    public Iterable<Mail> deleteMail(@RequestParam Long mail_id){
        return mailService.deleteMail(mail_id);
    }
}


//include proper response
//Get received mail by user
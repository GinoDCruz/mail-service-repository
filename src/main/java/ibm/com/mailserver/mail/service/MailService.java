package ibm.com.mailserver.mail.service;

import ibm.com.mailserver.mail.entity.Mail;
import ibm.com.mailserver.mail.entity.User;
import ibm.com.mailserver.mail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ibm.com.mailserver.mail.repository.MailRepository;

import java.util.Date;

@Service
public class MailService {

    private MailRepository mailRepository;
    private UserRepository userRepository;
    private UserServiceAPI userServiceAPI;

    @Autowired
    public void setRepository(MailRepository mailRepository,UserRepository userRepository, UserServiceAPI userServiceAPI){
        this.mailRepository = mailRepository;
        this.userRepository = userRepository;
        this.userServiceAPI = userServiceAPI;
    }

    public Mail createMail(Mail mail){

        //Validate Session hash

        mail.setDateSent(new Date());
        mail.setDateReceived(new Date());

        userRepository.save(userServiceAPI.getUserByEmail(mail.getSender().getEmailAddress()));
        userRepository.saveAll(userServiceAPI.getUsersByEmail(mail.getRecipients()));
        userRepository.saveAll(userServiceAPI.getUsersByEmail(mail.getCc()));

        return mailRepository.save(mail);
    }

    public Mail getMail(Long id){
        return mailRepository.findById(id).get();
    }

    public Iterable<Mail> getMailBySender(String sender){
        return  mailRepository.findAllBySender(userServiceAPI.getUserByEmail(sender));
    }

    public Iterable<Mail> getMailByRecipient(String emailAddress){
        return mailRepository.findAllByRecipients(userServiceAPI.getUserByEmail(emailAddress));
    }

    public Iterable<Mail> getMailbyCC(String emailAddress){
        return mailRepository.findAllByCc(userServiceAPI.getUserByEmail(emailAddress));
    }

    public Mail forwardMail(Mail mail){
        userRepository.saveAll(userServiceAPI.getUsersByEmail(mail.getRecipients()));

        return  mailRepository.save(mail);
    }

    public Iterable<Mail> deleteMail(Long id){
        if(mailRepository.existsById(id)){
            mailRepository.deleteById(id);
        }
        return mailRepository.findAll();
    }
}

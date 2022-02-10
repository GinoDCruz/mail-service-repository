package ibm.com.mailserver.mail.service;

import ibm.com.mailserver.mail.entity.Session;
import ibm.com.mailserver.mail.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserServiceAPI {
    
    public User[] getAllUsers(){



        final String uri = "http://localhost:8080/user/get/all";
        //logger.error("An Error Message");
        RestTemplate restTemplate = new RestTemplate();
        User[] result = restTemplate.getForObject(uri, User[].class);
        return result;
    }

    public User getUserByEmail(String emailAddress){
        final String uri = "http://localhost:8080/user/get/email?emailAddress=" + emailAddress;
        //logger.error("An Error Message");
        RestTemplate restTemplate = new RestTemplate();
        User result = restTemplate.getForObject(uri, User.class);
        return result;
    }

    public List<User> getUsersByEmail(List<User> emailAddresses){
        List<String> emails = new ArrayList<>();

        for(User user: emailAddresses){
            emails.add(user.getEmailAddress());
        }

        final String uri = "http://localhost:8080/user/get/emails?emailAddresses=" + String.join(",",emails);
        //System.out.println(uri);
        //logger.error("An Error Message");
        RestTemplate restTemplate = new RestTemplate();
        User[] result = restTemplate.getForObject(uri, User[].class);
        return Arrays.asList(result);
    }

    public Session isValidSession(String sessionHash){
        final String uri = "http://localhost:8080/user/get/session?sessionHash=" + sessionHash;
        //logger.error("An Error Message");
        RestTemplate restTemplate = new RestTemplate();
        Session result = restTemplate.getForObject(uri, Session.class);
        return result;
    }
}
package ibm.com.mailserver.mail.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mail_id;

    @OneToOne
    private User sender;

    @OneToMany
    private List<User> recipients;

    @OneToMany
    private List<User> cc;

    private String subject;
    private String body;
    private Date dateSent;
    private Date dateReceived;

    public Long getMail_id() {
        return mail_id;
    }

    public void setMail_id(Long mail_id) {
        this.mail_id = mail_id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<User> recipients) {
        this.recipients = recipients;
    }

    public List<User> getCc() {
        return cc;
    }

    public void setCc(List<User> cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }
}

//Create
//Get
//Forward
//Delete

//Call Endpoint
//Serialize into Java Object
//Integrate into mail service
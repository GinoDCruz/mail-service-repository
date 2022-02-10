package ibm.com.mailserver.mail.repository;

import ibm.com.mailserver.mail.entity.Mail;
import ibm.com.mailserver.mail.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailRepository extends JpaRepository<Mail, Long> {
    public List<Mail> findAllBySender(User sender);
    public List<Mail> findAllByRecipients(User recipients);
    public List<Mail> findAllByCc(User cc);


}

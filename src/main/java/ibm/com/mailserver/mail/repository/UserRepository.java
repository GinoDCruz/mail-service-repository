package ibm.com.mailserver.mail.repository;

import ibm.com.mailserver.mail.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

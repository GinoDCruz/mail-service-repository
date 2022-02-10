package ibm.com.mailserver.mail.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Session {

    @Id
    private Long session_id;

    private String sessionHash;

    private boolean isActive;

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getSessionHash() {
        return sessionHash;
    }

    public void setSessionHash(String sessionHash) {
        this.sessionHash = sessionHash;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

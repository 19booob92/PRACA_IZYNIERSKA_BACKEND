package sample.data.jpa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;

    private User user;

    private String role;

    public UserRole() {
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }
}

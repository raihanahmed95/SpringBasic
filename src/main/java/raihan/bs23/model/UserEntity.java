package raihan.bs23.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Raihan on 6/21/2017.
 */
@Entity
@Table(name = "USER_ACCOUNT")
public class UserEntity {

    @Id
    @Column
    @SequenceGenerator(name = "UserAccountIdGenerator" , sequenceName = "USER_ACCOUNT__ID" , initialValue = 1 , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "UserAccountIdGenerator")
    private int id;

    @Column(name = "username" , unique=true, nullable = false)
    @NotEmpty
    private String username;

    @Column(name = "password" , nullable = false)
    @NotEmpty
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

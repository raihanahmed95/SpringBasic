package raihan.bs23.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Raihan on 7/3/2017.
 */
@Entity
@Table(name = "PROJECT_PROFILE")
public class ProjectProfile {
    @Id
    @Column
    @SequenceGenerator(name = "ProjectProfileIdGenerator" , sequenceName = "PROJECT_PROFILE__ID" , initialValue = 1 , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "ProjectProfileIdGenerator")
    private int id;

    @Column(name = "name" , unique=true, nullable = false)
    @NotEmpty
    private String username;

    @Column(name = "status")
    @NotEmpty
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

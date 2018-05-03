package raihan.bs23.model;

import javax.persistence.*;

/**
 * Created by Raihan on 6/21/2017.
 */
@Entity
@Table(name = "USER_PERMISSION")
public class UserPermission {

    @Id
    @Column
    @SequenceGenerator(name = "UserPermissionIdGenerator", sequenceName = "USER_PERMISSION__ID", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserPermissionIdGenerator")
    private int id;

    @Column(name = "USER_ID", nullable = false , length = 10)
    private int user_id;

    @Column(name = "USER_ROLE_ID", nullable = false , length = 10)
    private int user_role_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }
}

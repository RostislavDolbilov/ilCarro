package ilcarro.model.auth;

/* @author Rostislav Dolbilov */

import ilcarro.dto.Status;
import lombok.*;
import ilcarro.dto.user.UserAuth;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "users")
public class User extends Base {
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    public UserAuth toUserAuthDto(){
        UserAuth user = new UserAuth();
        user.setUsername(username);
        user.setCreated(super.getCreated());
        user.setUpdated(super.getUpdated());
        user.setStatus(status);
        user.setRoles(roles);
        return user;
    }
}

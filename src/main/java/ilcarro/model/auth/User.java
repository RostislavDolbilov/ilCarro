package ilcarro.model.auth;

/* @author Rostislav Dolbilov */

import lombok.Data;
import lombok.EqualsAndHashCode;
import ilcarro.dto.UserAuthDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    public UserAuthDto toUserAuthDto(){
        UserAuthDto user = new UserAuthDto();
        user.setUsername(username);
        user.setCreated(super.getCreated());
        user.setUpdated(super.getUpdated());
        user.setStatus(super.getStatus());
        user.setRoles(roles);

        return user;
    }
}

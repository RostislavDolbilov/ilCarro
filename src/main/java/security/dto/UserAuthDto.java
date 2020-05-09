package security.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import security.model.auth.Role;
import security.model.auth.User;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserAuthDto {
    private String username;
    private LocalDate created;
    private LocalDate updated;
    private Status status;
    private List<Role> roles;

    public User toUser(){
        User user = new User();
        user.setUsername(username);
        user.setCreated(created);
        user.setUpdated(updated);
        user.setStatus(status);
        user.setRoles(roles);
        return user;
    }
}

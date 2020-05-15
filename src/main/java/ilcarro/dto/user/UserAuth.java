package ilcarro.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ilcarro.dto.Status;
import ilcarro.model.auth.Role;
import ilcarro.model.auth.User;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserAuth {
    private String username;
    private LocalDateTime created;
    private LocalDateTime updated;
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

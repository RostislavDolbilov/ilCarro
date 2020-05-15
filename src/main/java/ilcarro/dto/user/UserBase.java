package ilcarro.dto.user;

import ilcarro.dto.Status;
import lombok.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class UserBase {
    private String userNameMail;
    private String firstName;
    private String secondName;
    private String password;
    private Status status;
}

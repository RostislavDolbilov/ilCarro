package ilcarro.dto.auth;

import lombok.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class AuthenticationRequestDto {
    private String username;
    private String password;
}

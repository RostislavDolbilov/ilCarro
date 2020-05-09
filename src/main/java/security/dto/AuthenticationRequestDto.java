package security.dto;

import lombok.Data;

/* @author Rostislav Dolbilov */

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}

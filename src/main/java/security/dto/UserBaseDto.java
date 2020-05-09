package security.dto;

import lombok.Data;

/* @author Rostislav Dolbilov */

@Data
public class UserBaseDto {
    private String userNameMail;
    private String firstName;
    private String secondName;
    private String password;
    private Status status;
}

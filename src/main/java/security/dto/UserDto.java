package security.dto;

import lombok.Data;
import security.model.app.UserEntity;

/* @author Rostislav Dolbilov */

@Data
public class UserDto {
    private String usernameMail;
    private String photo;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private Status status;

    /*
    private List<CarDto> cars;
    private List<RentDto> rents;
     */

    public UserEntity toUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsernameMail(usernameMail);
        userEntity.setFirstName(firstName);
        userEntity.setSecondName(secondName);
        userEntity.setPhoneNumber(phoneNumber);
        userEntity.setPhoto(photo);
        userEntity.setStatus(status);
        return userEntity;
    }
}

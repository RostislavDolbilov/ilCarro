package ilcarro.dto.user;

import ilcarro.dto.Status;
import ilcarro.dto.car.Car;
import ilcarro.model.app.user.UserEntity;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class UserDto {
    private String usernameMail;
    private String photo;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private Status status;
    private List<Car> cars;

    public UserEntity toUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsernameMail(usernameMail);
        userEntity.setFirstName(firstName);
        userEntity.setSecondName(secondName);
        userEntity.setPhoneNumber(phoneNumber);
        userEntity.setPhoto(photo);
        userEntity.setStatus(status);
        if (cars != null){
            userEntity.setCars(cars
                    .stream().map(Car::toCarEntity)
                    .collect(Collectors.toList()));
        }
        return userEntity;
    }
}

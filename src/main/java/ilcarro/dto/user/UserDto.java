package ilcarro.dto.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ilcarro.dto.Status;
import ilcarro.dto.car.Car;
import ilcarro.dto.car.Rent;
import ilcarro.model.app.car.RentEntity;
import ilcarro.model.app.user.UserEntity;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
    private List<Rent> rents;

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
        if (rents != null) {
            userEntity.setRents(rents
                    .stream().map(Rent::toRentEntity)
                    .collect(Collectors.toList()));
        }
        return userEntity;
    }
}

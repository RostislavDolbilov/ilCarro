package ilcarro.model.app.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ilcarro.dto.user.UserBase;
import ilcarro.model.Base;
import ilcarro.model.app.car.CarEntity;
import ilcarro.model.app.car.RentEntity;
import lombok.*;
import ilcarro.dto.user.UserDto;
import ilcarro.dto.Status;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "users")
public class UserEntity extends Base {
    @Column(name = "username_email", unique = true)
    private String usernameMail;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "photo")
    private String photo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @JsonBackReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "user")
    private List<CarEntity> cars;

    @JsonBackReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "userEntity")
    private List<RentEntity> rents;

    public UserEntity(UserBase user) {
        this.usernameMail = user.getUserNameMail();
        this.firstName = user.getFirstName();
        this.secondName = user.getSecondName();
        this.status = user.getStatus();
    }

    public UserDto toUserDto(){
        UserDto user = new UserDto();
        user.setUsernameMail(usernameMail);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setPhoneNumber(phoneNumber);
        user.setPhoto(photo);
        user.setStatus(status);
        if (cars != null){
            user.setCars(cars
                    .stream().map(CarEntity::toCar)
                    .collect(Collectors.toList()));
        }
        if (rents != null){
            user.setRents(rents
                    .stream().map(RentEntity::toRent)
                    .collect(Collectors.toList()));
        }
        return user;
    }
}

package ilcarro.model.app;

import ilcarro.dto.UserBaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import ilcarro.dto.UserDto;
import ilcarro.dto.Status;

import javax.persistence.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    /*
    @OneToMany
    private List<CarDto> cars;

    @OneToMany
    private List<RentDto> rents;
     */

    public UserEntity(UserBaseDto user) {
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
        return user;
    }
}

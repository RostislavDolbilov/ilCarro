package security.service;

import security.dto.Status;
import security.dto.UserAuthDto;
import security.dto.UserBaseDto;
import security.dto.UserDto;
import security.exeptions.ActionDeniedException;
import security.model.auth.User;
import java.util.List;


public interface UserService {
    /* ADMIN */
    List<UserAuthDto> getAllRegisteredUsers();
    List<UserAuthDto> getAllActiveUsers(Status status);
    List<UserAuthDto> getAllDeletedUsers(Status status);
    List<UserAuthDto> getAllAdminUsers(Status status);
    List<UserAuthDto> getAllUserUsers();
    User findByUsername(String username);
    User findById(Long id);
    UserDto addRoleAdmin();
//    RentsDto getAllRents();

    /* USER */
    void deleteUser(String username);
    UserDto updateUser(UserDto user);

//    List<CarDto> getOwnerCars(String username);
//    List<RentDto> getOwnerRents(String username);


    /*  NOT REGISTERED USERS */
    UserDto registration(UserBaseDto user) throws ActionDeniedException;
    UserDto findByUsernameMail(String email);
}

package ilcarro.service;

import ilcarro.exeptions.ActionDeniedException;
import ilcarro.model.auth.User;
import ilcarro.dto.Status;
import ilcarro.dto.UserAuthDto;
import ilcarro.dto.UserBaseDto;
import ilcarro.dto.UserDto;

import java.util.List;


public interface UserService {
    /* ADMIN */
    List<UserAuthDto> getAllRegisteredUsers();
    List<UserAuthDto> getAllActiveUsers();
    List<UserAuthDto> getAllDeletedUsers();
    List<UserAuthDto> getAllAdminUsers();
    List<UserAuthDto> getAllUserUsers();
    User findByUsername(String username);
    User findById(Long id);
    UserDto addRoleAdmin();
//    RentsDto getAllRents();

    /* USER */
    UserDto deleteUser(String username);
    UserDto returnUser(String username);
    UserDto updateUser(UserDto user);

//    List<CarDto> getOwnerCars(String username);
//    List<RentDto> getOwnerRents(String username);


    /*  NOT REGISTERED USERS */
    UserDto registration(UserBaseDto user) throws ActionDeniedException;
    UserDto findByUsernameMail(String email);
}

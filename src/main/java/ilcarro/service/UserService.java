package ilcarro.service;

import ilcarro.exeptions.ActionDeniedException;
import ilcarro.model.auth.User;
import ilcarro.dto.Status;
import ilcarro.dto.UserAuthDto;
import ilcarro.dto.UserBaseDto;
import ilcarro.dto.UserDto;
import javassist.NotFoundException;

import java.util.List;


public interface UserService {
    /* ADMIN */
    List<UserAuthDto> getAllRegisteredUsers();
    List<UserAuthDto> getAllActiveUsers();
    List<UserAuthDto> getAllDeletedUsers();
    List<UserAuthDto> getAllAdminUsers();
    User findByUsername(String username) throws NotFoundException;
    User findById(Long id) throws NotFoundException;
    UserDto addRoleAdmin();
//    RentsDto getAllRents();

    /* USER */
    UserDto deleteUser(String username) throws NotFoundException;
    UserDto returnUser(String username);
    UserDto updateUser(UserDto user);
    UserDto changePassword(String password);

//    List<CarDto> getOwnerCars(String username);
//    List<RentDto> getOwnerRents(String username);


    /*  NOT REGISTERED USERS */
    UserDto registration(UserBaseDto user) throws ActionDeniedException;
    UserDto findByUsernameMail(String email) throws NotFoundException;
}

package ilcarro.service;

import ilcarro.exeptions.ActionDeniedException;
import ilcarro.dto.user.UserAuth;
import ilcarro.dto.user.UserBase;
import ilcarro.dto.user.UserDto;
import javassist.NotFoundException;

import java.util.List;


public interface UserService {
    /* ADMIN */
    List<UserAuth> getAllRegisteredUsers();
    List<UserAuth> getAllActiveUsers();
    List<UserAuth> getAllDeletedUsers();
    List<UserAuth> getAllAdminUsers();
    ilcarro.model.auth.User findByUsername(String username) throws NotFoundException;
    ilcarro.model.auth.User findById(Long id) throws NotFoundException;
    UserDto addRoleAdmin();
//    RentsDto getAllRents();

    /* USER */
    UserDto deleteUser(String username) throws NotFoundException;
    UserDto returnUser(String username);
    UserDto updateUser(UserDto user);
    String changePassword(String password);

//    List<CarDto> getOwnerCars(String username);
//    List<RentDto> getOwnerRents(String username);
//    UserDto addCar(CarDto car);
//    RentDto makeRent(RentDto rent);
//    RentDto updateRent(RentDto rent);
//    String payRent(String rentId);
//    String validRent(String rentId);
//    String closeRent(String rentId);
//    CommentDto makeComment(CommentDto comment);
//    CommentDto updateComment(CommentDto comment);
//    CommentDto deleteComment(CommentDto comment);


    /*  NOT REGISTERED USERS */
    UserDto registration(UserBase user) throws ActionDeniedException;
    UserDto findByUsernameMail(String email) throws NotFoundException;
}

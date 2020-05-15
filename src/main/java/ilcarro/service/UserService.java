package ilcarro.service;

import ilcarro.dto.user.UserDto;
import javassist.NotFoundException;

/* @author Rostislav Dolbilov */

public interface UserService {
    UserDto deleteUser(String username) throws NotFoundException;
    UserDto returnUser(String username);
    UserDto updateUser(UserDto user);
    String changePassword(String password);
}

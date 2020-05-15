package ilcarro.service;

import ilcarro.dto.user.UserBase;
import ilcarro.dto.user.UserDto;
import ilcarro.exeptions.ActionDeniedException;
import javassist.NotFoundException;

/* @author Rostislav Dolbilov */

public interface AppService {
    UserDto registration(UserBase user) throws ActionDeniedException;
    UserDto findByUsernameMail(String email) throws NotFoundException;
}

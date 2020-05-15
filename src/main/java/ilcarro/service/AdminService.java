package ilcarro.service;

import ilcarro.dto.user.UserAuth;
import ilcarro.dto.user.UserDto;
import javassist.NotFoundException;
import java.util.List;

/* @author Rostislav Dolbilov */

public interface AdminService {
    List<UserAuth> getAllRegisteredUsers();
    List<UserAuth> getAllActiveUsers();
    List<UserAuth> getAllDeletedUsers();
    List<UserAuth> getAllAdminUsers();
    ilcarro.model.auth.User findByUsername(String username) throws NotFoundException;
    ilcarro.model.auth.User findById(Long id) throws NotFoundException;
    UserDto addRoleAdmin();
}

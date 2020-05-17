package ilcarro.service;

import ilcarro.dto.car.*;
import ilcarro.dto.user.UserAuth;
import ilcarro.dto.user.UserDto;
import ilcarro.exeptions.ActionDeniedException;
import ilcarro.model.auth.User;
import javassist.NotFoundException;

import javax.transaction.Transactional;
import java.util.List;

/* @author Rostislav Dolbilov */

public interface AdminService {
    List<UserAuth> getAllRegisteredUsers();
    List<UserAuth> getAllActiveUsers();
    List<UserAuth> getAllDeletedUsers();
    List<UserAuth> getAllAdminUsers();
    User findByUsername(String username) throws NotFoundException;
    User findById(Long id) throws NotFoundException;
    UserAuth giveRoleAdmin(String username);

    Fuel uploadFuel(Fuel fuel) throws ActionDeniedException;
    void deleteFuel(String fuel) throws NotFoundException;

    Manufacturer uploadManufacturer(Manufacturer manufacturer) throws ActionDeniedException;
    void deleteManufacturer(String manufacturer) throws NotFoundException;

    Model uploadModel(Model model);
    void deleteModel(String model);

    Transmission uploadTransmission(Transmission transmission);
    void deleteTransmission(String transmission);

    WheelDrive uploadWheelDrive(WheelDrive wheelDrive);
    void deleteWheelDrive(String wheelDrive);
}

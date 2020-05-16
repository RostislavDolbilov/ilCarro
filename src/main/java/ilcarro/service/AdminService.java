package ilcarro.service;

import ilcarro.dto.car.*;
import ilcarro.dto.user.UserAuth;
import ilcarro.dto.user.UserDto;
import javassist.NotFoundException;

import javax.transaction.Transactional;
import java.util.List;

/* @author Rostislav Dolbilov */

public interface AdminService {
    List<UserAuth> getAllRegisteredUsers();
    List<UserAuth> getAllActiveUsers();
    List<UserAuth> getAllDeletedUsers();
    List<UserAuth> getAllAdminUsers();
    ilcarro.model.auth.User findByUsername(String username) throws NotFoundException;
    ilcarro.model.auth.User findById(Long id) throws NotFoundException;
    UserDto giveRoleAdmin();

    Fuel uploadFuel(Fuel fuel);
    void deleteFuel(String fuel);

    Manufacturer uploadManufacturer(Manufacturer manufacturer);
    void deleteManufacturer(String manufacturer);

    Model uploadModel(Model model);
    void deleteModel(String model);

    Transmission uploadTransmission(Transmission transmission);
    void deleteTransmission(String transmission);

    WheelDrive uploadWheelDrive(WheelDrive wheelDrive);
    void deleteWheelDrive(String wheelDrive);
}

package ilcarro.service;

import ilcarro.dto.car.*;
import ilcarro.dto.user.UserBase;
import ilcarro.dto.user.UserDto;
import ilcarro.exeptions.ActionDeniedException;
import javassist.NotFoundException;

import java.util.List;

/* @author Rostislav Dolbilov */

public interface AppService {
    UserDto registration(UserBase user) throws ActionDeniedException;
    UserDto findByUsernameMail(String email) throws NotFoundException;

    WheelDrive getWheelDriveByWheelDriveName(String wheelDrive);
    Fuel getFuelByFuelName(String fuel);
    Model getModelByModelName(String model);
    Transmission getTransmissionByTransmissionName(String transmission);
    Manufacturer getManufacturerByManufacturerName(String manufacturer);

//    List<Car> sortCarsByFilter(SortFilter sortFilter);
//    List<Car> getCarsByFilter(CarFilter carFilter);
}

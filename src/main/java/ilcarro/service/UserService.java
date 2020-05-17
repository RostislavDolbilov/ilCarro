package ilcarro.service;

import ilcarro.dto.car.*;
import ilcarro.dto.user.UserDto;
import javassist.NotFoundException;

/* @author Rostislav Dolbilov */

public interface UserService {
    UserDto deleteUser(String username) throws NotFoundException;
    UserDto returnUser(String username);
    String changePassword(String password);

    WheelDrive getWheelDriveByWheelDriveName(String wheelDrive);
    Fuel getFuelByFuelName(String fuel) throws NotFoundException;
    Model getModelByModelName(String model);
    Transmission getTransmissionByTransmissionName(String transmission);
    Manufacturer getManufacturerByManufacturerName(String manufacturer) throws NotFoundException;

    UserDto updateUser(UserDto user);

    Car uploadCarr(Car car);
    Car updateCar(Car car);
    void deleteCar(String serialNumber);
    Car getCarBySerialNumber(String serialNumber);

    Comments addComment(Comments comments);
    Comments updateComment(Comments comments);
    void deleteComments(int idComment);
    Comments getCommentById(int idComment);

    Images uploadImages(Images images);
    void deleteImage(int idImg);
    Images getIdImage(Images image);

    Location addLocation(Location location);
    Location updateLocation(Location location);
}

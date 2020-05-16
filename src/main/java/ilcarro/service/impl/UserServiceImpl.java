package ilcarro.service.impl;

import ilcarro.dto.car.Car;
import ilcarro.dto.car.Comments;
import ilcarro.dto.car.Images;
import ilcarro.dto.car.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ilcarro.dto.user.UserDto;
import ilcarro.model.app.user.UserEntity;
import ilcarro.dto.Status;
import ilcarro.repository.app.UserEntityRepository;
import ilcarro.repository.auth.UserRepository;
import ilcarro.service.UserService;
import javax.transaction.Transactional;

/* @author Rostislav Dolbilov */

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserEntityRepository userEntityRepository) {
        this.userRepository = userRepository;
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDto deleteUser(String username) {
        UserEntity user = userEntityRepository.findByUsernameMail(username);
        user.setStatus(Status.DELETED);

        ilcarro.model.auth.User userAuth = userRepository.findByUsername(username);
        userAuth.setStatus(Status.DELETED);

        userRepository.save(userAuth);
        log.info("IN deleteUser - user with id: {} successfully deleted", username);
        return userEntityRepository.save(user).toUserDto();
    }

    @Override
    public UserDto returnUser(String username) {
        UserEntity user = userEntityRepository.findByUsernameMail(username);
        user.setStatus(Status.ACTIVE);

        ilcarro.model.auth.User userAuth = userRepository.findByUsername(username);
        userAuth.setStatus(Status.ACTIVE);

        userRepository.save(userAuth);
        log.info("IN returnUser - user with id: {} successfully returned", username);
        return userEntityRepository.save(user).toUserDto();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        return null;
    }

    @Override
    public Car uploadCarr(Car car) {
        return null;
    }

    @Override
    public Car updateCar(Car car) {
        return null;
    }

    @Override
    public void deleteCar(String serialNumber) {

    }

    @Override
    public Car getCarBySerialNumber(String serialNumber) {
        return null;
    }

    @Override
    public Comments addComment(Comments comments) {
        return null;
    }

    @Override
    public Comments updateComment(Comments comments) {
        return null;
    }

    @Override
    public void deleteComments(int idComment) {

    }

    @Override
    public Comments getCommentById(int idComment) {
        return null;
    }

    @Override
    public Images uploadImages(Images images) {
        return null;
    }

    @Override
    public void deleteImage(int idImg) {

    }

    @Override
    public Images getIdImage(Images image) {
        return null;
    }

    @Override
    public Location addLocation(Location location) {
        return null;
    }

    @Override
    public Location updateLocation(Location location) {
        return null;
    }

    @Override
    public String changePassword(String password) {
        return null;
    }
}

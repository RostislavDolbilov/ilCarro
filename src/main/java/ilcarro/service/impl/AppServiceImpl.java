package ilcarro.service.impl;

import ilcarro.dto.car.*;
import ilcarro.dto.user.UserBase;
import ilcarro.dto.user.UserDto;
import ilcarro.exeptions.ActionDeniedException;
import ilcarro.model.app.user.UserEntity;
import ilcarro.model.auth.Role;
import ilcarro.repository.app.UserEntityRepository;
import ilcarro.repository.auth.RoleRepository;
import ilcarro.repository.auth.UserRepository;
import ilcarro.service.AppService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/* @author Rostislav Dolbilov */

@Service
@Transactional
@Slf4j
public class AppServiceImpl implements AppService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserEntityRepository userEntityRepository;

    @Autowired
    public AppServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder,
                           UserEntityRepository userEntityRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDto registration(UserBase user) throws ActionDeniedException {
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleRepository.findByName("ROLE_USER"));

        UserEntity userEntity = new UserEntity(user);
        userEntity.setCreated(LocalDateTime.now());
        userEntity.setUpdated(LocalDateTime.now());

        ilcarro.model.auth.User newUser = new ilcarro.model.auth.User();
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRoles(userRoles);
        newUser.setStatus(user.getStatus());
        newUser.setUpdated(LocalDateTime.now());
        newUser.setCreated(LocalDateTime.now());
        newUser.setUsername(user.getUserNameMail());

        if (userRepository.findByUsername(user.getUserNameMail()) == null){
            userEntityRepository.save(userEntity);
            userRepository.save(newUser);
            log.info("IN register - user: {} successfully registered", userRepository.save(newUser));
            return userEntity.toUserDto();
        }
        else {
            throw new ActionDeniedException("username and password already exist");
        }
    }

    @Override
    public UserDto findByUsernameMail(String username) throws NotFoundException {
        UserDto user = userEntityRepository.findByUsernameMail(username).toUserDto();
        if (user == null) {
            log.warn("IN findByUsernameMail - no user found by username: {}", username);
            throw  new NotFoundException("User with username: " + username + "not found");
        }
        log.info("IN findByUsernameMail - user: {} found by username: {}", user, username);
        return user;
    }

    @Override
    public WheelDrive getWheelDriveByWheelDriveName(String wheelDrive) {
        return null;
    }

    @Override
    public Fuel getFuelByFuelName(String fuel) {
        return null;
    }

    @Override
    public Model getModelByModelName(String model) {
        return null;
    }

    @Override
    public Transmission getTransmissionByTransmissionName(String transmission) {
        return null;
    }

    @Override
    public Manufacturer getManufacturerByManufacturerName(String manufacturer) {
        return null;
    }
}

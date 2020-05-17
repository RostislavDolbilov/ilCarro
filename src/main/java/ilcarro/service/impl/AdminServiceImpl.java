package ilcarro.service.impl;

import ilcarro.dto.Status;
import ilcarro.dto.car.*;
import ilcarro.dto.user.UserAuth;
import ilcarro.dto.user.UserDto;
import ilcarro.exeptions.ActionDeniedException;
import ilcarro.model.app.car.FuelEntity;
import ilcarro.model.app.car.ManufacturerEntity;
import ilcarro.model.app.user.UserEntity;
import ilcarro.model.auth.Role;
import ilcarro.model.auth.User;
import ilcarro.repository.app.FuelRepository;
import ilcarro.repository.app.ManufacturerRepository;
import ilcarro.repository.app.UserEntityRepository;
import ilcarro.repository.auth.RoleRepository;
import ilcarro.repository.auth.UserRepository;
import ilcarro.service.AdminService;
import ilcarro.service.AppService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* @author Rostislav Dolbilov */

@Service
@Transactional
@Slf4j
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final FuelRepository fuelRepository;
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository,
                          RoleRepository roleRepository,
                          FuelRepository fuelRepository,
                            ManufacturerRepository manufacturerRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.fuelRepository = fuelRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public User findByUsername(String username) throws NotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.warn("IN findByUsername - no user found by username: {}", username);
            throw  new NotFoundException("User with username: " + username + "not found");
        }
        log.info("IN findByUsername - user: {} found by username: {}", user, username);
        return user;
    }

    @Override
    public ilcarro.model.auth.User findById(Long id) throws NotFoundException {
        ilcarro.model.auth.User result = userRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            throw  new NotFoundException("User with id: " + id + "not found");
        }
        log.info("IN findById - user: {} found by id: {}",id,  result);
        return result;
    }

    @Override
    public List<UserAuth> getAllRegisteredUsers() {
        List<UserAuth> result = userRepository.findAll()
                .stream()
                .map(ilcarro.model.auth.User::toUserAuthDto)
                .collect(Collectors.toList());
        log.info("IN getAllRegisteredUsers - {} users found", result.size());
        return result;
    }

    @Override
    public List<UserAuth> getAllActiveUsers() {
        List<UserAuth> result = userRepository.findAll()
                .stream()
                .filter(user -> user.getStatus() == Status.ACTIVE)
                .map(ilcarro.model.auth.User::toUserAuthDto)
                .collect(Collectors.toList());
        log.info("IN getAllActiveUsers - {} users found", result.size());
        return result;
    }

    @Override
    public List<UserAuth> getAllDeletedUsers() {
        List<UserAuth> result = userRepository.findAll()
                .stream()
                .filter(user -> user.getStatus() == Status.DELETED)
                .map(ilcarro.model.auth.User::toUserAuthDto)
                .collect(Collectors.toList());
        log.info("IN getAllDeletedUsers - {} users found", result.size());
        return result;
    }

    @Override
    public List<UserAuth> getAllAdminUsers() {
        Role role = roleRepository.findByName("ROLE_ADMIN");
        List<UserAuth> result = userRepository.findAll()
                .stream()
                .filter(user -> user.getRoles().contains(role))
                .map(ilcarro.model.auth.User::toUserAuthDto)
                .collect(Collectors.toList());
        log.info("IN getAllAdminUsers - {} users found", result.size());
        return result;
    }

    @Override
    public UserAuth giveRoleAdmin(String username) {
        List<Role> userRoles = new ArrayList<>(roleRepository.findAll());

        User user = userRepository.findByUsername(username);
        user.setRoles(userRoles);

        log.info("IN user - user with username: {} successfully added role admin", username);
        userRepository.save(user);
        return user.toUserAuthDto();
    }

    @Override
    public Fuel uploadFuel(Fuel fuel) throws ActionDeniedException {
        if (fuelRepository.findByFuel(fuel.getFuel()) != null){
            throw  new ActionDeniedException("Fuel " + fuel.getFuel() + "already exist");
        } else {
            log.warn("IN uploadFuel - fuel {} successfully uploaded", fuel);
            return fuelRepository.save(new FuelEntity(fuel)).toFuel();
        }
    }

    @Override
    public void deleteFuel(String fuel) throws NotFoundException {
        FuelEntity fuelEntity = fuelRepository.findByFuel(fuel);
        if ( fuelEntity == null){
            log.warn("IN getFuelByFuelName - no fuel found by: {}", fuel);
            throw  new NotFoundException("Fuel " + fuel + "not found");
        } else {
            fuelRepository.delete(fuelEntity);
        }
    }

    @Override
    public Manufacturer uploadManufacturer(Manufacturer manufacturer) throws ActionDeniedException {
        if (manufacturerRepository.findByManufacturer(manufacturer.getManufacturer()) != null){
            throw  new ActionDeniedException("Manufacturer " + manufacturer.getManufacturer() + "already exist");
        }else {
            log.warn("IN uploadManufacturer - manufacturer {} successfully uploaded", manufacturer);
            return manufacturerRepository.save(new ManufacturerEntity()).toManufacturer();
        }
    }

    @Override
    public void deleteManufacturer(String manufacturer) throws NotFoundException {
        ManufacturerEntity manufacturerEntity = manufacturerRepository.findByManufacturer(manufacturer);
        if (manufacturerEntity == null){
            log.warn("IN deleteManufacturer - no manufacturer found by: {}", manufacturer);
            throw  new NotFoundException("Manufacturer " + manufacturer + "already exist");
        }else {
            manufacturerRepository.delete(manufacturerEntity);
        }
    }

    @Override
    public Model uploadModel(Model model) {
        return null;
    }

    @Override
    public void deleteModel(String model) {

    }

    @Override
    public Transmission uploadTransmission(Transmission transmission) {
        return null;
    }

    @Override
    public void deleteTransmission(String transmission) {

    }

    @Override
    public WheelDrive uploadWheelDrive(WheelDrive wheelDrive) {
        return null;
    }

    @Override
    public void deleteWheelDrive(String wheelDrive) {

    }
}

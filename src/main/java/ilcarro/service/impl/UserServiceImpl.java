package ilcarro.service.impl;

import ilcarro.exeptions.ActionDeniedException;
import ilcarro.model.auth.Role;
import ilcarro.model.auth.User;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ilcarro.dto.user.UserAuth;
import ilcarro.dto.user.UserBase;
import ilcarro.dto.user.UserDto;
import ilcarro.model.app.user.UserEntity;
import ilcarro.dto.Status;
import ilcarro.repository.app.UserEntityRepository;
import ilcarro.repository.auth.RoleRepository;
import ilcarro.repository.auth.UserRepository;
import ilcarro.service.UserService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
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
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

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
    public User findByUsername(String username) throws NotFoundException {
        ilcarro.model.auth.User user = userRepository.findByUsername(username);
        if (user == null) {
            log.warn("IN findByUsername - no user found by username: {}", username);
            throw  new NotFoundException("User with username: " + username + "not found");
        }
        log.info("IN findByUsername - user: {} found by username: {}", user, username);
        return user;
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
    public UserDto addRoleAdmin() {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user) {
        return null;
    }

    @Override
    public String changePassword(String password) {
        return null;
    }
}

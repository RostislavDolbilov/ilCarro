package ilcarro.service.impl;

import ilcarro.exeptions.ActionDeniedException;
import ilcarro.model.auth.Role;
import ilcarro.model.auth.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ilcarro.dto.UserAuthDto;
import ilcarro.dto.UserBaseDto;
import ilcarro.dto.UserDto;
import ilcarro.model.app.UserEntity;
import ilcarro.dto.Status;
import ilcarro.repository.app.UserEntityRepository;
import ilcarro.repository.auth.RoleRepository;
import ilcarro.repository.auth.UserRepository;
import ilcarro.service.UserService;

import java.time.LocalDate;
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
    public UserDto registration(UserBaseDto user) throws ActionDeniedException {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        UserEntity userEntity = new UserEntity(user);
        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRoles(userRoles);
        newUser.setStatus(user.getStatus());
        newUser.setUpdated(LocalDate.now());
        newUser.setCreated(LocalDate.now());
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
    public UserDto findByUsernameMail(String email) {
        return userEntityRepository.findByUsernameMail(email).toUserDto();
    }


    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public UserDto deleteUser(String username) {
        UserEntity user = userEntityRepository.findByUsernameMail(username);
        user.setStatus(Status.DELETED);

        User userAuth = userRepository.findByUsername(username);
        userAuth.setStatus(Status.DELETED);

        log.info("IN delete - user with id: {} successfully deleted", username);

        userRepository.save(userAuth);
        return userEntityRepository.save(user).toUserDto();
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}",id,  result);
        return result;
    }


    @Override
    public List<UserAuthDto> getAllRegisteredUsers() {
        List<UserAuthDto> result = userRepository.findAll()
                .stream()
                .map(User::toUserAuthDto)
                .collect(Collectors.toList());
        log.info("IN getAllAuthUsers - {} users found", result.size());
        return result;
    }

    @Override
    public List<UserAuthDto> getAllActiveUsers(Status status) {
        return null;
    }

    @Override
    public List<UserAuthDto> getAllDeletedUsers(Status status) {
        return null;
    }

    @Override
    public List<UserAuthDto> getAllAdminUsers(Status status) {
        return null;
    }

    @Override
    public List<UserAuthDto> getAllUserUsers() {
        return null;
    }

    @Override
    public UserDto addRoleAdmin() {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user) {
        return null;
    }
}

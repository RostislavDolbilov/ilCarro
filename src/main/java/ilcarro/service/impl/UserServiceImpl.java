package ilcarro.service.impl;

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
    public String changePassword(String password) {
        return null;
    }
}

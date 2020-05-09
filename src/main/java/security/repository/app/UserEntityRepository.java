package security.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import security.model.app.UserEntity;

/*
 * @author Rostislav Dolbilov
 * Repository for {@link UserEntity}
 */

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsernameMail(String email);
    void deleteByUsernameMail(String username);
}

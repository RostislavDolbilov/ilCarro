package ilcarro.repository.app;

import ilcarro.model.app.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @author Rostislav Dolbilov
 * Repository for {@link UserEntity}
 */

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsernameMail(String email);
    void deleteByUsernameMail(String username);
}

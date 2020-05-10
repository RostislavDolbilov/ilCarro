package ilcarro.repository.auth;

import ilcarro.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @author Rostislav Dolbilov
 * Repository for {@link User}
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
    void deleteByUsername(String username);
}

package security.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import security.dto.Status;
import security.dto.UserAuthDto;
import security.model.auth.User;
import java.util.List;

/*
 * @author Rostislav Dolbilov
 * Repository for {@link User}
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
    void deleteByUsername(String username);
}

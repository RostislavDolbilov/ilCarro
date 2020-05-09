package security.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import security.model.auth.Role;

/*
 * @author Rostislav Dolbilov
 * Repository for {@link Role}
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

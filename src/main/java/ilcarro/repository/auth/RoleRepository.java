package ilcarro.repository.auth;

import ilcarro.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @author Rostislav Dolbilov
 * Repository for {@link Role}
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

package maksym.kruhovykh.wekingsmonolith.auth.repository;

import maksym.kruhovykh.wekingsmonolith.auth.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
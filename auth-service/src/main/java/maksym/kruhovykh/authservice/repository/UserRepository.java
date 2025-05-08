package maksym.kruhovykh.authservice.repository;

import maksym.kruhovykh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
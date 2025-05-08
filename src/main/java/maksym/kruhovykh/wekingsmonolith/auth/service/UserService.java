package maksym.kruhovykh.wekingsmonolith.auth.service;

import maksym.kruhovykh.wekingsmonolith.auth.model.dto.UserDto;
import maksym.kruhovykh.wekingsmonolith.auth.repository.entity.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    void saveUser(User user);

    List<UserDto> getAllUsers();
}

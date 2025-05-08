package maksym.kruhovykh.wekingsmonolith.mvp.service;

import maksym.kruhovykh.wekingsmonolith.mvp.model.dto.UserDto;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    void saveUser(User user);

    List<UserDto> getAllUsers();
}

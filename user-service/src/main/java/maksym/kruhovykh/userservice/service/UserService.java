package maksym.kruhovykh.userservice.service;

import maksym.kruhovykh.model.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
}

package maksym.kruhovykh.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import maksym.kruhovykh.model.dto.UserDto;
import maksym.kruhovykh.userservice.mapper.UserMapper;
import maksym.kruhovykh.userservice.repository.UserRepository;
import maksym.kruhovykh.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        return UserMapper.INSTANCE.usersToUserDtos(userRepository.findAll());
    }
}

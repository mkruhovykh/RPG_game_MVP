package maksym.kruhovykh.wekingsmonolith.auth.service.impl;

import lombok.RequiredArgsConstructor;
import maksym.kruhovykh.wekingsmonolith.auth.model.dto.UserDto;
import maksym.kruhovykh.wekingsmonolith.auth.repository.UserRepository;
import maksym.kruhovykh.wekingsmonolith.auth.repository.entity.User;
import maksym.kruhovykh.wekingsmonolith.auth.service.CharacterService;
import maksym.kruhovykh.wekingsmonolith.auth.service.UserService;
import maksym.kruhovykh.wekingsmonolith.auth.service.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CharacterService characterService;

    @Transactional
    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);
        characterService.createCharacterForUser(save);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserMapper.INSTANCE.usersToUserDtos(userRepository.findAll());
    }
}

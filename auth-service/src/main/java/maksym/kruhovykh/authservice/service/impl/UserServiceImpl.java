package maksym.kruhovykh.authservice.service.impl;

import lombok.RequiredArgsConstructor;
import maksym.kruhovykh.authservice.repository.UserRepository;
import maksym.kruhovykh.authservice.service.UserService;
import maksym.kruhovykh.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);
//        characterService.createCharacterForUser(save);
    }

}

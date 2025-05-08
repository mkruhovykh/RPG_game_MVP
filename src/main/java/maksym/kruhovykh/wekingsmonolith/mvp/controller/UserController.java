package maksym.kruhovykh.wekingsmonolith.mvp.controller;

import lombok.RequiredArgsConstructor;
import maksym.kruhovykh.wekingsmonolith.mvp.model.dto.UserDto;
import maksym.kruhovykh.wekingsmonolith.mvp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> response = userService.getAllUsers();
        return ResponseEntity.ok(response);
    }
}

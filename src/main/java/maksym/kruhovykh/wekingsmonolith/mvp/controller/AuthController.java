package maksym.kruhovykh.wekingsmonolith.mvp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maksym.kruhovykh.wekingsmonolith.mvp.config.JwtUtil;
import maksym.kruhovykh.wekingsmonolith.mvp.model.request.AuthRequest;
import maksym.kruhovykh.wekingsmonolith.mvp.model.response.AuthResponse;
import maksym.kruhovykh.wekingsmonolith.mvp.model.request.RegisterRequest;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.User;
import maksym.kruhovykh.wekingsmonolith.mvp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;
    private final UserService userService;

    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(registerRequest.getPassword());

//        newUser.setRoles(Set.of(new Role("User")));

        userService.saveUser(newUser);

        return ResponseEntity.ok("User registered successfully.: Username: " + newUser.getUsername());
    }
}

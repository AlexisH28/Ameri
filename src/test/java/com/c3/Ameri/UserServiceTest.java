package com.c3.Ameri;

import com.c3.Ameri.config.JwtUtil;
import com.c3.Ameri.dto.Request.AuthenticationRequest;
import com.c3.Ameri.dto.Request.RegisterRequest;
import com.c3.Ameri.entity.User;
import com.c3.Ameri.repository.UserRepository;
import com.c3.Ameri.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserService userService;

    @Test
    public void testRegisterUser_Success() {
        RegisterRequest request = new RegisterRequest();
        request.setFullName("Alexis Hernandez");
        request.setUsername("alex_her");
        request.setEmail("alexismar@gmail.com");
        request.setPassword("Password123#");

        when(userRepository.existsByUsername("alex_her")).thenReturn(false);
        when(userRepository.existsByEmail("alexismar@gmail.com")).thenReturn(false);
        when(passwordEncoder.encode("Password123#")).thenReturn("encoded_password");

        String result = userService.registerUser(request);

        assertEquals("User registered successfully.", result);
    }

    @Test
    public void testRegisterUser_EmailExists() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("alex_her");
        request.setEmail("alexismar@gmail.com");

        when(userRepository.existsByEmail("alexismar@gmail.com")).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                userService.registerUser(request));

        assertEquals("Email is already registered.", exception.getMessage());
    }

    @Test
    public void testAuthenticateUser_Success() {
        AuthenticationRequest request = new AuthenticationRequest();
        request.setUsernameOrEmail("alex_her");
        request.setPassword("Password123#");

        User user = new User();
        user.setUsername("alex_her");
        user.setPassword("encoded_password");

        when(userRepository.findByUsername("alex_her")).thenReturn(java.util.Optional.of(user));
        when(passwordEncoder.matches("Password123#", "encoded_password")).thenReturn(true);
        when(jwtUtil.generateToken("alex_her")).thenReturn("jwt_token");

        String result = userService.authenticateUser(request).getToken();

        assertEquals("jwt_token", result);
    }
}

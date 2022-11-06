package com.example.main.controller.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.main.DTO.request.log.LoginRequest;
import com.example.main.DTO.response.log.LoginResponse;
import com.example.main.DTO.response.workspace.MessagesResponse;
import com.example.main.config.security.JWTUtils;
import com.example.main.config.security.UserDetailsImplementation;
import com.example.main.entity.log.Login;
import com.example.main.entity.log.Role;
import com.example.main.repository.log.LoginRepository;
import com.example.main.repository.log.RoleRepository;
import com.example.main.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JWTUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body("Logged in successfully");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody LoginRequest loginRequest) {
        if (loginRepository.existsByUsername(loginRequest.getUsername())) {
            return ResponseEntity.badRequest().body(ResponseEntity.ok("Error: Username is already taken!"));
        }

        if (loginRepository.existsByEmail(loginRequest.getEmail())) {
            return ResponseEntity.badRequest().body(ResponseEntity.ok("Error: Email is already in use!"));
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Create new user's account
        Login login = new Login();
        login.setUsername(loginRequest.getUsername());
        login.setEmail(loginRequest.getEmail());
        login.setPassword(passwordEncoder.encode(loginRequest.getPassword()));
        login.setRoles(loginRequest.getRoles());
        loginRepository.save(login);

        return (ResponseEntity<String>) ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(ResponseEntity.ok("You've been signed out!"));
    }
}
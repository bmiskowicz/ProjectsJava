package com.example.main.controller;

import com.example.main.DTO.request.log.AuthRequest;
import com.example.main.service.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> getToken(@Valid @RequestBody AuthRequest loginRequest){
        return ResponseEntity.ok(authService.getAuthToken(loginRequest));
    }

}
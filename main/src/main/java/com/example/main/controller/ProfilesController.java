package com.example.main.controller;
import com.example.main.DTO.request.log.LoginRequest;
import com.example.main.DTO.request.ProfileRequest;
import com.example.main.DTO.response.ProfileResponse;
import com.example.main.entity.log.Login;
import com.example.main.repository.log.LoginRepository;
import com.example.main.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfilesController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("")
    public List<ProfileResponse> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public ProfileResponse getProfile(@PathVariable Long id){
        return profileService.getProfile(id);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateProfile(ProfileRequest profileRequest){
        ProfileResponse profileResponse = profileService.updateProfile(profileRequest);
        return ResponseEntity.ok(profileResponse);
    }

    /*TODO: delete it and add creating projects in SignUp function  */
    @PostMapping("/post")
    public ResponseEntity<?> postProfile(LoginRequest loginRequest){
        Login login = loginRepository.findById(1L).get();
        ProfileResponse profileResponse = profileService.createProfile(login);
        return ResponseEntity.ok(profileResponse);
    }
}

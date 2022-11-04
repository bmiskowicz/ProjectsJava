package com.example.main.controller;
import com.example.main.DTO.request.user.ProfileRequest;
import com.example.main.DTO.response.user.ProfileResponse;
import com.example.main.service.user.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfilesController {

    @Autowired
    private ProfileService profileService;

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

}

package com.example.main.service;


import com.example.main.DTO.request.ProfileRequest;
import com.example.main.DTO.response.ProfileResponse;
import com.example.main.entity.log.Login;
import com.example.main.entity.Profile;
import com.example.main.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<ProfileResponse> getAllProfiles() {
        return profileRepository.findAll().stream()
                .map(ProfileResponse::new)
                .collect(Collectors.toList());
    }

    public ProfileResponse getProfile(Long id){
        Profile profile = null;
        if(profileRepository.existsById(id)) {
            profile = profileRepository.findById(id).get();
        }
        return new ProfileResponse(profile);

    }

    public ProfileResponse createProfile(Login login){
        Profile profile = Profile.builder()
                .profileId(login.getLoginId())
                .login(login)
                .build();
        profileRepository.save(profile);
        return new ProfileResponse(profile);
    }

    public ProfileResponse updateProfile(ProfileRequest profileRequest){
        Profile profile = null;
        if(profileRepository.existsById(profileRequest.getProfileId())) {
            profile = profileRepository.findById(profileRequest.getProfileId()).get();
            profile.setIcon(profileRequest.getIcon());
            profileRepository.save(profile);
        }
        return new ProfileResponse(profile);
    }

    public void deleteProfile(Long id){
        if(profileRepository.existsById(id)) {
            Profile profile = profileRepository.findById(id).get();
            profileRepository.delete(profile);
        }
    }
}

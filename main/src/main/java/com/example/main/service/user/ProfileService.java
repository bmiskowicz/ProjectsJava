package com.example.main.service.user;


import com.example.main.DTO.request.user.ProfileRequest;
import com.example.main.DTO.response.user.ProfileResponse;
import com.example.main.entity.log.Login;
import com.example.main.entity.Profile;
import com.example.main.repository.user.ProfileRepository;
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
        Profile profile = new Profile(login.getId(), login.getUsername());
        return new ProfileResponse(profile);
    }

    public ProfileResponse updateProfile(ProfileRequest profileRequest){
        Profile profile = null;
        if(profileRepository.existsById(profileRequest.getId())) {
            profile = profileRepository.findById(profileRequest.getId()).get();
            profile.setIcon(profileRequest.getIcon());
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

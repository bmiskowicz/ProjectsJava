package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.ProfileIssuesRequest;
import com.example.main.DTO.response.workspace.ProfileIssuesResponse;
import com.example.main.entity.workspace.ProfileIssues;
import com.example.main.repository.workspace.IssueRepository;
import com.example.main.repository.workspace.ProfileIssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileIssuesService {

    @Autowired
    private ProfileIssuesRepository profileIssuesRepository;

    @Autowired
    private IssueRepository issueRepository;

    public List<ProfileIssuesResponse> getAllProfileIssues() {
        return profileIssuesRepository.findAll().stream()
                .map(ProfileIssuesResponse::new)
                .collect(Collectors.toList());
    }

    public ProfileIssuesResponse getProfileIssues(Long id){
        ProfileIssues profileIssues = null;
        if(profileIssuesRepository.existsById(id)) {
            profileIssues = profileIssuesRepository.findById(id).get();
        }
        return new ProfileIssuesResponse(profileIssues);
    }

    public ProfileIssuesResponse createProfileIssues(ProfileIssuesRequest profileIssuesRequest){
        ProfileIssues profileIssues = ProfileIssues.builder()
                .piId(profileIssuesRequest.getPiId())
                .profile(profileIssuesRequest.getProfile())
                .issue(profileIssuesRequest.getIssue())
                .build();
        profileIssuesRepository.save(profileIssues);
        return new ProfileIssuesResponse(profileIssues);
    }


    public void deleteProfileIssues(Long id){
        if(profileIssuesRepository.existsById(id)) {
            ProfileIssues profileIssues = profileIssuesRepository.findById(id).get();
            profileIssuesRepository.delete(profileIssues);
        }
    }
}

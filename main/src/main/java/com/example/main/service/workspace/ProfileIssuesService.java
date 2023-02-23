package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.ProfileIssuesRequest;
import com.example.main.DTO.response.workspace.ProfileIssuesResponse;
import com.example.main.entity.Profile;
import com.example.main.entity.log.Login;
import com.example.main.entity.workspace.Issue;
import com.example.main.entity.workspace.ProfileIssues;
import com.example.main.repository.ProfileRepository;
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
    @Autowired
    private ProfileRepository profileRepository;

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
        Profile profile = profileRepository.findById(profileIssuesRequest.getProfileId()).get();
        Issue issue = issueRepository.findById(profileIssuesRequest.getIssueId()).get();
        ProfileIssues profileIssues = ProfileIssues.builder()
                .profile(profile)
                .issue(issue)
                .build();
        profileIssuesRepository.save(profileIssues);
        return new ProfileIssuesResponse(profileIssues);
    }

    public void deleteProfileIssuesByIssue(Issue issue){
        if(profileIssuesRepository.existsByIssue(issue)) {
            List<ProfileIssues> profileIssues = profileIssuesRepository.findAllByIssue(issue);
            profileIssuesRepository.deleteAll(profileIssues);
        }
    }
    public void deleteProfileIssues(ProfileIssuesRequest profileIssuesRequest){
        Profile profile = profileRepository.findById(profileIssuesRequest.getProfileId()).get();
        Issue issue = issueRepository.findById(profileIssuesRequest.getIssueId()).get();
        if(profileIssuesRepository.existsByProfileAndIssue(profile, issue)) {
            ProfileIssues profileIssues = profileIssuesRepository.findByProfileAndIssue(profile, issue).get();
            profileIssuesRepository.delete(profileIssues);
        }
    }
}

package com.example.main.controller.workspace;

import com.example.main.DTO.request.workspace.ProfileIssuesRequest;
import com.example.main.DTO.response.workspace.ProfileIssuesResponse;
import com.example.main.entity.workspace.ProfileIssues;
import com.example.main.service.workspace.ProfileIssuesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/profileissues")
public class ProfileIssuesController {
    @Autowired
    private ProfileIssuesService profileIssueService;


    @GetMapping("")
    public List<ProfileIssuesResponse> getAllProfileIssues() {
        return profileIssueService.getAllProfileIssues();
    }

    @GetMapping("/{id}")
    public ProfileIssuesResponse getProfileIssue(@PathVariable Long id){
        return profileIssueService.getProfileIssues(id);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postProfileIssue(ProfileIssuesRequest profileIssueRequest){
        ProfileIssuesResponse profileIssueResponse = profileIssueService.createProfileIssues(profileIssueRequest);
        return ResponseEntity.ok(profileIssueResponse);
    }
}

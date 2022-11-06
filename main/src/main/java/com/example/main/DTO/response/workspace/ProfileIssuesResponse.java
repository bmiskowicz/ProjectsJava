package com.example.main.DTO.response.workspace;

import com.example.main.entity.Profile;
import com.example.main.entity.workspace.Issue;
import com.example.main.entity.workspace.ProfileIssues;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ProfileIssuesResponse {

    @NotNull
    private Long piId;
    private Profile profile;
    private Issue issue;

    public ProfileIssuesResponse(ProfileIssues profileIssues) {
        this.piId = profileIssues.getPiId();
        this.profile = profileIssues.getProfile();
        this.issue = profileIssues.getIssue();
    }
}

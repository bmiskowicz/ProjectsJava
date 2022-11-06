package com.example.main.DTO.response.workspace;

import com.example.main.entity.workspace.Issue;
import com.example.main.entity.workspace.ProfileIssues;
import com.example.main.entity.workspace.States;
import com.example.main.util.IssueState;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Set;

@Setter
@Getter
public class IssueResponse {

    @NotNull
    private Long issueId;
    private Set<ProfileIssues> profileIssuesSet;
    private Long workspaceId;
    private String issueName;
    private ZonedDateTime creationDate;
    private ZonedDateTime deadline;
    private IssueState state;
    private Set<States> states;

    public IssueResponse(Issue issue) {
        this.issueId = issue.getIssueId();
        this.profileIssuesSet = issue.getProfileIssuesSet();
        this.workspaceId = issue.getWorkspaceId();
        this.issueName = issue.getIssueName();
        this.creationDate = issue.getCreationDate();
        this.deadline = issue.getDeadline();
        this.state = issue.getState();
        this.states = issue.getStatesSet();
    }
}

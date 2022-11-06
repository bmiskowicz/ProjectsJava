package com.example.main.DTO.request.workspace;

import com.example.main.entity.workspace.ProfileIssues;
import com.example.main.entity.workspace.States;
import com.example.main.util.IssueState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IssueRequest {

    @NotNull
    private Long issueId;
    private Set<ProfileIssues> profileIssuesSet;
    private Long workspaceId;
    private String issueName;
    private ZonedDateTime creationDate;
    private ZonedDateTime deadline;
    private IssueState state;
    private Set<States> states;
}

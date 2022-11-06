package com.example.main.DTO.request.workspace;

import com.example.main.entity.Profile;
import com.example.main.entity.workspace.Issue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileIssuesRequest {
    @NotNull
    private Long piId;
    private Profile profile;
    private Issue issue;
}

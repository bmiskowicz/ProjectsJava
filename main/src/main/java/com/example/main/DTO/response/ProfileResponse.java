package com.example.main.DTO.response;

import com.example.main.entity.Profile;
import com.example.main.entity.log.Login;
import com.example.main.entity.workspace.ProfileIssues;
import com.example.main.entity.workspace.WorkspaceMembers;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Set;

@Setter
@Getter
public class ProfileResponse {
    @NotNull
    private Long profileId;
    private Login login;

    @Nullable
    private Byte icon=null;
    private ZonedDateTime creationDate;
    private Set<WorkspaceMembers> workspaceMembersSet;
    private Set<ProfileIssues> profileIssuesSet;

    public ProfileResponse(Profile profile) {
        this.profileId = profile.getProfileId();
        this.login = profile.getLogin();
        try{
            this.icon = profile.getIcon();
        }catch (NullPointerException e){};
        this.creationDate = profile.getCreationDate();
        this.workspaceMembersSet = profile.getWorkspaceMembersSet();
        this.profileIssuesSet = profile.getProfileIssuesSet();
    }
}

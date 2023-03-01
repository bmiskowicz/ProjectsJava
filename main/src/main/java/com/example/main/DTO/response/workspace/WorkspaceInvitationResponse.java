package com.example.main.DTO.response.workspace;

import com.example.main.entity.Profile;
import com.example.main.entity.workspace.Workspace;
import com.example.main.entity.workspace.WorkspaceInvitation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class WorkspaceInvitationResponse {
    @NotNull
    private Long workspaceInvitationId;
    private Profile profile;
    private Workspace workspace;

    public WorkspaceInvitationResponse(WorkspaceInvitation workspaceInvitation) {
        this.workspaceInvitationId = workspaceInvitation.getWorkspaceInvitationId();
        this.profile = workspaceInvitation.getProfile();
        this.workspace = workspaceInvitation.getWorkspace();
    }
}

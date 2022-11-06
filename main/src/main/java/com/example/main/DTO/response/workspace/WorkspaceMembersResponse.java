package com.example.main.DTO.response.workspace;

import com.example.main.entity.Profile;
import com.example.main.entity.workspace.Workspace;
import com.example.main.entity.workspace.WorkspaceMembers;
import com.example.main.util.WorkspaceRole;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class WorkspaceMembersResponse {
    @NotNull
    private Long workspaceMembersId;
    private Profile profile;
    private Workspace workspace;
    private WorkspaceRole role;

    public WorkspaceMembersResponse(WorkspaceMembers workspaceMembers) {
        this.workspaceMembersId = workspaceMembers.getWorkspaceMembersId();
        this.profile = workspaceMembers.getProfile();
        this.workspace = workspaceMembers.getWorkspace();
        this.role = workspaceMembers.getRole();
    }
}

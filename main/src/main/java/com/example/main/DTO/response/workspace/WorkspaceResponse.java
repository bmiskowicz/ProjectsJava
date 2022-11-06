package com.example.main.DTO.response.workspace;

import com.example.main.entity.workspace.Workspace;
import com.example.main.entity.workspace.WorkspaceMembers;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter
@Getter
public class WorkspaceResponse {
    @NotNull
    private Long workspaceId;
    private String workspaceName;
    private String workspaceDescription;
    private Set<WorkspaceMembers> workspaceMembersSet;

    public WorkspaceResponse(Workspace workspace) {
        this.workspaceId = workspace.getWorkspaceId();
        this.workspaceName = workspace.getWorkspaceName();
        this.workspaceDescription = workspace.getWorkspaceDescription();
        this.workspaceMembersSet = workspace.getWorkspaceMembersSet();
    }
}

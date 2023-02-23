package com.example.main.DTO.request.workspace;

import com.example.main.entity.Profile;
import com.example.main.entity.workspace.Workspace;
import com.example.main.util.WorkspaceRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceMembersRequest {
    @NotNull
    private Long workspaceMembersId;
    private Long profileId;
    private Long workspaceId;
    private WorkspaceRole role;
}

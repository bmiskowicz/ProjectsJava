package com.example.main.DTO.request.workspace;

import com.example.main.entity.workspace.WorkspaceMembers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceRequest {
    @NotNull
    private Long workspaceId;
    private String workspaceName;
    private String workspaceDescription;
    private Set<WorkspaceMembers> workspaceMembersSet;

}

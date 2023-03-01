package com.example.main.DTO.request.workspace;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceInvitationRequest {
    @NotNull
    private Long workspaceInvitationId;
    private Long profileId;
    private Long workspaceId;
    private String username;
}

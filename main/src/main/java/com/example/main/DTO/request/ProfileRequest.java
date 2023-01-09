package com.example.main.DTO.request;

import com.example.main.entity.log.Login;
import com.example.main.entity.workspace.ProfileIssues;
import com.example.main.entity.workspace.WorkspaceMembers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest {
    @NotNull
    private Long profileId;
    @NotNull
    private Login login;
    private byte icon;
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;
}
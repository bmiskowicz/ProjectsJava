package com.example.main.entity.workspace;


import com.example.main.entity.Profile;
import com.example.main.util.WorkspaceRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "workspaces", name="workspaceMembers")
public class WorkspaceMembers {

    @Id
    @Column(unique = true, nullable = false, name = "workspaceMembersId")
    private Long workspaceMembersId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "profileId")
    private Profile profile;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;

    @Column(nullable = false)
    private WorkspaceRole role;
}
package com.example.main.entity.workspace;


import com.example.main.entity.Profile;
import com.example.main.util.WorkspaceRole;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "workspaceMembersId")
    private Long workspaceMembersId;

    @ManyToOne
    @JoinColumn(name = "profileId")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;

    @Column(nullable = false)
    private WorkspaceRole role;
}
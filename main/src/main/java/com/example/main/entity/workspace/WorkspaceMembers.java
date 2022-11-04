package com.example.main.entity.workspace;


import com.example.main.entity.Profile;
import com.example.main.util.WorkspaceRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
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
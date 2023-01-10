package com.example.main.entity.workspace;


import com.example.main.entity.Profile;
import com.example.main.util.WorkspaceRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "workspaces", name="workspaceMembers")
@Entity
public class WorkspaceMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto_gen4")
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
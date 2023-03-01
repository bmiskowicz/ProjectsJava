package com.example.main.entity.workspace;

import com.example.main.entity.Profile;
import com.example.main.util.WorkspaceRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "workspaces", name="workspaceInvitations")
@Entity
public class WorkspaceInvitation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, name = "workspaceInvitationId")
    private Long workspaceInvitationId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "profileId")
    private Profile profile;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;
}

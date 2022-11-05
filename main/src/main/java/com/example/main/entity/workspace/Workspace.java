package com.example.main.entity.workspace;

import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "workspaces", name="workspace")
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "workspaceId")
    private Long workspaceId;

    @Column(unique = true, nullable = false)
    private String workspaceName;

    @Column()
    @Nullable
    private String workspaceDescription;

    @OneToMany(mappedBy = "workspace")
    @Builder.Default
    private Set<WorkspaceMembers> workspaceMembersSet = new HashSet<>();

}
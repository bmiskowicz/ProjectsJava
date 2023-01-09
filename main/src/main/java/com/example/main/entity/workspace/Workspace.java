package com.example.main.entity.workspace;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "workspaces", name="workspace")
@Entity
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto_gen3")
    @Column(unique = true, nullable = false, name = "workspaceId")
    private Long workspaceId;

    @Column(unique = true, nullable = false)
    private String workspaceName;

    @Column()
    @Nullable
    private String workspaceDescription;

    @JsonManagedReference
    @OneToMany(mappedBy = "workspace")
    @Builder.Default
    private Set<WorkspaceMembers> workspaceMembersSet = new HashSet<>();

}
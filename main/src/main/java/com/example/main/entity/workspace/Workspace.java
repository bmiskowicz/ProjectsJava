package com.example.main.entity.workspace;

import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
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
    private Set<WorkspaceMembers> workspaceMembersSet;

    public Workspace(Long workspaceId, String workspaceName, String workspaceDescription) {
        this.workspaceId = workspaceId;
        this.workspaceName = workspaceName;
        this.workspaceDescription = workspaceDescription;
    }

    public Long getWorkspaceId() {
        return workspaceId;
    }

    public String getWorkspaceName() {
        return workspaceName;
    }

    public void setWorkspaceName(String workspaceName) {
        this.workspaceName = workspaceName;
    }

    public String getWorkspaceDescription() {
        return workspaceDescription;
    }

    public void setWorkspaceDescription(String workspaceDescription) {
        this.workspaceDescription = workspaceDescription;
    }

    public Set<WorkspaceMembers> getWorkspaceMembersSet() {
        return workspaceMembersSet;
    }

    public void setWorkspaceMembersSet(Set<WorkspaceMembers> workspaceMembersSet) {
        this.workspaceMembersSet = workspaceMembersSet;
    }
}
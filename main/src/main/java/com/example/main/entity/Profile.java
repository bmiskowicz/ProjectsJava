package com.example.main.entity;

import com.example.main.entity.workspace.WorkspaceMembers;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "profiles", name="profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "profileId")
    @JoinColumn(table="login", nullable = false)
    private Long profileId;

    @Column(unique = true, nullable = false)
    private String username;


    @Column()
    @Nullable
    private Byte icon=null;

    @Column(nullable = false)
    private ZonedDateTime creationDate = ZonedDateTime.now();


    @OneToMany(mappedBy = "profile")
    private Set<WorkspaceMembers> workspaceMembersSet;

    public Profile(Long profileId, String username) {
        this.profileId = profileId;
        this.username = username;
    }

    public Long getProfileId() {
        return profileId;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte getIcon() {
        return icon;
    }

    public void setIcon(byte icon) {
        this.icon = icon;
    }

    public Set<WorkspaceMembers> getWorkspaceMembersSet() {
        return workspaceMembersSet;
    }

    public void setWorkspaceMembersSet(Set<WorkspaceMembers> workspaceMembersSet) {
        this.workspaceMembersSet = workspaceMembersSet;
    }
}

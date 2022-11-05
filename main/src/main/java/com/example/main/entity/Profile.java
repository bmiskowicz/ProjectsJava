package com.example.main.entity;

import com.example.main.entity.log.Login;
import com.example.main.entity.workspace.ProfileIssues;
import com.example.main.entity.workspace.WorkspaceMembers;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "profiles", name="profile")
public class Profile {

    @Id
    @Column(unique = true, nullable = false, name = "profileId")
    private Long profileId;


    @OneToOne
    @JoinColumn(name="loginId", nullable = false)
    private Login login;

    @Column()
    @Nullable
    @Builder.Default
    private Byte icon=null;

    @Column(nullable = false)
    @Builder.Default
    private ZonedDateTime creationDate = ZonedDateTime.now();

    @OneToMany(mappedBy = "profile")
    @Builder.Default
    private Set<WorkspaceMembers> workspaceMembersSet = new HashSet<>();

    @OneToMany(mappedBy = "profile")
    @Builder.Default
    private Set<ProfileIssues> profileIssuesSet = new HashSet<>();

}

package com.example.main.entity.workspace;

import com.example.main.util.IssueState;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "workspaces", name="issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, name = "issue_id")
    private Long issueId;

    @Column(unique = true, nullable = false)
    private String issueName;

    @JsonManagedReference
    @OneToMany(mappedBy = "issue", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<ProfileIssues> profileIssuesSet = new HashSet<>();

    @Column(name = "workspaceId")
    @JoinColumn(table="workspace", nullable = false)
    private Long workspaceId;

    @Column(nullable = false)
    @Builder.Default
    private ZonedDateTime creationDate = ZonedDateTime.now();

    @Column()
    private ZonedDateTime deadline;

    @Column(nullable = false)
    @Builder.Default
    private IssueState state = IssueState.OPEN;


    @JsonManagedReference
    @OneToMany(mappedBy = "issue")
    @Builder.Default
    private Set<States> statesSet = new HashSet<>();
}
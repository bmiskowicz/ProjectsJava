package com.example.main.entity.workspace;

import com.example.main.util.IssueState;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "issue_id")
    private Long issueId;

    @OneToMany(mappedBy = "issue")
    @Builder.Default
    private Set<ProfileIssues> profileIssuesSet = new HashSet<>();

    @Column(name = "workspaceId")
    @JoinColumn(table="workspace", nullable = false)
    private Long workspaceId;

    @Column(unique = true, nullable = false)
    private String issueName;

    @Column(nullable = false)
    private ZonedDateTime creationDate = ZonedDateTime.now();

    @Column()
    private ZonedDateTime deadline;

    @Column(nullable = false)
    private IssueState state;


    @OneToMany(mappedBy = "issue")
    @Builder.Default
    private Set<States> states = new HashSet<>();
}
package com.example.main.entity.workspace;

import com.example.main.util.IssueState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "workspaces", name="issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "issue_id")
    private Long issueId;

    @Column(name = "profileId")
    @JoinColumn(table="profile", nullable = false)
    private Long profileId;

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
}
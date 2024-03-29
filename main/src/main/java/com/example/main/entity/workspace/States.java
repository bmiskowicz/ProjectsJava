package com.example.main.entity.workspace;

import com.example.main.util.IssueState;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "workspaces", name="states")
public class States {

    @Id
    @Column(unique = true, nullable = false, name = "stateId")
    private Long stateId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "issueId")
    private Issue issue;

    @Column(nullable = false)
    private IssueState state;

}

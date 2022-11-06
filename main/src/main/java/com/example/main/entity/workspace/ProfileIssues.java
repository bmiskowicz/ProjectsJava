package com.example.main.entity.workspace;

import com.example.main.entity.Profile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "workspaces", name="profilesissues")
public class ProfileIssues {

    @Id
    @Column(unique = true, nullable = false, name = "piId")
    private Long piId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "profileId")
    private Profile profile;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "issueId")
    private Issue issue;
}

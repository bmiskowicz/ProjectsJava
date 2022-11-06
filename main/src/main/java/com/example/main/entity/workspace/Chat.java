package com.example.main.entity.workspace;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(schema = "workspaces", name="chat")
public class Chat {

    @Id
    @Column(unique = true, nullable = false, name = "chatId")
    private Long chatId;

    @Column(name = "issueId")
    @JoinColumn(table="issue", nullable = false)
    private Long issueId;

    @JsonManagedReference
    @OneToMany(mappedBy = "chat")
    @Builder.Default
    private Set<Message> messageSet = new HashSet<>();

}

package com.example.main.entity.workspace;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "workspaces", name="chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "chatId")
    private Long chatId;

    @Column(name = "issueId")
    @JoinColumn(table="issue", nullable = false)
    private Long issueId;

    @OneToMany(mappedBy = "chat")
    private Set<Message> messageSet;

}

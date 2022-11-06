package com.example.main.entity.workspace;

import com.example.main.entity.Profile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "workspaces", name="message")
public class Message {
    @Id
    @Column(unique = true, nullable = false, name = "messageId")
    private Long messageId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @Column(name = "profileId")
    @JoinColumn(table="profile", nullable = false)
    private Long profileId;

    @Column(nullable = false)
    private ZonedDateTime creationDate = ZonedDateTime.now();

    @Column(nullable = false)
    private String content;
}

package com.example.main.entity.workspace;

import com.example.main.entity.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "workspaces", name="message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "messageId")
    private Long messageId;

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

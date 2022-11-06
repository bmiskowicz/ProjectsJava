package com.example.main.DTO.response.workspace;

import com.example.main.entity.workspace.Chat;
import com.example.main.entity.workspace.Message;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Setter
@Getter
public class MessagesResponse {
    @NotNull
    private Long messageId;
    private Chat chat;
    private Long profileId;
    private ZonedDateTime creationDate;
    private String content;

    public MessagesResponse(Message message) {
        this.messageId = message.getMessageId();
        this.chat = message.getChat();
        this.profileId = message.getProfileId();
        this.creationDate = message.getCreationDate();
        this.content = message.getContent();
    }
}

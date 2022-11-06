package com.example.main.DTO.response.workspace;

import com.example.main.entity.workspace.Chat;
import com.example.main.entity.workspace.Message;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter
@Getter
public class ChatResponse {
    @NotNull
    private Long chatId;
    private Long issueId;
    private Set<Message> messageSet;

    public ChatResponse(Chat chat) {
        this.chatId = chat.getChatId();
        this.issueId = chat.getIssueId();
        this.messageSet = chat.getMessageSet();
    }
}

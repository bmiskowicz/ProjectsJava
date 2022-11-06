package com.example.main.DTO.request.workspace;

import com.example.main.entity.workspace.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest {
    @NotNull
    private Long chatId;
    private Long issueId;
    private Set<Message> messageSet;
}

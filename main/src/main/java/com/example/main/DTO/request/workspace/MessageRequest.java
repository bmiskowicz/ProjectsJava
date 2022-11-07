package com.example.main.DTO.request.workspace;

import com.example.main.entity.workspace.Chat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    @NotNull
    private Long messageId;
    private Chat chat;
    private Long profileId;
    private ZonedDateTime creationDate;
    private String content;
}

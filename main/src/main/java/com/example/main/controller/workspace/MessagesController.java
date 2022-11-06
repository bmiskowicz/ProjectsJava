package com.example.main.controller.workspace;

import com.example.main.DTO.request.workspace.MessagesRequest;
import com.example.main.DTO.response.workspace.MessagesResponse;
import com.example.main.service.workspace.MessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    private MessageService messageService;


    @GetMapping("")
    public List<MessagesResponse> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public MessagesResponse getMessage(@PathVariable Long id){
        return messageService.getMessage(id);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateMessage(MessagesRequest messagesRequest){
        MessagesResponse messagesResponse = messageService.updateMessage(messagesRequest);
        return ResponseEntity.ok(messagesResponse);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postMessage(MessagesRequest messagesRequest){
        MessagesResponse messagesResponse = messageService.createMessage(messagesRequest);
        return ResponseEntity.ok(messagesResponse);
    }
}

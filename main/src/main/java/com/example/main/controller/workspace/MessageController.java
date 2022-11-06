package com.example.main.controller.workspace;

import com.example.main.DTO.request.workspace.MessageRequest;
import com.example.main.DTO.response.workspace.MessageResponse;
import com.example.main.service.workspace.MessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;


    @GetMapping("")
    public List<MessageResponse> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public MessageResponse getMessage(@PathVariable Long id){
        return messageService.getMessage(id);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateMessage(MessageRequest messageRequest){
        MessageResponse messageResponse = messageService.updateMessage(messageRequest);
        return ResponseEntity.ok(messageResponse);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postMessage(MessageRequest messageRequest){
        MessageResponse messageResponse = messageService.createMessage(messageRequest);
        return ResponseEntity.ok(messageResponse);
    }
}

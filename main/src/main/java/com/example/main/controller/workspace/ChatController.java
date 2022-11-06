package com.example.main.controller.workspace;

import com.example.main.DTO.request.workspace.ChatRequest;
import com.example.main.DTO.response.workspace.ChatResponse;
import com.example.main.service.workspace.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;


    @GetMapping("")
    public List<ChatResponse> getAllChats() {
        return chatService.getAllChats();
    }

    @GetMapping("/{id}")
    public ChatResponse getChat(@PathVariable Long id){
        return chatService.getChat(id);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateChat(ChatRequest chatRequest){
        ChatResponse chatResponse = chatService.updateChat(chatRequest);
        return ResponseEntity.ok(chatResponse);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postChat(ChatRequest chatRequest){
        ChatResponse chatResponse = chatService.createChat(chatRequest);
        return ResponseEntity.ok(chatResponse);
    }
}

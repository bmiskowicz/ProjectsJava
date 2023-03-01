package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.ChatRequest;
import com.example.main.DTO.response.workspace.ChatResponse;
import com.example.main.entity.workspace.Chat;
import com.example.main.repository.workspace.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public List<ChatResponse> getAllChats() {
        return chatRepository.findAll().stream()
                .map(ChatResponse::new)
                .collect(Collectors.toList());
    }

    public ChatResponse getChat(Long id){
        Chat chat = null;
        if(chatRepository.existsById(id)) {
            chat = chatRepository.findById(id).get();
        }
        return new ChatResponse(chat);

    }

    public ChatResponse createChat(ChatRequest chatRequest){
        Chat chat = Chat.builder()
                .chatId(chatRequest.getChatId())
                .issueId(chatRequest.getIssueId())
                .build();
        chatRepository.save(chat);
        return new ChatResponse(chat);
    }

    public ChatResponse updateChat(ChatRequest chatRequest){
        Chat chat = null;
        if(chatRepository.existsById(chatRequest.getChatId())) {
            chat = chatRepository.findById(chatRequest.getChatId()).get();
            chat.setMessageSet(chatRequest.getMessageSet());
            chatRepository.save(chat);
        }
        return new ChatResponse(chat);
    }

    public void deleteChat(Long id){
        if(chatRepository.existsById(id)) {
            Chat chat = chatRepository.findById(id).get();
            chatRepository.delete(chat);
        }
    }
}

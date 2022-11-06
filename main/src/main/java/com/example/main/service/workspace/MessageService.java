package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.MessagesRequest;
import com.example.main.DTO.response.workspace.MessagesResponse;
import com.example.main.entity.workspace.Message;
import com.example.main.repository.workspace.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessagesResponse> getAllMessages() {
        return messageRepository.findAll().stream()
                .map(MessagesResponse::new)
                .collect(Collectors.toList());
    }

    public MessagesResponse getMessage(Long id){
        Message message = null;
        if(messageRepository.existsById(id)) {
            message = messageRepository.findById(id).get();
        }
        return new MessagesResponse(message);

    }

    public MessagesResponse createMessage(MessagesRequest messagesRequest){
        Message message = Message.builder()
                .messageId(messagesRequest.getMessageId())
                .chat(messagesRequest.getChat())
                .content(messagesRequest.getContent())
                .profileId(messagesRequest.getProfileId())
                .build();
        messageRepository.save(message);
        return new MessagesResponse(message);
    }

    public MessagesResponse updateMessage(MessagesRequest messagesRequest){
        Message message = null;
        if(messageRepository.existsById(messagesRequest.getMessageId())) {
            message = messageRepository.findById(messagesRequest.getMessageId()).get();
            message.setContent(messagesRequest.getContent());
        }
        return new MessagesResponse(message);
    }

    public void deleteMessage(Long id){
        if(messageRepository.existsById(id)) {
            Message message = messageRepository.findById(id).get();
            messageRepository.delete(message);
        }
    }
}

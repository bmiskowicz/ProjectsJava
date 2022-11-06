package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.MessageRequest;
import com.example.main.DTO.response.workspace.MessageResponse;
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

    public List<MessageResponse> getAllMessages() {
        return messageRepository.findAll().stream()
                .map(MessageResponse::new)
                .collect(Collectors.toList());
    }

    public MessageResponse getMessage(Long id){
        Message message = null;
        if(messageRepository.existsById(id)) {
            message = messageRepository.findById(id).get();
        }
        return new MessageResponse(message);

    }

    public MessageResponse createMessage(MessageRequest messageRequest){
        Message message = Message.builder()
                .messageId(messageRequest.getMessageId())
                .chat(messageRequest.getChat())
                .content(messageRequest.getContent())
                .profileId(messageRequest.getProfileId())
                .build();
        messageRepository.save(message);
        return new MessageResponse(message);
    }

    public MessageResponse updateMessage(MessageRequest messageRequest){
        Message message = null;
        if(messageRepository.existsById(messageRequest.getMessageId())) {
            message = messageRepository.findById(messageRequest.getMessageId()).get();
            message.setContent(messageRequest.getContent());
        }
        return new MessageResponse(message);
    }

    public void deleteMessage(Long id){
        if(messageRepository.existsById(id)) {
            Message message = messageRepository.findById(id).get();
            messageRepository.delete(message);
        }
    }
}

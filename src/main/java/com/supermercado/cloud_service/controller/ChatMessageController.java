package com.supermercado.cloud_service.controller;

import com.supermercado.cloud_service.model.ChatMessage;
import com.supermercado.cloud_service.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*") // Allows the React frontend to fetch this API
public class ChatMessageController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @GetMapping("/general")
    public List<ChatMessage> getGeneralMessages() {
        return chatMessageRepository.findByReceiverIdOrderByTimestampAsc("general");
    }

    @GetMapping("/dm/{userId1}/{userId2}")
    public List<ChatMessage> getDirectMessages(@PathVariable String userId1, @PathVariable String userId2) {
        return chatMessageRepository.findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByTimestampAsc(
                userId1, userId2,
                userId2, userId1
        );
    }

    @PostMapping
    public ChatMessage sendMessage(@RequestBody ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        return chatMessageRepository.save(message);
    }
}

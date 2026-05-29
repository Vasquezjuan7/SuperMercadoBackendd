package com.supermercado.cloud_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "chat_messages")
public class ChatMessage {
    
    @Id
    private String id;
    private String senderId;
    private String senderName;
    private String receiverId; // "general" or a specific user ID
    private String content;
    private LocalDateTime timestamp;

    public ChatMessage() {
    }

    public ChatMessage(String senderId, String senderName, String receiverId, String content) {
        this.senderId = senderId;
        this.senderName = senderName;
        this.receiverId = receiverId;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }
    
    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }
    
    public String getReceiverId() { return receiverId; }
    public void setReceiverId(String receiverId) { this.receiverId = receiverId; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}

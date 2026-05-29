package com.supermercado.cloud_service.repository;

import com.supermercado.cloud_service.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    
    // For general chat
    List<ChatMessage> findByReceiverIdOrderByTimestampAsc(String receiverId);

    // For direct messages between user A and user B
    List<ChatMessage> findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByTimestampAsc(
            String senderId1, String receiverId1, 
            String senderId2, String receiverId2
    );
}

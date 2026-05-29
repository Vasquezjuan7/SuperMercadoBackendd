package com.supermercado.cloud_service.repository;

import com.supermercado.cloud_service.model.SessionLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionLogRepository extends MongoRepository<SessionLog, String> {
}

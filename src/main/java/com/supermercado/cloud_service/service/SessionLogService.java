package com.supermercado.cloud_service.service;

import com.supermercado.cloud_service.model.SessionLog;
import com.supermercado.cloud_service.repository.SessionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionLogService {

    @Autowired
    private SessionLogRepository sessionLogRepository;

    public List<SessionLog> getAllSessions() {
        return sessionLogRepository.findAll(Sort.by(Sort.Direction.DESC, "sessionId"));
    }

    public SessionLog createSession(SessionLog session) {
        return sessionLogRepository.save(session);
    }
}

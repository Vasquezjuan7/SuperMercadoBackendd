package com.supermercado.cloud_service.controller;

import com.supermercado.cloud_service.model.SessionLog;
import com.supermercado.cloud_service.repository.SessionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin("*")
public class SessionLogController {

    @Autowired
    private SessionLogRepository repository;

    @GetMapping
    public List<SessionLog> getAllSessions() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "sessionId"));
    }

    @PostMapping
    public SessionLog createSession(@RequestBody SessionLog session) {
        return repository.save(session);
    }
}

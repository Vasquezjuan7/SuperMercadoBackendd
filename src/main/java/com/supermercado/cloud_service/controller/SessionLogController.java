package com.supermercado.cloud_service.controller;

import com.supermercado.cloud_service.model.SessionLog;
import com.supermercado.cloud_service.service.SessionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin("*")
public class SessionLogController {

    @Autowired
    private SessionLogService sessionLogService;

    @GetMapping
    public List<SessionLog> getAllSessions() {
        return sessionLogService.getAllSessions();
    }

    @PostMapping
    public SessionLog createSession(@RequestBody SessionLog session) {
        return sessionLogService.createSession(session);
    }
}

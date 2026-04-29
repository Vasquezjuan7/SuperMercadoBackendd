package com.supermercado.cloud_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/health")
@CrossOrigin(origins = "*")
public class HealthController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping
    public Map<String, Object> health() {
        Map<String, Object> status = new HashMap<>();
        status.put("api", "UP");
        try {
            mongoTemplate.getDb().listCollectionNames().first();
            status.put("database", "CONNECTED");
        } catch (Exception e) {
            status.put("database", "DISCONNECTED");
            status.put("error", e.getMessage());
        }
        return status;
    }
}

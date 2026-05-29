package com.supermercado.cloud_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "sessions")
public class SessionLog {
    @Id
    private String id;
    private long sessionId;
    private String startTime;
    private String endTime;
    private List<LogEvent> events;

    public SessionLog() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public long getSessionId() { return sessionId; }
    public void setSessionId(long sessionId) { this.sessionId = sessionId; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    public List<LogEvent> getEvents() { return events; }
    public void setEvents(List<LogEvent> events) { this.events = events; }
}

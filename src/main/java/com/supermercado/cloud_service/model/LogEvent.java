package com.supermercado.cloud_service.model;

public class LogEvent {
    private long id;
    private String msg;
    private String type;
    private String time;

    // Constructors
    public LogEvent() {}

    public LogEvent(long id, String msg, String type, String time) {
        this.id = id;
        this.msg = msg;
        this.type = type;
        this.time = time;
    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
}

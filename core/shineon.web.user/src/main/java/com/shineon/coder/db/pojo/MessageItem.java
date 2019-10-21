package com.shineon.coder.db.pojo;

public class MessageItem {
    private String name;

    private short status;

    private long interval;

    private long lastTime;

    private short initStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public short getInitStatus() {
        return initStatus;
    }

    public void setInitStatus(short initStatus) {
        this.initStatus = initStatus;
    }

}

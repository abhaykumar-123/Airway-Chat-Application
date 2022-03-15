package com.abhaychaudhary.airway;

public class messages {

    String message;
    String senderId;
    long timstamp;
    String currenttime;


    public messages() {


    }

    public messages(String message, String senderId, long timstamp, String currenttime) {
        this.message = message;
        this.senderId = senderId;
        this.timstamp = timstamp;
        this.currenttime = currenttime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public long getTimstamp() {
        return timstamp;
    }

    public void setTimstamp(long timstamp) {
        this.timstamp = timstamp;
    }

    public String getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(String currenttime) {
        this.currenttime = currenttime;
    }
}

package com.alperen.bilkentride.Classes;

public class Message {
    private String sentById;
    private String time;
    private String text;

    private String sentByName;
    private String sentBySurname;

    private String sentByPhotoUrl;
    private boolean isMine;

    private boolean isRead;


    public Message() {
        sentById = null;
        time = null;
        text = null;
        isMine = false;
        isRead = false;
    }

    public Message(String sentById, String time, String text, boolean isMine, boolean isRead) {
        this.sentById = sentById;
        this.time = time;
        this.text = text;
        this.isMine = isMine;
        this.isRead = isRead;
    }

    public String getSentById() {
        return sentById;
    }

    public void setSentById(String sentById) {
        this.sentById = sentById;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getSentByName() {
        return sentByName;
    }

    public void setSentByName(String sentByName) {
        this.sentByName = sentByName;
    }

    public String getSentBySurname() {
        return sentBySurname;
    }

    public void setSentBySurname(String sentBySurname) {
        this.sentBySurname = sentBySurname;
    }

    public String getSentByPhotoUrl() {
        return sentByPhotoUrl;
    }

    public void setSentByPhotoUrl(String sentByPhotoUrl) {
        this.sentByPhotoUrl = sentByPhotoUrl;
    }
}

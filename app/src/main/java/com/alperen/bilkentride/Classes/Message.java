package com.alperen.bilkentride.Classes;

public class Message {
    private String sentById;
    private String time;
    private String text;
    private boolean isMine;


    public Message() {
        sentById = null;
        time = null;
        text = null;
        isMine = false;
    }

    public Message(String sentById, String time, String text, boolean isMine) {
        this.sentById = sentById;
        this.time = time;
        this.text = text;
        this.isMine = isMine;
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
}

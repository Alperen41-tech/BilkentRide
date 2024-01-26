package com.alperen.bilkentride.Classes;

import java.util.ArrayList;

public class Chat {
    private String firstUserId;
    private String secondUserId;
    private ArrayList<Message> messagesOnThisChat;

    public Chat() {
        firstUserId = null;
        secondUserId = null;
        messagesOnThisChat = new ArrayList<>();
    }

    public Chat(String firstUserId, String secondUserId, ArrayList<Message> messagesOnThisChat) {
        this.firstUserId = firstUserId;
        this.secondUserId = secondUserId;
        this.messagesOnThisChat = messagesOnThisChat;
    }

    public String getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(String firstUserId) {
        this.firstUserId = firstUserId;
    }

    public String getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(String secondUserId) {
        this.secondUserId = secondUserId;
    }

    public ArrayList<Message> getMessagesOnThisChat() {
        return messagesOnThisChat;
    }

    public void setMessagesOnThisChat(ArrayList<Message> messagesOnThisChat) {
        this.messagesOnThisChat = messagesOnThisChat;
    }
}

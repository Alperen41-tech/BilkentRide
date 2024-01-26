package com.alperen.bilkentride.Classes;

import java.util.ArrayList;

public class Chat {
    private String firstUserId;
    private String secondUserId;
    private ArrayList<Message> messagesOnThisChat;


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

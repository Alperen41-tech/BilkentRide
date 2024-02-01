package com.alperen.bilkentride.Classes;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FieldValue;

import java.util.ArrayList;

public class Chat {
    private String firstUserId;
    private String secondUserId;
    private ArrayList<Message> messagesOnThisChat;
    private int unreadMessages;
    private FieldValue lastChangedDate;

    private ArrayList<String> compOfId;





    public Chat() {
        firstUserId = null;
        secondUserId = null;
        messagesOnThisChat = new ArrayList<>();
        unreadMessages = 0;
        lastChangedDate = FieldValue.serverTimestamp();
        compOfId = new ArrayList<>();
    }

    public Chat(String firstUserId, String secondUserId, ArrayList<Message> messagesOnThisChat) {
        this.firstUserId = firstUserId;
        this.secondUserId = secondUserId;
        this.messagesOnThisChat = messagesOnThisChat;
        unreadMessages = 0;
        lastChangedDate = FieldValue.serverTimestamp();
        compOfId = new ArrayList<>();
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

    public int getUnreadMessages() {
        return unreadMessages;
    }

    public void setUnreadMessages(String curren_user_ID) {
        this.unreadMessages = calculateCountOfUnReadMessage(curren_user_ID);
    }

    public FieldValue getLast_changed_Date() {
        return lastChangedDate;
    }

    public void setLast_changed_Date() {
        this.lastChangedDate = FieldValue.serverTimestamp();
    }

    public ArrayList<String> getCompOfId() {
        return compOfId;
    }

    public void setCompOfId(ArrayList<String> compOfId) {
        this.compOfId = compOfId;
    }

    private int calculateCountOfUnReadMessage(String current_user_ID){
        int count = 0;

        for (Message m: getMessagesOnThisChat()){
            if (!m.getSentById().equals(current_user_ID) && !m.isRead()){
                count++;
            }
        }

        return count;
    }


}

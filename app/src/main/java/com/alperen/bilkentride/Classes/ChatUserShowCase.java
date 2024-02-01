package com.alperen.bilkentride.Classes;

public class ChatUserShowCase {

    private String id_of_other;
    private String name;
    private String surname;

    private String photoURL;

    private int unreadMessage;


    public ChatUserShowCase() {
        id_of_other = null;
        name = null;
        surname = null;
        photoURL = null;
        unreadMessage = 0;
    }

    public ChatUserShowCase(String id_of_other, String name, String surname, String photoURL, int unreadMessage) {
        this.id_of_other = id_of_other;
        this.name = name;
        this.surname = surname;
        this.photoURL = photoURL;
        this.unreadMessage = unreadMessage;
    }


    public String getId_of_other() {
        return id_of_other;
    }

    public void setId_of_other(String id_of_other) {
        this.id_of_other = id_of_other;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public int getUnreadMessage() {
        return unreadMessage;
    }

    public void setUnreadMessage(int unreadMessage) {
        this.unreadMessage = unreadMessage;
    }
}

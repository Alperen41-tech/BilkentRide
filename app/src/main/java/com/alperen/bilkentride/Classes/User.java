package com.alperen.bilkentride.Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String email;
    private String id;
    private boolean isFemale;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String department;
    private String gradYear;
    private boolean isRider;
    private int rate;
    private int numberOfRate;
    private int totalRate;
    private ArrayList<String> conversationsWithId;
    private String userPhotoUrl;
    private String userName;
    private String userSurname;
    private String biography;

    public User() {

        this.email = null;
        this.id = null;
        this.isFemale = false;
        this.birthDay = -1;
        this.birthMonth = -1;
        this.birthYear = -1;
        this.department = null;
        this.gradYear = null;
        this.isRider = false;
        this.rate = 0;
        this.numberOfRate = 0;
        this.totalRate = 0;
        this.conversationsWithId = new ArrayList<>();
        this.userPhotoUrl = null;
        this.userName = null;
        this.userSurname = null;
        this.biography = "";



    }

    public User(String email, String id, boolean isFemale, int birthDay, int birthMonth, int birthYear, String department, String gradYear, boolean isRider, int rate, int numberOfRate, int totalRate, ArrayList<String> conversationsWithId, String userPhotoUrl, String userName, String userSurname, String biography) {
        this.email = email;
        this.id = id;
        this.isFemale = isFemale;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.department = department;
        this.gradYear = gradYear;
        this.isRider = isRider;
        this.rate = rate;
        this.numberOfRate = numberOfRate;
        this.totalRate = totalRate;
        this.conversationsWithId = conversationsWithId;
        this.userPhotoUrl = userPhotoUrl;
        this.userName = userName;
        this.userSurname = userSurname;
        this.biography = biography;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGradYear() {
        return gradYear;
    }

    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    public boolean isRider() {
        return isRider;
    }

    public void setRider(boolean rider) {
        isRider = rider;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getNumberOfRate() {
        return numberOfRate;
    }

    public void setNumberOfRate(int numberOfRate) {
        this.numberOfRate = numberOfRate;
    }

    public int getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(int totalRate) {
        this.totalRate = totalRate;
    }

    public ArrayList<String> getConversationsWithId() {
        return conversationsWithId;
    }

    public void setConversationsWithId(ArrayList<String> conversationsWithId) {
        this.conversationsWithId = conversationsWithId;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }



    public void setNewUser(User new_user){
        this.email = new_user.getEmail();
        this.id = new_user.getId();
        this.isFemale = new_user.isFemale();
        this.birthDay = new_user.getBirthDay();
        this.birthMonth = new_user.getBirthMonth();
        this.birthYear = new_user.getBirthYear();
        this.department = new_user.getDepartment();
        this.gradYear = new_user.getGradYear();
        this.isRider = new_user.isRider();
        this.rate = new_user.getRate();
        this.numberOfRate = new_user.getNumberOfRate();
        this.totalRate = new_user.getTotalRate();
        this.userPhotoUrl = new_user.getUserPhotoUrl();
        this.userName = new_user.getUserName();
        this.userSurname = new_user.getUserSurname();
        this.biography = new_user.getBiography();
    }

    @Override
    public String toString(){
        return  this.userName + " " + this.userSurname + "\n" +
                 isFemale + "\n" +
                 birthDay + " " + birthMonth + " " + birthYear + "\n" +
                 department + " " + gradYear + "\n" +
                isRider +  "\n" +
                rate + numberOfRate + totalRate + "\n" +
                conversationsWithId + "\n" +
                biography;
    }
}

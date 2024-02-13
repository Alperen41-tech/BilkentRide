package com.alperen.bilkentride.Classes;

public class Ride {
    private String riderId;
    private String travellerId;
    private String whereFrom;
    private String whereTo;
    private boolean isApproved;
    private boolean isSelected;

    public Ride() {
        riderId = null;
        travellerId = null;
        whereFrom = null;
        whereTo = null;
        isApproved = false;
        isSelected = false;
    }

    public Ride(String riderId, String travellerId, String whereFrom, String whereTo, boolean isApproved, boolean isSelected) {
        this.riderId = riderId;
        this.travellerId = travellerId;
        this.whereFrom = whereFrom;
        this.whereTo = whereTo;
        this.isApproved = isApproved;
        this.isSelected = isSelected;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public String getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(String travellerId) {
        this.travellerId = travellerId;
    }

    public String getWhereFrom() {
        return whereFrom;
    }

    public void setWhereFrom(String whereFrom) {
        this.whereFrom = whereFrom;
    }

    public String getWhereTo() {
        return whereTo;
    }

    public void setWhereTo(String whereTo) {
        this.whereTo = whereTo;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

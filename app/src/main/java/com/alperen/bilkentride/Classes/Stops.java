package com.alperen.bilkentride.Classes;

import java.util.ArrayList;

public class Stops {
    private ArrayList<String> closeBuildingNames;
    private String timeBusComes;

    public Stops() {

        closeBuildingNames = new ArrayList<>();
        timeBusComes = null;
    }

    public Stops(ArrayList<String> closeBuildingNames, String timeBusComes) {
        this.closeBuildingNames = new ArrayList<>();
        this.timeBusComes = timeBusComes;
    }

    public ArrayList<String> getCloseBuildingNames() {
        return closeBuildingNames;
    }

    public void setCloseBuildingNames(ArrayList<String> closeBuildingNames) {
        this.closeBuildingNames = closeBuildingNames;
    }

    public String getTimeBusComes() {
        return timeBusComes;
    }

    public void setTimeBusComes(String timeBusComes) {
        this.timeBusComes = timeBusComes;
    }
}

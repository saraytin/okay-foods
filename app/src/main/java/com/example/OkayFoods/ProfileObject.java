package com.example.OkayFoods;

import java.io.Serializable;
import java.util.Date;

public class ProfileObject implements Serializable {

    private String profileName;
    private Integer profileAge;
    private Integer profileWeight;
    private Integer profileCalories;

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Integer getProfileAge() {
        return profileAge;
    }

    public void setProfileAge(Integer profileAge) {
        this.profileAge = profileAge;
    }

    public Integer getProfileWeight() {
        return profileWeight;
    }

    public void setProfileWeight(Integer profileWeight) {
        this.profileWeight = profileWeight;
    }

    public Integer getProfileCalories() {
        return profileCalories;
    }

    public void setProfileCalories(Integer profileCalories) {
        this.profileCalories = profileCalories;
    }



    public ProfileObject(String profileName, Integer profileAge, Integer profileWeight, Integer profileCalories) {
        this.profileName = profileName;
        this.profileAge = profileAge;
        this.profileWeight = profileWeight;
        this.profileCalories = profileCalories;
    }
}

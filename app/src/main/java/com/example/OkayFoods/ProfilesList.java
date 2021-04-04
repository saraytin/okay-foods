package com.example.OkayFoods;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfilesList implements Serializable {
    private ArrayList<ProfileObject> profiles;

    public ArrayList<ProfileObject> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<ProfileObject> profiles) {
        this.profiles = profiles;
    }

    public ProfilesList() {
        this.profiles = new ArrayList<>();
    }
}

package com.example.OkayFoods;

import java.io.Serializable;
import java.util.ArrayList;

public class GoalsList implements Serializable {
    private ArrayList<GoalObject> goals;

    public ArrayList<GoalObject> getGoals() {
        return goals;
    }

    public void setGoals(ArrayList<GoalObject> goals) {
        this.goals = goals;
    }

    public GoalsList() {
        this.goals = new ArrayList<>();
    }
}

package com.example.OkayFoods;

import java.io.Serializable;
import java.util.Date;

public class GoalObject implements Serializable {

    private String goalName;
    private String startDate;
    private String endDate;

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }



    public GoalObject(String goalName, String startDate, String endDate) {
        this.goalName = goalName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Date;

public class NewGoals extends AppCompatActivity {
    private GoalsList goalsList;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_goals);
        this.goalsList = (GoalsList) getIntent().getSerializableExtra("goalslist");
    }

    public void saveChanges(View view) {
        //add code here to get the info of new goal to add it to the java code
        EditText goal = (EditText)findViewById(R.id.goalName);
        EditText start = (EditText)findViewById(R.id.currentDate);
        EditText end = (EditText)findViewById(R.id.endDate);
        //add code here to add to call java class to add new goal
        GoalObject newGoal = new GoalObject(goal.getText().toString(),start.getText().toString(),end.getText().toString());
        this.goalsList.getGoals().add(newGoal);
        Toast.makeText(getApplicationContext(),"Goal has been saved!",Toast.LENGTH_SHORT).show();
        SharedPreferences  mPrefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(this.goalsList);
        prefsEditor.putString("GoalsList", json);
        prefsEditor.commit();

        Intent intent = new Intent();
        intent.putExtra("goalslist",this.goalsList);
        setResult(RESULT_OK,intent);
        finish();

    }
}
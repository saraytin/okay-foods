package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GoalsList goalsList;
    private ListView listView;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences  mPrefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("GoalsList", "");
        if(json == ""){
            this.goalsList = new GoalsList();
        }else {
            this.goalsList = gson.fromJson(json, GoalsList.class);
        }

        this.listView = (ListView) findViewById(R.id.goalOverview);
        displayGoalList(this.goalsList.getGoals());
    }

    public void displayGoalList(ArrayList<GoalObject> list){
        GoalsListViewAdapter adapter = new GoalsListViewAdapter(list, this);
        this.listView.setAdapter(adapter);

    }

    public void searchPage(View view) {


        Intent intent = new Intent(this, SearchPage.class);
        startActivity(intent);
    }

    public void goalsPage(View view) {


        Intent intent = new Intent(this, GoalsPage.class);
        intent.putExtra("goalslist", this.goalsList);
        startActivity(intent);
    }

    public void profilePage(View view) {


        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void homePage(View view) {
        Toast.makeText(getApplicationContext(),"You are on the home page!",Toast.LENGTH_SHORT).show();
    }
}
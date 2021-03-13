package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GoalsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_page);
    }

    public void newGoal(View view) {


        Intent intent = new Intent(this, NewGoals.class);
        EditText goal = (EditText) findViewById(R.id.goalName);

        startActivity(intent);
    }

    public void homePage(View view) {


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void searchPage(View view) {


        Intent intent = new Intent(this, SearchPage.class);
        startActivity(intent);
    }
    public void goalsPage(View view) {
        Toast.makeText(getApplicationContext(),"You are on the goals page!",Toast.LENGTH_SHORT).show();
    }
}
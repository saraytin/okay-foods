package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class NewGoals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_goals);
    }

    public void saveChanges(View view) {
        //add code here to get the info of new goal to add it to the java code
        EditText goal = (EditText)findViewById(R.id.goalName);
        EditText start = (EditText)findViewById(R.id.currentDate);
        EditText end = (EditText)findViewById(R.id.endDate);
        //add code here to add to call java class to add new goal

        Toast.makeText(getApplicationContext(),"Goal has been saved!",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, GoalsPage.class);
        startActivity(intent);
    }
}
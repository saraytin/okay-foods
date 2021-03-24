package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        String goal = goalName.id.getText().toString();
        Date start = currentDate.id.getText().toDate();
        Date end = endDate.id.getText().toDate();
        //add code here to add to call java class to add new goal

        Toast.makeText(getApplicationContext(),"Goal has been saved!",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, GoalsPage.class);
        startActivity(intent);
    }
}
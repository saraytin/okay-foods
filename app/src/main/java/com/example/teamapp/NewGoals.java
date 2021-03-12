package com.example.teamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewGoals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_goals);
    }

    public void saveChanges(View view) {

        Toast.makeText(getApplicationContext(),"Goal has been saved!",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, GoalsPage.class);
        startActivity(intent);
    }
}
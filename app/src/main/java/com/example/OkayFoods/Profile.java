package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileOutputStream;

public class Profile extends AppCompatActivity {
    extra extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


    }

    public void homePage(View view) {


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void saveChanges(View view) {
        Intent intent = new Intent(this, Profile.class);

        EditText name = (EditText)findViewById(R.id.userName);
        EditText age = (EditText)findViewById(R.id.userAge);
        EditText weight = (EditText)findViewById(R.id.userWeight);


        startActivity(intent);
    }

}
package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void searchPage(View view) {


        Intent intent = new Intent(this, SearchPage.class);
        startActivity(intent);
    }

    public void goalsPage(View view) {


        Intent intent = new Intent(this, GoalsPage.class);
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
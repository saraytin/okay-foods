package com.example.teamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SerachPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach_page);
    }

    public void search(View view) {

        Intent intent = new Intent(this, SearchResults.class);
        EditText goal = (EditText) findViewById(R.id.foodSearch);

        startActivity(intent);
    }

    public void homePage(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goalsPage(View view) {

        Intent intent = new Intent(this, GoalsPage.class);
        startActivity(intent);
    }

    public void searchPage(View view) {
        Toast.makeText(getApplicationContext(),"You are on the search page!",Toast.LENGTH_SHORT).show();
    }
}
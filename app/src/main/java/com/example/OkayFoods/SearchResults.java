package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
    }
    public void addCalories(View view) {
        //add code here to call java class to do the calorie adding

        Toast.makeText(getApplicationContext(),"the calories have been added!",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, SearchPage.class);
        startActivity(intent);
    }
}
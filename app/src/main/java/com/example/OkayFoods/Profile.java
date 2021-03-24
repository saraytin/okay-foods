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
        Intent intent = new Intent(this,Profile.class);
        EditText name = (EditText)findViewById(R.id.userName);
        EditText age = (EditText)findViewById(R.id.userAge);
        EditText weight = (EditText)findViewById(R.id.userWeight);

        TextView tv1 = (TextView)findViewById(R.id.name);
        tv1.setText("name");
        TextView tv2 = (TextView)findViewById(R.id.age);
        tv2.setText("age");
        TextView tv3 = (TextView)findViewById(R.id.weight);
        tv3.setText("weight");



        startActivity(intent);
    }

}
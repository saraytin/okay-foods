package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    private ProfilesList profilesList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        /*TextView tv1 = (TextView)findViewById(R.id.name);
        tv1.setText(extra.getName());
        TextView tv2 = (TextView)findViewById(R.id.age);
        tv1.setText(extra.getAge());
        TextView tv3 = (TextView)findViewById(R.id.weight);
        tv1.setText(extra.getWeight());*/
        this.profilesList = (ProfilesList) getIntent().getSerializableExtra("profileslist");
        this.listView = (ListView) findViewById(R.id.GoalList);
        displayProfilesList(this.profilesList.getProfiles());

    }

    public void displayProfilesList(ArrayList<ProfileObject> list){
        ProfilesListViewAdapter adapter = new ProfilesListViewAdapter(list, this);
        this.listView.setAdapter(adapter);

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
        /*String uName = name.getText().toString();
        int uAge = Integer.parseInt(age.getText().toString());
        int uWeight = Integer.parseInt(weight.getText().toString());
        extra.setName(uName);
        extra.setAge(uAge);
        extra.setWeight(uWeight);*/


    }

}
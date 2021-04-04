package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        this.listView = (ListView) findViewById(R.id.ProfileList);
        //displayProfilesList(this.profilesList.getProfiles());

    }

    public void displayProfilesList(ArrayList<ProfileObject> list){
        ProfilesListViewAdapter adapter = new ProfilesListViewAdapter(list, this);
        this.listView.setAdapter(adapter);

    }


    public void newProfile(View view) {

        Intent intent = new Intent(this, NewProfiles.class);
        intent.putExtra("profileslist", this.profilesList);
        startActivityForResult(intent,1);
    }

    public void homePage(View view) {


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                this.profilesList = (ProfilesList) data.getSerializableExtra("profileslist");
                displayProfilesList(this.profilesList.getProfiles());
            }

        }

    }

}
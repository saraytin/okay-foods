package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Date;

public class NewProfiles extends AppCompatActivity {
    private ProfilesList profilesList;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profiles);
        this.profilesList = (ProfilesList) getIntent().getSerializableExtra("profileslist");
    }

    public void saveChanges(View view) {
        //add code here to get the info of new profile to add it to the java code
        EditText profile = (EditText)findViewById(R.id.userName);
        EditText age = (EditText)findViewById(R.id.userAge);
        EditText weight = (EditText)findViewById(R.id.userWeight);
        EditText calories = (EditText)findViewById(R.id.userCalories);
        //add code here to add to call java class to add new profile
        ProfileObject newProfile = new ProfileObject(profile.getText().toString(),Integer.valueOf(age.getText().toString()),Integer.valueOf(weight.getText().toString()),Integer.valueOf(calories.getText().toString()));
        /*this.profilesList.getProfiles().add(newProfile);*/
        Toast.makeText(getApplicationContext(),"Profile has been saved!",Toast.LENGTH_SHORT).show();
        /*SharedPreferences  mPrefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(this.profilesList);
        prefsEditor.putString("ProfilesList", json);
        prefsEditor.commit();*/

        /*Intent intent = new Intent();
        intent.putExtra("profileslist",this.profilesList);
        setResult(RESULT_OK,intent);
        finish();*/

    }

    public void homePage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
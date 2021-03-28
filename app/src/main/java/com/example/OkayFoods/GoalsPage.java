package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GoalsPage extends AppCompatActivity {
    private GoalsList goalsList;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_page);
        this.goalsList = (GoalsList) getIntent().getSerializableExtra("goalslist");
        this.listView = (ListView) findViewById(R.id.GoalList);
        displayGoalList(this.goalsList.getGoals());
    }

    public void displayGoalList(ArrayList<GoalObject> list){
        GoalsListViewAdapter adapter = new GoalsListViewAdapter(list, this);
        this.listView.setAdapter(adapter);

    }


    public void newGoal(View view) {


        Intent intent = new Intent(this, NewGoals.class);
        intent.putExtra("goalslist", this.goalsList);
        startActivityForResult(intent,1);
    }

    public void homePage(View view) {


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void searchPage(View view) {


        Intent intent = new Intent(this, SearchPage.class);
        startActivity(intent);
    }
    public void goalsPage(View view) {
        Toast.makeText(getApplicationContext(),"You are on the goals page!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                this.goalsList = (GoalsList) data.getSerializableExtra("goalslist");
                displayGoalList(this.goalsList.getGoals());
            }

        }

    }
}

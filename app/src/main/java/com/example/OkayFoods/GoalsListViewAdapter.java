package com.example.OkayFoods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class GoalsListViewAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<GoalObject> list;
    private Context context;

    public GoalsListViewAdapter(ArrayList<GoalObject> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        //return list.get(pos).getId();
        return 0;
        //We aren't using Item ID's
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.goals_list, null);
        }

        //Handle TextView and name for the goal list and the list view
        TextView goalName = (TextView)view.findViewById(R.id.gName);
        goalName.setText(list.get(position).getGoalName());


        //Handle TextView for goal start date
        TextView goalStart = (TextView)view.findViewById(R.id.gStartDate);
        goalStart.setText(String.valueOf(list.get(position).getStartDate()));

        //Handle TextView for goal end date
        TextView goalEnd = (TextView)view.findViewById(R.id.gEndDate);
        goalEnd.setText(String.valueOf(list.get(position).getEndDate()));

        FloatingActionButton delete = (FloatingActionButton)view.findViewById(R.id.gDelete);
        //Define the onclick listener which will delete the item from the list and then refresh the
        // display
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });


        FloatingActionButton edit = (FloatingActionButton)view.findViewById(R.id.gEdit);
        //Define the onclick listener which will delete the item from the list and then refresh the
        // display
        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)context).editGoalsPage(v);
            }
        });



        return view;
    }
}

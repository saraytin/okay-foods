package com.example.OkayFoods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfilesListViewAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<ProfileObject> list;
    private Context context;

    public ProfilesListViewAdapter(ArrayList<ProfileObject> list, Context context) {
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
            view = inflater.inflate(R.layout.profiles_list, null);
        }

        //Handle TextView and name for the profile list and the list view
        TextView profileName = (TextView)view.findViewById(R.id.pName);
        profileName.setText(list.get(position).getProfileName());


        //Handle TextView for profile age
        TextView profileAge = (TextView)view.findViewById(R.id.pAge);
        profileAge.setText(String.valueOf(list.get(position).getProfileAge()));

        //Handle TextView for profile weight
        TextView profileWeight = (TextView)view.findViewById(R.id.pWeight);
        profileWeight.setText(String.valueOf(list.get(position).getProfileWeight()));

        //Handle TextView for profile calories
        TextView profileCalories = (TextView)view.findViewById(R.id.pCalories);
        profileCalories.setText(String.valueOf(list.get(position).getProfileCalories()));


        return view;
    }
}

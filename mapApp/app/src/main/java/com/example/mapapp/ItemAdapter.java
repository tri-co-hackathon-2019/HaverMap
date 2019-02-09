package com.example.mapapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    ListView results;
    ArrayList<String> resultList = new ArrayList<String>();
    ArrayList<String> food = new ArrayList<String>();

    public ItemAdapter(Context c, ArrayList<String> r, ArrayList<String> f){
        resultList = r;
        food = f;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Object getItem(int position) {
        return resultList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.listview_layout, null);

        TextView buildingTextView = (TextView) v.findViewById(R.id.buildingTextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);

        String building = resultList.get(position);
        String description = food.get(position);

        buildingTextView.setText(building);
        descriptionTextView.setText(description);

        return v;
    }
}

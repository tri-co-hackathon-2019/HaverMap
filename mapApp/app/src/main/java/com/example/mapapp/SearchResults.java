package com.example.mapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.*;

import java.awt.font.TextAttribute;

public class SearchResults extends AppCompatActivity {

    ListView results;
    ArrayList<String> resultList = new ArrayList<String>();
    ArrayList<String> food = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        TextView announcement = (TextView) findViewById(R.id.announcementViewText);
        String text = getIntent().getExtras().getString("haverMap");
        announcement.setText("You searched for " + text + "\n" + "The suggestions are: ");

        results = (ListView) findViewById(R.id.resultsListView);
        resultList.add("dog");
        resultList.add("cat");
        resultList.add("squirrel");
        food.add("bone");
        food.add("fish");
        food.add("nut");

        ItemAdapter itemAdapter = new ItemAdapter(this, resultList, food);
        results.setAdapter(itemAdapter);
    }
}

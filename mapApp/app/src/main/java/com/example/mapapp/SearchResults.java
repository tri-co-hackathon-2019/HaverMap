package com.example.mapapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import java.util.*;
import com.example.mapapp.myData.*;

public class SearchResults extends AppCompatActivity {

    ListView resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        TextView announcement = (TextView) findViewById(R.id.announcementViewText);
        String userInput = getIntent().getExtras().getString("haverMap");
        announcement.setText("You searched for " + userInput + "\n" + "The suggestions are: ");

//        Context appContext = getApplicationContext();
        dataCollection myCollection = new dataCollection(this);
        subTag mySubtag = new subTag(this);
        search searchEngine = new search(myCollection, mySubtag);
        ArrayList<dataObject> result = searchEngine.searchByFunction(userInput);

        resultList = (ListView) findViewById(R.id.resultsListView);

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> descriptions = new ArrayList<String>();

        for (int i = 0; i < result.size(); i++){
            names.add(result.get(i).getOfficialName());
            descriptions.add(result.get(i).getDescription());
        }

        ItemAdapter itemAdapter = new ItemAdapter(this, names, descriptions);
        resultList.setAdapter(itemAdapter);
    }
}

package com.example.mapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        TextView result = (TextView) findViewById(R.id.resultViewText);
        String text = getIntent().getExtras().getString("haverMap");
        result.setText("You searched for " + text);
    }
}

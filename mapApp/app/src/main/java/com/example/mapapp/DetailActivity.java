package com.example.mapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.mapapp.SearchResults.result;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView testing = (TextView) findViewById(R.id.testTextView);

        int pos = getIntent().getExtras().getInt("name");

        testing.setText(result.get(pos).getOfficialName());
    }
}

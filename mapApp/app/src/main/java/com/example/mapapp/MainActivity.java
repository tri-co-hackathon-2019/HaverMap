package com.example.mapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton = (Button) findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText searchBarEditText = (EditText) findViewById(R.id.searchBarEditText);
                String keyword = searchBarEditText.getText().toString();

                Intent goToResults = new Intent(getApplicationContext(), SearchResults.class);
                goToResults.putExtra("haverMap",keyword);
                startActivity(goToResults);
            }
        });
    }
}

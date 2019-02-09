package com.example.mapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.*;

import static com.example.mapapp.SearchResults.result;

public class DetailActivity extends AppCompatActivity {

    public static int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView nameField = (TextView) findViewById(R.id.nameTextView);

        pos = getIntent().getExtras().getInt("name");

        String buildingName = result.get(pos).getOfficialName();
        nameField.setText(buildingName);

        TextView nicknames = (TextView) findViewById(R.id.nicknameTextView);
        nicknames.setText("Nicknames of the building are: " + result.get(pos).getStringName());
//
//        TextView description = (TextView) findViewById(R.id.descriptionTextView);
//        description.setText("Description: " + result.get(pos).getDescription());
//
        TextView things = (TextView) findViewById(R.id.thingTextView);
        things.setText("Things of interest are: " + result.get(pos).getStringThing());

        TextView places = (TextView) findViewById(R.id.placeTextView);
        places.setText("Places of interest are: " + result.get(pos).getStringPlace());

        TextView functions = (TextView) findViewById(R.id.functionsTextView);
        functions.setText("Functions: " + result.get(pos).getFunctionName());

        ImageView img = (ImageView) findViewById(R.id.buildingImageView);

        int drawableId = getResources().getIdentifier(transform(buildingName), "drawable", getPackageName());
        img.setImageResource(drawableId);

        Button goToMap = (Button) findViewById(R.id.goToMapButton);

        goToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchToMap = new Intent(getApplicationContext(), MapsActivity.class);
                switchToMap.putExtra("position", pos);
                startActivity(switchToMap);
            }
        });
    }

    private String transform(String word){
        word = word.toLowerCase();
        word = word.replaceAll(" ","");
        return word;
    }
}

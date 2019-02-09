package com.example.mapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.mapapp.SearchResults.result;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView nameField = (TextView) findViewById(R.id.nameTextView);

        int pos = getIntent().getExtras().getInt("name");

        String buildingName = result.get(pos).getOfficialName();
        nameField.setText(buildingName);

        ImageView img = (ImageView) findViewById(R.id.buildingImageView);

        int drawableId = getResources().getIdentifier(transform(buildingName), "drawable", getPackageName());
        img.setImageResource(drawableId);
    }

    private String transform(String word){
        word = word.toLowerCase();
        word = word.replaceAll(" ","");
        return word;
    }
}

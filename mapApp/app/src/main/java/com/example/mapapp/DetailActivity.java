package com.example.mapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;

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

        TextView nicknames = (TextView) findViewById(R.id.nicknameTextView);
//        nicknames.setText("Nicknames of the building are: " + intoLine(result.get(pos).getName()));

        ImageView img = (ImageView) findViewById(R.id.buildingImageView);

        int drawableId = getResources().getIdentifier(transform(buildingName), "drawable", getPackageName());
        img.setImageResource(drawableId);
    }

    private String transform(String word){
        word = word.toLowerCase();
        word = word.replaceAll(" ","");
        return word;
    }

//    private String intoLine(ArrayList<String> words){
//        String combined = "";
//        for (int i = 0; i < words.size() - 1; i++){
//            combined.concat(words.get(i).concat(" ,"));
//        }
//        combined.concat(words.get(words.size() - 1));
//        return combined;
//    }
}

package com.example.tricomap.myData;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class subTag {
    ArrayList<relation> relationSet;

    Context mContext;

    public subTag(Context context)  {
        relationSet = new ArrayList<relation>();
        mContext = context;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(mContext.getAssets().open("tag.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                relation newObject = new relation();
                // a new ojbect is founded
                if(mLine.startsWith("Name:")){
                    newObject.setHead(reader.readLine());
                }
                if(reader.readLine().startsWith("Tags:")){
                    while((mLine = reader.readLine()).startsWith(":End")==false){
                        newObject.insertSubtag(mLine);
                    }
                    reader.readLine();
                }
                this.relationSet.add(newObject);
            }
        } catch (IOException e) {
            //log the exception
            System.out.println("Read File wrong");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                    System.out.println("Close file wrong");
                }
            }
        }
    }

    public int getHeadIndex(String request){
        request = request.trim();
        for(int i = 0; i < this.relationSet.size();i++){
            if(this.relationSet.get(i).head.toLowerCase().contains(request)){
                return i;
            }
        }
        return -1;
    }
}



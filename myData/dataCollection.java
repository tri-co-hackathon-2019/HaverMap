package com.example.tricomap.myData;
import android.content.Context;
import android.content.res.AssetManager;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class dataCollection {

    ArrayList<dataObject> dataSet;
    Context mContext;

    public ArrayList<dataObject> getDataSet() {
        return dataSet;
    }

    public dataCollection(Context context)  {
        mContext = context;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(mContext.getAssets().open("allTextData.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            dataSet = new ArrayList<dataObject>();
            while ((mLine = reader.readLine()) != null) {
                //process line
                dataObject newObject = new dataObject();
                // a new ojbect is founded
                while(mLine.trim().startsWith("Official Name") == false){
                    mLine = reader.readLine();
                }
                if(mLine.trim().startsWith("Official Name")){
                    newObject.setOfficialname(reader.readLine());
                    reader.readLine();
                }
                if((mLine = reader.readLine()) != null && mLine.trim().startsWith("Name")){
                    while((mLine = reader.readLine()).trim().startsWith(":End")==false){
                        newObject.insertName(mLine);
                    }
                }
                if((mLine = reader.readLine()) != null && mLine.trim().startsWith("Function:")){
                    while((mLine = reader.readLine()).trim().startsWith(":End")==false){
                        newObject.insertFunction(mLine);
                    }
                }
                if((mLine = reader.readLine()) != null && mLine.trim().startsWith("Places of Interest")){
                    while((mLine = reader.readLine()).trim().startsWith(":End")==false){
                        newObject.insertPlaceOfInterest(mLine);
                    }
                }
                if((mLine = reader.readLine()) != null && mLine.trim().startsWith("Things of Interest")){
                    while((mLine = reader.readLine()).trim().startsWith(":End")==false){
                        newObject.insertThingOfInterest(mLine);
                    }
                }
                if((mLine = reader.readLine()) != null && mLine.startsWith("Description:")){
                    mLine = reader.readLine();
                    if (mLine.trim().startsWith(":End") == false){
                    newObject.setDescription(mLine);
                    }
                    reader.readLine();
                }
                dataSet.add(newObject);
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
}

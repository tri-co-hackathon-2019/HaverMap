package com.example.tricomap.myData;
import java.lang.reflect.Array;
import java.util.*;
public class dataObject implements Comparable<dataObject>{
    String officialName;
    ArrayList<tag> name;
    ArrayList<tag> placeOfInterest;
    ArrayList<tag> thingOfInterest;
    ArrayList<String> function;
    String description;
    float Lat;
    float Lng;

    int priority;
    public dataObject(){
        name = new ArrayList<tag>();
        placeOfInterest = new ArrayList<tag>();
        thingOfInterest = new ArrayList<tag>();
        function = new ArrayList<String>();
    }

    public void setOfficialname(String officialName){
        this.officialName = officialName;
    }

    // setter method for name
    public void insertName(String inputNameString){
        String[] temp = inputNameString.split(",");
        tag newTag = new tag(temp[0].trim(),Integer.parseInt(temp[1].replace(" ","")));
        name.add(newTag);
        Collections.sort(name);
    }

    // setter method for function.
    public void insertFunction(String inputFunction){
        // If there only exists none string, initialize string;
        function.add(inputFunction.trim());
    }

    // setter method for description
    public void setDescription(String description) {
        this.description = description.trim();
    }

    // setter method for placeOfInterest
    public void insertPlaceOfInterest(String inputTag){
        String[] temp = inputTag.split(",");
        tag newTag = new tag(temp[0].trim(),Integer.parseInt(temp[1].replace(" ","")));
        placeOfInterest.add(newTag);
        Collections.sort(placeOfInterest);
    }

    public void insertThingOfInterest(String inputTag){
        String[] temp = inputTag.split(",");
        tag newTag = new tag(temp[0].trim(),Integer.parseInt(temp[1].replace(" ","")));
        thingOfInterest.add(newTag);
        Collections.sort(thingOfInterest);
    }

    public void setLatLng(float a, float b){
        this.Lat = a;
        this.Lng = b;
    }

    public ArrayList<tag> getName(){
        return this.name;
    }

    public ArrayList<String> getFunction(){
        return this.function;
    }

    public ArrayList<tag> getThingOfInterest(){
        return this.thingOfInterest;
    }

    public ArrayList<tag> getPlaceOfInterest(){
        return this.placeOfInterest;
    }

    public float getLat(){
        return this.Lat;
    }

    public float getLng(){
        return this.Lng;
    }

    @Override
    public int compareTo(dataObject other){
        if(this.priority>= other.priority){
            return 1;
        }
        else{
            return 0;
        }

    }

}

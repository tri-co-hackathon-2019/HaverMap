package com.example.tricomap.myData;

import java.util.ArrayList;
import java.util.Collections;

public class search {
    dataCollection myCollection;
    subTag myRelation;
    public search(dataCollection dataCollection,subTag relationColelction){
        this.myCollection = dataCollection;
        this.myRelation = relationColelction;
    }

    public ArrayList<dataObject> singleSearchFunction(String request){
        request = request.trim();
        ArrayList<dataObject> result = new ArrayList<dataObject>();
        for (int i = 0;i< this.myCollection.dataSet.size();i++){
            // If requested function is inside, add into it.
            boolean hasObject = false;
            for (int j = 0; j < this.myCollection.dataSet.get(i).name.size(); j++) {
                if (this.myCollection.dataSet.get(i).name.get(j).name.toLowerCase().contains(request.toLowerCase())) {
                    this.myCollection.dataSet.get(i).priority = this.myCollection.dataSet.get(i).name.get(j).vote;
                    result.add(this.myCollection.dataSet.get(i));
                    hasObject = true;
                    break;
                }
            }
            if(hasObject){break;}
            for (int j  = 0; j < this.myCollection.dataSet.get(i).placeOfInterest.size();j++){
                if(this.myCollection.dataSet.get(i).placeOfInterest.get(j).name.toLowerCase().contains(request.toLowerCase())){
                    this.myCollection.dataSet.get(i).priority = this.myCollection.dataSet.get(i).placeOfInterest.get(j).vote;
                    result.add(this.myCollection.dataSet.get(i));
                    hasObject = true;
                    break;
                }
            }
            if(hasObject){break;}
            for (int j  = 0; j < this.myCollection.dataSet.get(i).thingOfInterest.size();j++){
                if(this.myCollection.dataSet.get(i).thingOfInterest.get(j).name.toLowerCase().contains(request.toLowerCase())){
                    this.myCollection.dataSet.get(i).priority = this.myCollection.dataSet.get(i).thingOfInterest.get(j).vote;
                    result.add(this.myCollection.dataSet.get(i));
                    hasObject = true;
                    break;
                }
            }
            if(hasObject){break;}
            for (int j  = 0; j < this.myCollection.dataSet.get(i).placeOfInterest.size();j++){
                if(this.myCollection.dataSet.get(i).placeOfInterest.get(j).name.toLowerCase().contains(request.toLowerCase())){
                    this.myCollection.dataSet.get(i).priority = this.myCollection.dataSet.get(i).placeOfInterest.get(j).vote;
                    result.add(this.myCollection.dataSet.get(i));
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public boolean isHead(String request){
        request = request.trim();
        return this.myRelation.getHeadIndex(request) != -1;
    }

    public ArrayList<dataObject> searchByFunction(String request){
        request = request.trim();
        if (isHead(request) == false){
            return this.singleSearchFunction(request);
        }
        else {
            int index;
            index = this.myRelation.getHeadIndex(request);
            ArrayList<dataObject> result = new ArrayList<dataObject>();
            ArrayList<dataObject> temp = new ArrayList<dataObject>();
            for (int i = 0; i < this.myRelation.relationSet.get(index).subTag.size(); i++) {
                temp =  this.searchByFunction(this.myRelation.relationSet.get(index).subTag.get(i));
                result.removeAll(temp);
                result.addAll(temp);
            }
            Collections.sort(result);
            return result;
        }
    }
}

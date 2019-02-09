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

    public ArrayList<dataObject> singleSearchName(String request) {
        ArrayList<dataObject> result = new ArrayList<dataObject>();
        // If requested name is inside, add into it.
        for (int i = 0; i < this.myCollection.dataSet.size(); i++) {
            for (int j = 0; j < this.myCollection.dataSet.get(i).name.size(); j++) {
                if (this.myCollection.dataSet.get(i).name.get(j).name.contains(request)) {
                    this.myCollection.dataSet.get(i).priority = this.myCollection.dataSet.get(i).name.get(j).vote;
                    result.add(this.myCollection.dataSet.get(i));
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public ArrayList<dataObject> singleSearchFunction(String request){
        ArrayList<dataObject> result = new ArrayList<dataObject>();
        for (int i = 0;i< this.myCollection.dataSet.size();i++){
            // If requested function is inside, add into it.
            for (int j  = 0; j < this.myCollection.dataSet.get(i).placeOfInterest.size();j++){
                if(this.myCollection.dataSet.get(i).placeOfInterest.get(j).name.contains(request)){
                    this.myCollection.dataSet.get(i).priority = this.myCollection.dataSet.get(i).placeOfInterest.get(j).vote;
                    result.add(this.myCollection.dataSet.get(i));
                }
            }

            for (int j  = 0; j < this.myCollection.dataSet.get(i).thingOfInterest.size();j++){
                if(this.myCollection.dataSet.get(i).thingOfInterest.get(j).name.contains(request)){
                    this.myCollection.dataSet.get(i).priority = this.myCollection.dataSet.get(i).thingOfInterest.get(j).vote;
                    result.add(this.myCollection.dataSet.get(i));
                }
            }

            for (int j  = 0; j < this.myCollection.dataSet.get(i).placeOfInterest.size();j++){
                if(this.myCollection.dataSet.get(i).placeOfInterest.get(j).name.contains(request)){
                    this.myCollection.dataSet.get(i).priority = this.myCollection.dataSet.get(i).placeOfInterest.get(j).vote;
                    result.add(this.myCollection.dataSet.get(i));
                }
            }
        }
        Collections.sort(result);
        return result;
    }


    public ArrayList<dataObject> searchByName(String request){
        int index = this.myRelation.getHeadIndex(request);
        if (index == -1){
            return this.singleSearchName(request);
        }
        else {
            ArrayList<dataObject> result = new ArrayList<dataObject>();
            ArrayList<dataObject> temp = new ArrayList<dataObject>();
            for (int i = 0; i < this.myRelation.relationSet.get(index).subTag.size(); i++) {
                temp = singleSearchName(this.myRelation.relationSet.get(index).subTag.get(i));
                result.removeAll(temp);
                result.addAll(temp);
            }
            Collections.sort(result);
            return result;
        }
    }


    public ArrayList<dataObject> searchByFunction(String request){
        int index = this.myRelation.getHeadIndex(request);
        if (index == -1){
            return this.singleSearchFunction(request);
        }
        else {
            ArrayList<dataObject> result = new ArrayList<dataObject>();
            ArrayList<dataObject> temp = new ArrayList<dataObject>();
            for (int i = 0; i < this.myRelation.relationSet.get(index).subTag.size(); i++) {
                temp = this.singleSearchFunction(this.myRelation.relationSet.get(index).subTag.get(i));
                result.removeAll(temp);
                result.addAll(temp);
            }
            Collections.sort(result);
            return result;
        }
    }
}

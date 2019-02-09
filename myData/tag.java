package com.example.tricomap.myData;

import java.util.Comparator;

public class tag implements Comparable<tag>{
    String name;
    int vote;

    public tag(String name, int vote){
        this.name = name;
        this.vote = vote;
    }

    public String getString(){
        return this.name;
    }

    public int getVote(){
        return this.vote;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setVote(int vote){
        this.vote = vote;
    }

    public void incrementVote(){
        this.vote += 1;
    }

    @Override
    public int compareTo(tag other){
        if(this.vote>= other.vote){
            return 1;
        }
        else{
            return 0;
        }

    }

    @Override
    public String toString() {
        return this.name+ " "+Integer.toString(this.vote);
    }
}


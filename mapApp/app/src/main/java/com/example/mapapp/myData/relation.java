package com.example.mapapp.myData;

import java.util.ArrayList;

public class relation {
    String head;
    ArrayList<String> subTag;

    public relation(){
        subTag = new ArrayList<String>();
    }

    public void setHead(String head) {
        this.head = head.trim();
    }

    public void insertSubtag(String a){
        this.subTag.add(a.trim());
    }
}

package com.example.secondbrain;

import java.io.Serializable;

public class DBItem implements Serializable {

    private int id;
    private String title, content, etc, first;

    //constructors
    public DBItem(int id, String title, String content, String etc, String first) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.etc = etc;
        this.first = first;
    }

    public DBItem(String title, String content, String etc, String first) {
        this.title = title;
        this.content = content;
        this.etc = etc;
        this.first = first;
    }


    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String toString(){ return this.first;}
}

package com.example.secondbrain;

public class LocationItem extends DBItem {
    String location;

    //constructors
    public LocationItem(int id, String title, String content, String etc, String first, String location) {
        super(id, title, content, etc, first);
        this.location = location;
    }

    public LocationItem(String title, String content, String etc, String first, String location) {
        super(title, content, etc, first);
        this.location = location;
    }


    //getters and setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

package com.example.newshub;

public class Superheros {
    String title;
    String description;
    String photo;

    public Superheros(){}

    public Superheros(String title,String description,String photo){
        this.title=title;
        this.description=description;
        this.photo=photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

package com.example.appsmartlearn;

public class ModelImageVocab {
    String img;
    String name;

    public ModelImageVocab(String img, String name) {
        this.img = img;
        this.name = name;
    }

    public ModelImageVocab(String img) {
        this.img = img;
    }

    public ModelImageVocab() {
    }



    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

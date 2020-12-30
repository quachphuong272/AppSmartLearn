package com.example.appsmartlearn;

public class CategoryModel {
    private String id_category;
    private String name_category;


    public CategoryModel(String id, String name)
    {
        this.id_category = id;
        this.name_category = name;

    }


    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }
}

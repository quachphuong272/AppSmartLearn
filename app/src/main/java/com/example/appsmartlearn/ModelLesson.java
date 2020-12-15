package com.example.appsmartlearn;

public class ModelLesson {
    private String Content;
    private String Desc;
    private String Name;
    private String Status;
    private String id_topic;

    public ModelLesson() {
    }

    public ModelLesson(String content, String desc, String name, String status, String id_topic) {
        this.Content = content;
        this.Desc = desc;
        this.Name= name;
        this.Status = status;
        this.id_topic = id_topic;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        this.Desc = desc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getId_topic() {
        return id_topic;
    }

    public void setId_topic(String id_topic) {
        this.id_topic = id_topic;
    }
}

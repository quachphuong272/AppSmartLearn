package com.example.appsmartlearn;

public class Model_User {
    private String username;
    private String password;
    private String email;
    private String DoB;
    private String id_category;
    private String id_userType;

    public Model_User(String username, String password, String email, String DoB, String id_category, String id_userType)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.DoB = DoB;
        this.id_category = id_category;
        this.id_userType = id_userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    public String getId_userType() {
        return id_userType;
    }

    public void setId_userType(String id_userType) {
        this.id_userType = id_userType;
    }
}

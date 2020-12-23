package com.example.appsmartlearn;

public class ModelNormalVocab {
    private String Eng;
    private String Vie;
    private String Status;

    public ModelNormalVocab() {
    }

    public ModelNormalVocab(String vie, String eng, String status) {
        this.Vie = vie;
        this.Eng= eng;
        this.Status = status;
    }

    public String getVie() {
        return Vie;
    }

    public void setVie(String vie) {
        Vie = vie;
    }

    public String getEng() {
        return Eng;
    }

    public void setEng(String eng) {
        Eng = eng;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}

package com.nguyenminh.learn_english.modul.phrase;

/**
 * Created by Big Boss on 07/04/2018.
 */

public class Phrase {
    private String enTitle;
    private String localTitle;
    private int id;

    public Phrase(int id, String enTitle, String localTitle) {
        this.enTitle = enTitle;
        this.localTitle = localTitle;
        this.id = id;
    }



    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }

    public String getLocalTitle() {
        return localTitle;
    }

    public void setLocalTitle(String localTitle) {
        this.localTitle = localTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

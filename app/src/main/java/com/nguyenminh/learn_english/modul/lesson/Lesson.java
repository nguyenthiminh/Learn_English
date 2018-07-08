package com.nguyenminh.learn_english.modul.lesson;

/**
 * Created by hieph on 7/1/2018.
 */

public class Lesson {
    private String enTitle;
    private String localTitle;
    private int id;

    public Lesson(int id, String enTitle, String localTitle) {
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

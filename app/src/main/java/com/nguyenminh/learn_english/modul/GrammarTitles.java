package com.nguyenminh.learn_english.modul;

/**
 * Created by hieph on 7/1/2018.
 */

public class GrammarTitles {
    private int id;
    private String localTitle;
    private String enTitle;

    public GrammarTitles(int id, String localTitle, String enTitle) {
        this.id = id;
        this.localTitle = localTitle;
        this.enTitle = enTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalTitle() {
        return localTitle;
    }

    public void setLocalTitle(String localTitle) {
        this.localTitle = localTitle;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }
}

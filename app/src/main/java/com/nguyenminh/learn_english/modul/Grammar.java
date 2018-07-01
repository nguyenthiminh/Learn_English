package com.nguyenminh.learn_english.modul;

/**
 * Created by hieph on 7/1/2018.
 */

public class Grammar {
    private String title;
    private int id;
    private String cdata;

    public Grammar(String title, int id, String cdata) {
        this.title = title;
        this.id = id;
        this.cdata = cdata;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCdata() {
        return cdata;
    }

    public void setCdata(String cdata) {
        this.cdata = cdata;
    }
}

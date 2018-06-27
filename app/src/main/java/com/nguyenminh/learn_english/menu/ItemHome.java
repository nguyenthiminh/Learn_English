package com.nguyenminh.learn_english.menu;

/**
 * Created by hieph on 6/26/2018.
 */

public class ItemHome {
    private int id;
    private String name;

    public ItemHome(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

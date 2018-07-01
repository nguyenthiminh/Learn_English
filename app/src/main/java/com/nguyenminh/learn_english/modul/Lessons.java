package com.nguyenminh.learn_english.modul;

import java.util.List;

/**
 * Created by hieph on 7/1/2018.
 */

public class Lessons {
    private int id;
    private List<ItemLesson>itemLessons;

    public Lessons(int id, List<ItemLesson> itemLessons) {
        this.id = id;
        this.itemLessons = itemLessons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemLesson> getItemLessons() {
        return itemLessons;
    }

    public void setItemLessons(List<ItemLesson> itemLessons) {
        this.itemLessons = itemLessons;
    }
}

package com.nguyenminh.learn_english.modul.lesson;

import java.util.List;

/**
 * Created by Big Boss on 07/06/2018.
 */

public class ItemLessons {
    private int id;

    public ItemLessons(int id, List<ItemLesson> itemLessons) {
        this.id = id;
        this.itemLessons = itemLessons;
    }

    private List<ItemLesson>itemLessons;

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

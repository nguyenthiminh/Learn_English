package com.nguyenminh.learn_english.modul.word;

import java.util.List;

/**
 * Created by Big Boss on 07/08/2018.
 */

public class ItemWords {
    private int id;
    private List<ItemWord>itemWords;

    public ItemWords(int id, List<ItemWord> itemWords) {
        this.id = id;
        this.itemWords = itemWords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemWord> getItemWords() {
        return itemWords;
    }

    public void setItemWords(List<ItemWord> itemWords) {
        this.itemWords = itemWords;
    }
}

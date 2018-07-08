package com.nguyenminh.learn_english.modul.phrase;

import java.util.List;

/**
 * Created by Big Boss on 07/08/2018.
 */

public class ItemPhrases {
    private int id;
    private List<ItemPhrase>itemPhrases;

    public ItemPhrases(int id, List<ItemPhrase> itemPhrases) {
        this.id = id;
        this.itemPhrases = itemPhrases;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemPhrase> getItemPhrases() {
        return itemPhrases;
    }

    public void setItemPhrases(List<ItemPhrase> itemPhrases) {
        this.itemPhrases = itemPhrases;
    }
}

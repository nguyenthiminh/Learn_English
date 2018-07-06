package com.nguyenminh.learn_english.modul;

import com.nguyenminh.learn_english.modul.grammar.ItemGrammar;

import java.util.List;

/**
 * Created by hieph on 7/1/2018.
 */

public class Lessons {
    private int id;
    private List<ItemGrammar> itemGrammars;

    public Lessons(int id, List<ItemGrammar> itemGrammars) {
        this.id = id;
        this.itemGrammars = itemGrammars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemGrammar> getItemGrammars() {
        return itemGrammars;
    }

    public void setItemGrammars(List<ItemGrammar> itemGrammars) {
        this.itemGrammars = itemGrammars;
    }
}

package com.nguyenminh.learn_english.modul.lesson;

import com.nguyenminh.learn_english.modul.grammar.ItemGrammar;

import java.util.List;

/**
 * Created by hieph on 7/1/2018.
 */

public class ItemLesson {

    private int stt;
    private String person;
    private String en_text;
    private String local_text;
    private String mp3_normal;
    private String mp3_slow;

    public ItemLesson(int stt,String person, String en_text, String local_text, String mp3_normal, String mp3_slow) {
        this.stt=stt;
        this.person = person;
        this.en_text = en_text;
        this.local_text = local_text;
        this.mp3_normal = mp3_normal;
        this.mp3_slow = mp3_slow;
    }


    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getEn_text() {
        return en_text;
    }

    public void setEn_text(String en_text) {
        this.en_text = en_text;
    }

    public String getLocal_text() {
        return local_text;
    }

    public void setLocal_text(String local_text) {
        this.local_text = local_text;
    }

    public String getMp3_normal() {
        return mp3_normal;
    }

    public void setMp3_normal(String mp3_normal) {
        this.mp3_normal = mp3_normal;
    }

    public String getMp3_slow() {
        return mp3_slow;
    }

    public void setMp3_slow(String mp3_slow) {
        this.mp3_slow = mp3_slow;
    }



}

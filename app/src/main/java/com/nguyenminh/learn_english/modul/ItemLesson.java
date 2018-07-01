package com.nguyenminh.learn_english.modul;

/**
 * Created by hieph on 7/1/2018.
 */

public class ItemLesson {
    private String mp3Nomal;
    private String mp3Slow;
    private String enText;
    private String localText;
    private String person;

    public ItemLesson(String mp3Nomal, String mp3Slow, String enText, String localText, String person) {
        this.mp3Nomal = mp3Nomal;
        this.mp3Slow = mp3Slow;
        this.enText = enText;
        this.localText = localText;
        this.person = person;
    }

    public String getMp3Nomal() {
        return mp3Nomal;
    }

    public void setMp3Nomal(String mp3Nomal) {
        this.mp3Nomal = mp3Nomal;
    }

    public String getMp3Slow() {
        return mp3Slow;
    }

    public void setMp3Slow(String mp3Slow) {
        this.mp3Slow = mp3Slow;
    }

    public String getEnText() {
        return enText;
    }

    public void setEnText(String enText) {
        this.enText = enText;
    }

    public String getLocalText() {
        return localText;
    }

    public void setLocalText(String localText) {
        this.localText = localText;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}

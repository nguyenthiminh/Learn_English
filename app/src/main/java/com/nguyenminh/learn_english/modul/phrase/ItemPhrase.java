package com.nguyenminh.learn_english.modul.phrase;

/**
 * Created by Big Boss on 07/08/2018.
 */

public class ItemPhrase {
    private int stt;
    private String en_text;
    private String local_text;
    private String mp3_normal;
    private String mp3_slow;

    public ItemPhrase(int stt, String en_text, String local_text, String mp3_normal, String mp3_slow) {
        this.stt = stt;
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

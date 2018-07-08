package com.nguyenminh.learn_english.modul.video;

/**
 * Created by hieph on 7/7/2018.
 */

public class ITemVideo {

    private String item;
    private String text;
    private String content;
    private String link;

    public ITemVideo(String item,String text, String content, String link) {
        this.item = item;
        this.text = text;
        this.content = content;
        this.link = link;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

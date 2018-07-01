package com.nguyenminh.learn_english.modul;

/**
 * Created by hieph on 7/1/2018.
 */

public class Parsererror {
    private String style;
    private String h3;
    private String div;

    public Parsererror(String style, String h3, String div) {
        this.style = style;
        this.h3 = h3;
        this.div = div;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getH3() {
        return h3;
    }

    public void setH3(String h3) {
        this.h3 = h3;
    }

    public String getDiv() {
        return div;
    }

    public void setDiv(String div) {
        this.div = div;
    }
}

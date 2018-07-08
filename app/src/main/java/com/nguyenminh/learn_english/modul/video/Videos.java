package com.nguyenminh.learn_english.modul.video;

import java.util.List;

/**
 * Created by hieph on 7/8/2018.
 */

public class Videos {
    private int id;
    private List<ITemVideo> iTemVideos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ITemVideo> getiTemVideos() {
        return iTemVideos;
    }

    public void setiTemVideos(List<ITemVideo> iTemVideos) {
        this.iTemVideos = iTemVideos;
    }

    public Videos(int id, List<ITemVideo> iTemVideos) {

        this.id = id;
        this.iTemVideos = iTemVideos;
    }
}

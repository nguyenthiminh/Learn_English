package com.nguyenminh.learn_english.modul;

import java.util.List;

/**
 * Created by hieph on 7/1/2018.
 */

public class Lesson {
    private String enTitle;
    private String localTitle;
    private List<Parsererror> parsererrors;
    private List<Lessons> lessons;

    public Lesson(String enTitle, String localTitle, List<Parsererror> parsererrors, List<Lessons> lessons) {
        this.enTitle = enTitle;
        this.localTitle = localTitle;
        this.parsererrors = parsererrors;
        this.lessons = lessons;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }

    public String getLocalTitle() {
        return localTitle;
    }

    public void setLocalTitle(String localTitle) {
        this.localTitle = localTitle;
    }

    public List<Parsererror> getParsererrors() {
        return parsererrors;
    }

    public void setParsererrors(List<Parsererror> parsererrors) {
        this.parsererrors = parsererrors;
    }

    public List<Lessons> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lessons> lessons) {
        this.lessons = lessons;
    }
}

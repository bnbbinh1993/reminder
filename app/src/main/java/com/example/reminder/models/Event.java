package com.example.reminder.models;

public class Event {
    private int id;
    private String title;
    private String category;
    private String date;
    private String time;
    private String repeat;
    private String remind;
    private String ring;
    private String theme;
    private String ghim;

    public Event() {
    }

    public Event(int id, String title, String category, String date, String time, String repeat, String remind, String ring, String theme, String ghim) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.date = date;
        this.time = time;
        this.repeat = repeat;
        this.remind = remind;
        this.ring = ring;
        this.theme = theme;
        this.ghim = ghim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getRemind() {
        return remind;
    }

    public void setRemind(String remind) {
        this.remind = remind;
    }

    public String getRing() {
        return ring;
    }

    public void setRing(String ring) {
        this.ring = ring;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getGhim() {
        return ghim;
    }

    public void setGhim(String ghim) {
        this.ghim = ghim;
    }
}

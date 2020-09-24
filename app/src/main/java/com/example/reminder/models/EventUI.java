package com.example.reminder.models;

public class EventUI {
    private int id;
    private String title;
    private String description;
    private String category;
    private String date;
    private String time;
    private String repeat;
    private String remind;
    private String ring;
    private String theme;
    private String ghim;
    private String status;
    private int TimeUi;

    public EventUI() {
    }

    public EventUI(int id, String title, String description, String category, String date, String time, String repeat, String remind, String ring, String theme, String ghim, String status, int timeUi) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.date = date;
        this.time = time;
        this.repeat = repeat;
        this.remind = remind;
        this.ring = ring;
        this.theme = theme;
        this.ghim = ghim;
        this.status = status;
        TimeUi = timeUi;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTimeUi() {
        return TimeUi;
    }

    public void setTimeUi(int timeUi) {
        TimeUi = timeUi;
    }
}

package com.example.reminder.models;

public class TimeStopWatch {
    private int stt;
    private String time;
    private String timeTotals;

    public TimeStopWatch() {
    }

    public TimeStopWatch(int stt, String time, String timeTotals) {
        this.stt = stt;
        this.time = time;
        this.timeTotals = timeTotals;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeTotals() {
        return timeTotals;
    }

    public void setTimeTotals(String timeTotals) {
        this.timeTotals = timeTotals;
    }
}

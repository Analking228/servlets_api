package edu.school.cinema.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Log {
    private int     userId;
    private String  email;
    private String  date;
    private String  time;

    Log(){}

    Log(int userId, String email){
        this.userId = userId;
        this.email = email;
        Date now = new Date();
        DateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        time = formatterTime.format(now);
        date = formatterDate.format(now);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}

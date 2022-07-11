package edu.school.cinema.models;

import java.sql.Date;
import java.sql.Time;

public class Log {
    private int         logId;
    private String      userEmail;
    private String      ip;
    private Date        date;
    private Time   time;

    public Log(){}

    public Log(String userEmail, String ip){
        this.userEmail = userEmail;
        this.ip = ip;
        java.util.Date now = new java.util.Date();
        date = new java.sql.Date(now.getTime());
        time = new java.sql.Time(now.getTime());
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}

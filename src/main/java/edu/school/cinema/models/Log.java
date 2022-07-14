package edu.school.cinema.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
public class Log {
    private int         logId;
    private String      userEmail;
    private String      ip;
    private Date        date;
    private Time   time;

    public Log(String userEmail, String ip){
        this.userEmail = userEmail;
        this.ip = ip;
        java.util.Date now = new java.util.Date();
        date = new java.sql.Date(now.getTime());
        time = new java.sql.Time(now.getTime());
    }
}

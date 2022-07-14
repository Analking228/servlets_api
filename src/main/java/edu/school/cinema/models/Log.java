package edu.school.cinema.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Log {
    private int     userId;
    private String  email;
    private String  date;
    private String  time;

    Log(int userId, String email){
        this.userId = userId;
        this.email = email;
        Date now = new Date();
        DateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        time = formatterTime.format(now);
        date = formatterDate.format(now);
    }
}

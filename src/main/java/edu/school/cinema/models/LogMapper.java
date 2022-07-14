package edu.school.cinema.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogMapper implements RowMapper<Log> {
    @Override
    public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
        Log log = new Log();
        log.setLogId(rs.getInt("log_id"));
        log.setUserEmail(rs.getString("user_email"));
        log.setIp(rs.getString("ip"));
        log.setDate(rs.getDate("date"));
        log.setTime(rs.getTime("time"));
        return log;
    }
}

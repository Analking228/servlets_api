package edu.school.cinema.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogMapper implements RowMapper<Log> {
    @Override
    public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
        Log log = new Log();
        log.setUserId(rs.getInt("user_id"));
        log.setEmail(rs.getString("email"));
        log.setDate(rs.getString("date"));
        log.setTime(rs.getString("time"));
        return log;
    }
}

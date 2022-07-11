package edu.school.cinema.repositories;

import edu.school.cinema.models.Log;
import edu.school.cinema.models.LogMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class LogRepositoryImpl implements LogRepository<Log> {

    private final JdbcTemplate jdbcTemplate;

    public LogRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Log findById(long id) throws SQLException {
        return null;
    }

    @Override
    public List<Log> findAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Log item) throws SQLException {
        String sql = "INSERT INTO cinema.logs (user_email, ip, date, time) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, item.getUserEmail(), item.getIp(), item.getDate(), item.getTime());
    }

    @Override
    public void update(Log item) throws SQLException {

    }

    @Override
    public void delete(Log item) throws SQLException {

    }

    @Override
    public boolean findByEmail(String string) {
        return false;
    }

    @Override
    public Log findObjByEmail(String string) {
        return null;
    }

    @Override
    public List<Log> findAllByEmail(String email) {
        String sql = "select * from cinema.logs where user_email = ?";
        return jdbcTemplate.query(sql, new LogMapper(), email);
    }
}

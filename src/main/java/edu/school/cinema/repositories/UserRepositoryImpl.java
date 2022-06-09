package edu.school.cinema.repositories;

import edu.school.cinema.models.User;
import edu.school.cinema.models.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements UserRepository<User>{
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = "Select * FROM cinema.users";
        return this.jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void save(User item) throws SQLException {
        String  sql = "INSERT INTO cinema.users(login, password) values(?,?)";
        this.jdbcTemplate.update(sql, item.getLogin(), item.getPassword());
    }

    @Override
    public boolean findByEmail(String email) throws SQLException {
        String sql = "SELECT EXISTS (SELECT FROM cinema.users WHERE login = ?)";
        return Boolean.TRUE.equals(this.jdbcTemplate.queryForObject(sql, Boolean.class, email));
    }

    @Override
    public User findObjByEmail(String email) throws SQLException {
        String sql = "SELECT EXISTS (SELECT * FROM cinema.users WHERE login = ?)";
        List<User> users = this.jdbcTemplate.query(sql, new UserMapper(), email);
        if (!users.isEmpty())
            for (User u : users)
                return u;
        return null;
    }

    @Override
    public User findById(long id) throws SQLException {
        return null;
    }

    @Override
    public void delete(User item) throws SQLException {}

    @Override
    public void update(User item) throws SQLException {}
}

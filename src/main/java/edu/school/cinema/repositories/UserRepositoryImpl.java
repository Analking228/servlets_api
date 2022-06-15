package edu.school.cinema.repositories;

import edu.school.cinema.models.User;
import edu.school.cinema.models.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository<User>{
    private final PasswordEncoder   passwordEncoder;
    private final JdbcTemplate      jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = "Select * FROM cinema.users";
        return this.jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void save(User item) throws SQLException {
        String  sql = "INSERT INTO cinema.users(first_name, last_name, phone_number, email, password)" +
                " values(?,?,?,?,?)";
        String password = passwordEncoder.encode(item.getPassword());
        this.jdbcTemplate.update(sql, item.getFirstName(), item.getLastName(), item.getPhoneNumber(),
                item.getEmail(), password);
    }

    @Override
    public boolean findByEmail(String email) throws SQLException {
        String sql = "SELECT EXISTS (SELECT * FROM cinema.users WHERE email = ?)";
        return Boolean.TRUE.equals(this.jdbcTemplate.queryForObject(sql, Boolean.class, email));
    }

    @Override
    public User findObjByEmail(String email) throws SQLException {
        String sql = "(SELECT * FROM cinema.users WHERE email = ?)";
        return this.jdbcTemplate.queryForObject(sql, new UserMapper(), email);
    }

    @Override
    public boolean passwordMatch(String password, String email) throws SQLException {
        User user = this.findObjByEmail(email);
        return passwordEncoder.matches(password, user.getPassword());
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

package edu.school.cinema.services;

import edu.school.cinema.models.User;
import edu.school.cinema.repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    private final UserRepositoryImpl    userRepository;

    @Autowired
    public UserService(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) throws SQLException {
        return userRepository.findById(id);
    }

    public List<User> findAll() throws SQLException {
        return userRepository.findAll();
    }

    public void save(User item) throws SQLException {
        userRepository.save(item);
    }

    public void delete(User item) throws SQLException {
        userRepository.delete(item);
    }

    public void update(User item) throws SQLException {
        userRepository.update(item);
    }

    public boolean  findByEmail(String email) throws SQLException {
        return userRepository.findByEmail(email);
    }

    public User     findObjByEmail(String email) throws SQLException {
        return userRepository.findObjByEmail(email);
    }

    public boolean  passwordMatch(String password, String email) throws SQLException {
        return userRepository.passwordMatch(password, email);
    }
}

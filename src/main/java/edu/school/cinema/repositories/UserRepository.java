package edu.school.cinema.repositories;

import edu.school.cinema.models.User;
import java.sql.SQLException;

public interface UserRepository<T> extends CrudRepository<T> {
    boolean findByEmail(String login) throws SQLException;
    User    findObjByEmail(String login) throws SQLException;
    boolean cryptDataEquals(String password, String email) throws SQLException;
}

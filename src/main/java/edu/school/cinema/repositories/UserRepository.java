package edu.school.cinema.repositories;

import edu.school.cinema.models.User;
import java.sql.SQLException;

public interface UserRepository<T> extends CrudRepository<T> {
    boolean findByLogin(String login) throws SQLException;
    User    findObjByLogin(String login) throws SQLException;
}

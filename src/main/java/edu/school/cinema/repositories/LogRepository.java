package edu.school.cinema.repositories;

import java.sql.SQLException;
import java.util.List;

public interface LogRepository<T> extends CrudRepository<T> {
    boolean findByEmail(String string);
    T findObjByEmail(String string);
    List<T> findAllByEmail(String email);
}

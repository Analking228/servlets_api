package edu.school.cinema.repositories;

import java.sql.SQLException;
import java.util.List;

public interface ImageFileNamesRepository<T> extends CrudRepository<T> {
    T findByName(String imageFileName) throws SQLException;
    List<T> findAll() throws SQLException;
    void    save(T item) throws SQLException;
}

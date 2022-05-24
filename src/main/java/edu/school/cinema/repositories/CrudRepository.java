package edu.school.cinema.repositories;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository<T> {
    T       findById(long id)throws SQLException;
    List<T> findAll() throws SQLException;
    void    save(T item) throws SQLException;
    void    update(T item) throws SQLException;
    void    delete(T item) throws SQLException;
}

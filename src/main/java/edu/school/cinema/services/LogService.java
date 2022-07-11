package edu.school.cinema.services;

import edu.school.cinema.models.Log;
import edu.school.cinema.repositories.LogRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class LogService {
    private final LogRepositoryImpl logRepository;

    @Autowired
    public LogService(LogRepositoryImpl logRepository) {
        this.logRepository = logRepository;
    }

    public void save(Log item) throws SQLException {
        this.logRepository.save(item);
    }

    public List<Log> findAllByEmail(String email) {
        return this.logRepository.findAllByEmail(email);
    }
}

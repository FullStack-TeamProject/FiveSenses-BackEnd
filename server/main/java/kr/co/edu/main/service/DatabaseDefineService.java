package kr.co.edu.main.service;

import kr.co.edu.main.mapper.DatabaseDefineMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Service
public class DatabaseDefineService {

    private final DatabaseDefineMapper databaseDefineMapper;

    public DatabaseDefineService(DatabaseDefineMapper databaseDefineMapper) {this.databaseDefineMapper = databaseDefineMapper;}

    @PostConstruct
    public void init() {
        databaseDefineMapper.createTable();
    }
}
